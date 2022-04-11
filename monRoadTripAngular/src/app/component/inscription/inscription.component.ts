import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  client() {
    this.router.navigateByUrl('/inscription/client');
  }
  hote() {
    this.router.navigateByUrl('/inscription/hote');
  }
  organisateur() {
    this.router.navigateByUrl('/inscription/organisateur');
  }
}
