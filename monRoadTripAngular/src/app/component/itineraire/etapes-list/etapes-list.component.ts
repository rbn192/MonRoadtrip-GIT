import { Participant } from 'src/app/model/participant';
import { ReservationService } from './../../../services/reservation.service';
import { map } from 'rxjs';
import { FormArray, FormGroup, FormControl } from '@angular/forms';
import { EtapeService } from 'src/app/services/etape.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Etape } from 'src/app/model/etape';

@Component({
  selector: 'app-etapes-list',
  templateUrl: './etapes-list.component.html',
  styleUrls: ['./etapes-list.component.css', '../../../app.component.css'],
})
export class EtapesListComponent implements OnInit {
  form: FormGroup;
  etapes: Etape[] = [];
  participants: number[] = [];

  etapesReservees: number[] = [];

  constructor(
    private router: Router,
    private etapeService: EtapeService,
    private reservationService: ReservationService
  ) {
    this.form = new FormGroup({ etapesArray: new FormArray([]) });
  }

  ngOnInit(): void {
    this.list();
  }

  get etapesArray(): FormArray {
    return this.form.get('etapesArray') as FormArray;
  }

  ajoutParticipants(value: number[]) {
    this.participants = value;
    console.log('Ca marche? ' + this.participants);
  }

  list() {
    this.etapeService.getAll().subscribe((result) => {
      this.etapes = result;
      let formArray = this.form.get('etapesArray') as FormArray;
      this.etapes.forEach((etape) => {
        formArray.push(new FormControl(false));
      });
    });
  }

  submit() {
    const selectedEtapesIds = this.form.value.etapesArray
      .map((checked: boolean, i: number) =>
        checked ? this.etapes[i].id : null
      )
      .filter((v: any) => v !== null);
    this.etapesReservees = selectedEtapesIds;
    this.reservation();
    this.redirect();
  }

  reservation() {
    let etapes: any[] = [];
    this.etapesReservees.forEach((etape) => {
      let e = { id: etape };
      etapes.push(e);
    });
    let reservation = {
      statut: 'A_venir',
      etapes: etapes,
      client: { id: '4', type: 'client' },
      roadtrip: { id: '1' },
      participant: { id: '1' },
    };
    this.reservationService.create(reservation).subscribe((ok) => {});
    console.log(etapes);
    console.log(reservation);
  }

  redirect() {
    this.router.navigateByUrl('/itineraire/reservations');
  }

  redirect() {
    this.router.navigateByUrl('/itineraire/reservations');
  }
}
