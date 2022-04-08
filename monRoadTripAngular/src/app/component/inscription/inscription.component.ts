import { Observable } from 'rxjs';
import { CompteService } from './../../services/compte.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form: FormGroup;

  constructor(private compteService: CompteService, private router: Router) {
    this.form = new FormGroup({
      emailPasswordGroup: new FormGroup(
        {
          email: new FormControl(
            '',
            [Validators.required, Validators.email]
            //this.checkEmail()
          ),
          passwordGroup: new FormGroup(
            {
              password: new FormControl('', [Validators.required]),
              confirm: new FormControl('', Validators.required),
            },
            this.passwordAndConfirmEquals
          ),
        },
        this.mailAndPasswordNotEquals
      ),
      type: new FormControl('', Validators.required),
      nom: new FormControl('', Validators.required),
      prenom: new FormControl('', Validators.required),
      dateNaissance: new FormControl('', Validators.required),
      numero: new FormControl('', Validators.required),
      voie: new FormControl('', Validators.required),
      cp: new FormControl('', Validators.required),
      ville: new FormControl('', Validators.required),
    });
  }

  /*
  checkEmail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.compteService.findByEmail(control.value).pipe(
        debounceTime(1000),
        map((result) => {
          return result ? { emailExist: true } : null;
        })
      );
    };
  }
  */

  mailAndPasswordNotEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('email')?.invalid || group.get('passwordGroup')?.invalid) {
      return null;
    }
    return group.get('email')?.value ==
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
      type: this.form.get('type')?.value,
      nom: this.form.get('nom')?.value,
      prenom: this.form.get('prenom')?.value,
      mail: this.form.get('emailPasswordGroup.email')?.value,
      password: this.form.get('emailPasswordGroup.passwordGroup.password')
        ?.value,
      dateNaissance: this.form.get('dateNaissance')?.value,
      adresse: {
        numero: this.form.get('numero')?.value,
        voie: this.form.get('voie')?.value,
        cp: this.form.get('cp')?.value,
        ville: this.form.get('ville')?.value,
      },
    };
    this.compteService.inscriptionClient(compte).subscribe((ok) => {
      this.router.navigateByUrl('/home');
    });
    console.log(compte);
  }
}
