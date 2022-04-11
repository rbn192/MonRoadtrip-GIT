import { CompteService } from './../../services/compte.service';
import { Compte } from './../../model/compte';
import { ConnexionService } from './../../services/connexion.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  login: string = '';
  password: string = '';
  err: boolean = false;
  message: string = '';
  compte: Compte = new Compte();

  constructor(
    private authService: ConnexionService,
    private router: Router,
    private aR: ActivatedRoute,
    private compteService: CompteService
  ) {}

  ngOnInit(): void {
    this.aR.queryParams.subscribe((params) => {
      if (params['auth']) {
        this.err = true;
        this.message = 'Connexion requise';
      }
    });
  }

  check() {
    this.authService.authentication(this.login, this.password).subscribe({
      next: (value: Compte) => {
        localStorage.setItem('login', this.login);
        localStorage.setItem(
          'token',
          'Basic ' + btoa(this.login + ':' + this.password)
        );
        localStorage.setItem('role', value.type!);
        localStorage.setItem('prenom', value.prenom!);
        console.log(value);
        this.err = false;

        this.router.navigateByUrl('compte/edit/' + this.login);
      },
      error: (error: any) => {
        this.err = true;
        this.message = 'Informations incorrectes';
      },
    });
  }
}
