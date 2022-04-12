import { EtapeService } from './../../../services/etape.service';
import { Component, OnInit } from '@angular/core';
import { Etape } from 'src/app/model/etape';
import { Reservation } from 'src/app/model/reservation';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-etape-list',
  templateUrl: './etape-list.component.html',
  styleUrls: ['./etape-list.component.css', '../../../app.component.css'],
})
export class EtapeListComponent implements OnInit {
  etape: Etape = new Etape();
  etapes: Etape[] = [];
  reservation: Reservation = new Reservation();

  constructor(private etapeService: EtapeService, private aR: ActivatedRoute) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.etapeService
          .getAllByReservation(params['id'])
          .subscribe((result) => {
            this.etapes = result;
          });
      }
    });
  }
}
