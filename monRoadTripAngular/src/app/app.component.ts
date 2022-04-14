import { CompteService } from './services/compte.service';
import { Router } from '@angular/router';
import { ConnexionService } from './services/connexion.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'monRoadTripAngular';
  _prenom: string = '';

  public constructor(
    private authService: ConnexionService,
    private compteService: CompteService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (this.login != null) {
      this.compteService
        .getCompteByMail(localStorage.getItem('login')!)
        .subscribe((result) => {
          this._prenom = result.prenom!;
        });
    }

  }

  get prenom() {
    return localStorage.getItem('prenom');
  }

  get role() {
    return localStorage.getItem('role');
  }

  get login() {
    return localStorage.getItem('login');
  }

  isAutenticated() {
    return this.authService.isAuthenticated();
  }
  gestionCompte() {
    this.router.navigateByUrl('/compte/edit');
  }
  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/home');
  }
}
