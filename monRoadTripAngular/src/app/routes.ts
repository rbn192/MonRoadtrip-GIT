import { InscriptionComponent } from './component/inscription/inscription.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'inscription', component: InscriptionComponent },
  { path: '**', component: PageNotFoundComponent },
];
