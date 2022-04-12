import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ConnexionService } from './../../services/connexion.service';
import { CompteService } from './../../services/compte.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css', '../../app.component.css'],
})
export class HomeComponent implements OnInit {
  depart: string = '';
  arrivee: string = '';

  login: string = '';
  prenom: string = '';

  constructor(
    private connexionService: ConnexionService,
    private http: HttpClient,
    private compteService: CompteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.login = localStorage.getItem('login')!;
    this.compteService.getCompteByMail(this.login)!.subscribe((result) => {
      this.prenom = result.prenom!;
    });
  }

  connected(): boolean {
    return this.connexionService.isAuthenticated();
  }

  gestionCompte() {
    this.router.navigateByUrl('/compte/edit/' + this.login);
  }
  recherche() {
    this.router.navigate(['/itineraire/', this.depart, this.arrivee]);
  }
  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/home');
  }
}
