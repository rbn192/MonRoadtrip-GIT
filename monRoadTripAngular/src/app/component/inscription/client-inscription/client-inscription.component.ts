import { debounceTime, map, Observable } from 'rxjs';
import { CompteService } from './../../../services/compte.service';
import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-inscription',
  templateUrl: './client-inscription.component.html',
  styleUrls: [
    './client-inscription.component.css',
    '../../../app.component.css',
  ],
})
export class ClientInscriptionComponent implements OnInit {
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
      adresseGroup: new FormGroup({
        numero: new FormControl('', Validators.required),
        voie: new FormControl('', Validators.required),
        cp: new FormControl('', Validators.required),
        ville: new FormControl('', Validators.required),
      }),
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
      type: 'client',
      nom: this.form.get('nom')?.value,
      prenom: this.form.get('prenom')?.value,
      mail: this.form.get('mailPasswordGroup.mail')?.value,
      password: this.form.get('mailPasswordGroup.passwordGroup.password')
        ?.value,
      dateNaissance: this.form.get('dateNaissance')?.value,
      adresse: {
        numero: this.form.get('adresseGroup.numero')?.value,
        voie: this.form.get('adresseGroup.voie')?.value,
        cp: this.form.get('adresseGroup.cp')?.value,
        ville: this.form.get('adresseGroup.ville')?.value,
      },
    };
    this.compteService.inscriptionCompte(compte).subscribe((ok) => {
      this.router.navigateByUrl('/home');
    });
    console.log(compte);
  }
}
