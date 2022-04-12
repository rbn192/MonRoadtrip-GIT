import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-itineraire',
  templateUrl: './itineraire.component.html',
  styleUrls: ['./itineraire.component.css', '../../app.component.css'],
})
export class ItineraireComponent implements OnInit {
  depart: string = '';
  arrivee: string = '';

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.depart = params['depart'];
      this.arrivee = params['arrivee'];
      console.log(this.depart);
    });
  }
}
