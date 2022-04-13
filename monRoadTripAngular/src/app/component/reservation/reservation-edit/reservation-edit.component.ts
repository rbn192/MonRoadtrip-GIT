import { ParticipantService } from './../../../services/participant.service';
import { ReservationService } from './../../../services/reservation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Statut } from './../../../model/statut';
import { Reservation } from './../../../model/reservation';
import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/model/client';
import { Participant } from 'src/app/model/participant';
import { Roadtrip } from 'src/app/model/roadtrip';

@Component({
  selector: 'app-reservation-edit',
  templateUrl: './reservation-edit.component.html',
  styleUrls: ['./reservation-edit.component.css', '../../../app.component.css'],
})
export class ReservationEditComponent implements OnInit {
  reservation: Reservation = new Reservation();
  participant: Participant = new Participant();
  reservations: Reservation[] = [];
  statuts = Statut;
  client: Client = new Client();

  constructor(
    private aR: ActivatedRoute,
    private reservationService: ReservationService,
    private participantService: ParticipantService,
    private router: Router
  ) {
    this.reservation.participant = new Participant();
    this.reservation.participant.id;
    this.reservation.roadtrip = new Roadtrip();
    this.reservation.client = new Client();
    this.reservation.client.id = parseInt(localStorage.getItem('id')!);
    this.reservation.client.prenom = localStorage.getItem('prenom')!;
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.reservationService.get(params['id']).subscribe((result) => {
          this.reservation = result;
        });
      }
    });
  }

  save() {
    this.saveParticipant();
    this.reservation.participant = this.participant;
    console.log('id ' + this.reservation.participant.id);
    if (this.reservation.id) {
      this.reservationService.update(this.reservation).subscribe((result) => {
        this.goList();
      });
    } else {
      this.reservationService.create(this.reservation).subscribe((result) => {
        this.goList();
      });
    }
  }

  saveParticipant() {
    if (this.participant?.id) {
      this.participantService
        .update(this.participant)
        .subscribe((result) => {});
    } else {
      this.participantService
        .create(this.participant)
        .subscribe((result) => {});
    }
  }

  goList() {
    this.router.navigateByUrl('/reservation');
  }
}
