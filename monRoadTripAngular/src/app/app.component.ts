import { ConnexionService } from './services/connexion.service';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'monRoadTripAngular';

  public constructor(private authService: ConnexionService) {}

  get login() {
    return localStorage.getItem('login');
  }

  isAutenticated() {
    return this.authService.isAuthenticated();
  }

  logout() {
    localStorage.clear();
  }
}
