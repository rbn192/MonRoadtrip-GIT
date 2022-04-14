import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css', '../../../app.component.css'],
})
export class PaiementComponent implements OnInit {
  carteChecked: string = '';
  paypalChecked: string = '';
  boxChecked: string = '';

  constructor() {}

  ngOnInit(): void {}
}
