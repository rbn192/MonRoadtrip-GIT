import { Participant } from './../../../model/participant';
import { Roadtrip } from './../../../model/roadtrip';
import { Reservation } from './../../../model/reservation';
import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css', '../../../app.component.css'],
})
export class ReservationListComponent implements OnInit {
  reservations: Reservation[] = [];
  reservation: Reservation = new Reservation();
  roadtrip: Roadtrip = new Roadtrip();
  participant: Participant = new Participant();

  constructor(private reservationService: ReservationService) {}

  ngOnInit(): void {
    this.list(localStorage.getItem('login')!);
  }

  list(mail: string) {
    this.reservationService.getAllByClient(mail).subscribe((result) => {
      this.reservations = result;
    });
  }

  delete(id: number) {
    this.reservationService.delete(id).subscribe((ok) => {
      this.list(localStorage.getItem('login')!);
    });
  }
}
