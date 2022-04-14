import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css', '../../../app.component.css'],
})
export class PaiementComponent implements OnInit {
  public carteChecked: boolean = false;

  constructor() {}

  ngOnInit(): void {}
}
