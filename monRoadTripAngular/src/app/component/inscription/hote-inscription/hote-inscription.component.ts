import { Router } from '@angular/router';
import { CompteService } from './../../../services/compte.service';
import { debounceTime, map, Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-hote-inscription',
  templateUrl: './hote-inscription.component.html',
  styleUrls: ['./hote-inscription.component.css', '../../../app.component.css'],
})
export class HoteInscriptionComponent implements OnInit {
  form: FormGroup;

  constructor(private compteService: CompteService, private router: Router) {
    this.form = new FormGroup({
      mailPasswordGroup: new FormGroup(
        {
          mail: new FormControl(
            '',
            [Validators.required, Validators.email],
            this.checkMail()
          ),
          passwordGroup: new FormGroup(
            {
              password: new FormControl('', [
                Validators.required,
                Validators.pattern(
                  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[*_!@-])([a-zA-Z0-9*_!@-]{5,25})$/
                ),
              ]),
              confirm: new FormControl('', Validators.required),
            },
            this.passwordAndConfirmEquals
          ),
        },
        this.mailAndPasswordNotEquals
      ),
      nom: new FormControl('', Validators.required),
      prenom: new FormControl('', Validators.required),
      dateNaissance: new FormControl('', Validators.required),
    });
  }

  checkMail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.compteService.findByMail(control.value).pipe(
        debounceTime(1000),
        map((result) => {
          return result ? { mailExist: true } : null;
        })
      );
    };
  }

  mailAndPasswordNotEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('mail')?.invalid || group.get('passwordGroup')?.invalid) {
      return null;
    }
    return group.get('mail')?.value ==
      group.get('passwordGroup.password')?.value
      ? { mailAndPasswordEquals: true }
      : null;
  }

  passwordAndConfirmEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('password')?.errors) {
      return null;
    }
    return group.get('password')?.value == group.get('confirm')?.value
      ? null
      : { passwordAndConfirmNotEquals: true };
  }

  ngOnInit(): void {}

  submit() {
    let compte = {
      type: 'hote',
      nom: this.form.get('nom')?.value,
      prenom: this.form.get('prenom')?.value,
      mail: this.form.get('mailPasswordGroup.mail')?.value,
      password: this.form.get('mailPasswordGroup.passwordGroup.password')
        ?.value,
      dateNaissance: this.form.get('dateNaissance')?.value,
    };
    this.compteService.inscriptionCompte(compte).subscribe((ok) => {
      this.router.navigateByUrl('/connexion');
    });
    console.log(compte);
  }
}
