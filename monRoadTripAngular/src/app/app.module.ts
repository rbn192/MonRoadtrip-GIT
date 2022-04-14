import { ActiviteEditComponent } from './component/activite/activite-edit/activite-edit.component';
import { AcliviteListComponent } from './component/activite/activite-list/activite-list.component';
import { routes } from './routes';
import { NgModule, enableProdMode } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { LogementEditComponent } from './component/logement/logement-edit/logement-edit.component';
import { LogementListComponent } from './component/logement/logement-list/logement-list.component';
import { HomeComponent } from './component/home/home.component';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { CompteModifComponent } from './component/compte-modif/compte-modif.component';
import { HoteInscriptionComponent } from './component/inscription/hote-inscription/hote-inscription.component';
import { OrganisateurInscriptionComponent } from './component/inscription/organisateur-inscription/organisateur-inscription.component';
import { ClientInscriptionComponent } from './component/inscription/client-inscription/client-inscription.component';
import { ItineraireComponent } from './component/itineraire/itineraire.component';
import { ActivitesLogementsListComponent } from './component/itineraire/activites-logements-list/activites-logements-list.component';

import { EtapeListComponent } from './component/etape/etape-list/etape-list.component';
import { EtapeEditComponent } from './component/etape/etape-edit/etape-edit.component';
import { ReservationEditComponent } from './component/reservation/reservation-edit/reservation-edit.component';
import { ReservationListComponent } from './component/reservation/reservation-list/reservation-list.component';
import { EtapesListComponent } from './component/itineraire/etapes-list/etapes-list.component';
import { ReservationsListComponent } from './component/itineraire/reservations-list/reservations-list.component';
import { MapComponent } from './component/map/map.component';
import { ParticipantComponent } from './component/participant/participant.component';
import { ReservationsListComponent } from './component/itineraire/reservations-list/reservations-list.component';
import { PaiementComponent } from './component/itineraire/paiement/paiement.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    ActiviteEditComponent,
    AcliviteListComponent,
    LogementEditComponent,
    LogementListComponent,
    HomeComponent,
    InscriptionComponent,
    ConnexionComponent,
    CompteModifComponent,
    HoteInscriptionComponent,
    OrganisateurInscriptionComponent,
    ClientInscriptionComponent,
    ItineraireComponent,
    ReservationEditComponent,
    ReservationListComponent,
    EtapeListComponent,
    EtapeEditComponent,
    ActivitesLogementsListComponent,
    MapComponent,
    EtapesListComponent,
    ReservationsListComponent,
    ParticipantComponent,
    ReservationsListComponent,
    PaiementComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
