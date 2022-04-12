import { ClientInscriptionComponent } from './../inscription/client-inscription/client-inscription.component';
import { Adresse } from './../../model/adresse';
import { Compte } from './../../model/compte';
import { Router, ActivatedRoute } from '@angular/router';
import { CompteService } from './../../services/compte.service';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';

@Component({
  selector: 'app-compte-modif',
  templateUrl: './compte-modif.component.html',
  styleUrls: ['./compte-modif.component.css', '../../app.component.css'],
})
export class CompteModifComponent implements OnInit {
  compte: Compte = new Compte();
  prenom: string = '';
  password: string = '';
  passwordModif: string = 'passModif';
  form: FormGroup;

  constructor(
    private compteService: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.compte.adresse = new Adresse();
    this.form = new FormGroup(
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
    );
  }

  ngOnInit(): void {
    /*this.activatedRoute.params.subscribe((params) => {
      if (params['login']) {
        this.compteService
          .getCompteByMail(params['login'])
          .subscribe((result) => {
            this.compte = result;
            console.log('result ' + result);
            console.log('prenom ' + this.compte.prenom);
          });
      }
    });*/

    if (localStorage.getItem('login')) {
      console.log('login ' + localStorage.getItem('login')!);
      this.compteService
        .getCompteByMail(localStorage.getItem('login')!)
        .subscribe((result) => {
          console.log('subscribe');
          this.compte = result;
          console.log('compte ' + this.compte);
        });
    }
  }

  edit() {
    if (this.compte.id) {
      console.log('yes : ' + this.compte.password);
      this.password = this.compte.password!;
      console.log('pass ' + this.compte.password);
      this.compteService.update(this.compte).subscribe((result) => {
        console.log(this.password),
          ((this.compte = result), (this.compte.password = this.password)),
          this.goList();
      });
    } else {
      console.log("création d'un nouveau compte");
    }
  }

  editPassword() {
    this.compte.password = this.form.get('password')!.value;
    console.log('compte pass ' + this.compte.password);
    this.compteService.update(this.compte).subscribe((result) => {
      console.log('password ' + this.compte.password),
        (this.compte = result),
        this.goList();
    });
  }

  goList() {
    this.router.navigateByUrl('/home');
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
}
