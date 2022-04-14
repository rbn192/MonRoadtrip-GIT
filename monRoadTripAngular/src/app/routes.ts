import { MapComponent } from './component/map/map.component';
import { ReservationsListComponent } from './component/itineraire/reservations-list/reservations-list.component';
import { EtapesListComponent } from './component/itineraire/etapes-list/etapes-list.component';
import { ReservationEditComponent } from './component/reservation/reservation-edit/reservation-edit.component';
import { ItineraireComponent } from './component/itineraire/itineraire.component';
import { OrganisateurInscriptionComponent } from './component/inscription/organisateur-inscription/organisateur-inscription.component';
import { HoteInscriptionComponent } from './component/inscription/hote-inscription/hote-inscription.component';
import { ClientInscriptionComponent } from './component/inscription/client-inscription/client-inscription.component';
import { AcliviteListComponent } from './component/activite/activite-list/activite-list.component';
import { LogementListComponent } from './component/logement/logement-list/logement-list.component';
import { LogementEditComponent } from './component/logement/logement-edit/logement-edit.component';
import { ActiviteEditComponent } from './component/activite/activite-edit/activite-edit.component';
import { CompteModifComponent } from './component/compte-modif/compte-modif.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { HomeComponent } from './component/home/home.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { Routes } from '@angular/router';
import { ReservationListComponent } from './component/reservation/reservation-list/reservation-list.component';
import { EtapeListComponent } from './component/etape/etape-list/etape-list.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'activite', component: AcliviteListComponent },
  { path: 'activite/edit/:id', component: ActiviteEditComponent },
  { path: 'activite/add', component: ActiviteEditComponent },
  { path: 'logement', component: LogementListComponent },
  { path: 'logement/edit/:id', component: LogementEditComponent },
  { path: 'logement/add', component: LogementEditComponent },

  { path: 'connexion', component: ConnexionComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'inscription/client', component: ClientInscriptionComponent },
  { path: 'inscription/hote', component: HoteInscriptionComponent },
  {
    path: 'inscription/organisateur',
    component: OrganisateurInscriptionComponent,
  },
  { path: 'compte/edit', component: CompteModifComponent },
  { path: 'reservation', component: ReservationListComponent },
  { path: 'reservation/add', component: ReservationEditComponent },
  { path: 'reservation/edit/:id', component: ReservationEditComponent },
  { path: 'etape', component: EtapeListComponent },
  { path: 'etape/reservation/:id', component: EtapeListComponent },
  { path: 'itineraire/:depart/:arrivee', component: ItineraireComponent },
  { path: 'map', component: MapComponent },
  { path: 'itineraire/etapes', component: EtapesListComponent },
  { path: 'itineraire/reservations', component: ReservationsListComponent },
  //{ path: 'compte/edit/:login', component: CompteModifComponent },
  { path: '**', component: PageNotFoundComponent },
];
