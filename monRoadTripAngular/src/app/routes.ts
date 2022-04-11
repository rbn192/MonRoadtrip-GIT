import { OrganisateurInscriptionComponent } from './component/inscription/organisateur-inscription/organisateur-inscription.component';
import { HoteInscriptionComponent } from './component/inscription/hote-inscription/hote-inscription.component';
import { ClientInscriptionComponent } from './component/inscription/client-inscription/client-inscription.component';
import { CompteModifComponent } from './component/compte-modif/compte-modif.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { HomeComponent } from './component/home/home.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'inscription/client', component: ClientInscriptionComponent },
  { path: 'inscription/hote', component: HoteInscriptionComponent },
  {
    path: 'inscription/organisateur',
    component: OrganisateurInscriptionComponent,
  },
  { path: 'compte/edit', component: CompteModifComponent },
  //{ path: 'compte/edit/:login', component: CompteModifComponent },
  { path: '**', component: PageNotFoundComponent },
];
