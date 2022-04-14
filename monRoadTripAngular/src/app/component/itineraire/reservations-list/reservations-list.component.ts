import { Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';
import { Participant } from 'src/app/model/participant';
import { Roadtrip } from 'src/app/model/roadtrip';
import { Reservation } from 'src/app/model/reservation';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reservations-list',
  templateUrl: './reservations-list.component.html',
  styleUrls: [
    './reservations-list.component.css',
    '../../../app.component.css',
  ],
})
export class ReservationsListComponent implements OnInit {
  reservations: Reservation[] = [];
  reservation: Reservation = new Reservation();

  constructor(
    private reservationService: ReservationService,
    private router: Router
  ) {}

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

  redirection() {
    this.router.navigateByUrl('/itineraire/paiement');
  }

  getRandomInt(): number {
    return (this.prix = Math.floor(Math.random() * (300 - 50 + 1)) + 50);
  }
  prix: number = this.getRandomInt();
}
