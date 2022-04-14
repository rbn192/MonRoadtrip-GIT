import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css', '../../../app.component.css'],
})
export class PaiementComponent implements OnInit {
  carteChecked: string = '';
  paypalChecked: string = '';
  boxChecked: string = '';

  constructor(private router: Router) {}

  ngOnInit(): void {}

  validerPaiement() {
    this.router.navigateByUrl('/home');
    alert('Paiement accepté, préparez-vous pour votre roadtrip !');
  }
}
