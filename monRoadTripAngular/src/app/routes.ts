import { HomeComponent } from './component/home/home.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'connexion', component: ConnexionComponent },
  { path: '**', component: PageNotFoundComponent },
];
