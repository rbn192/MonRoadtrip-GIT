import { ActiviteService } from './../../../services/activite.service';
import { LogementService } from './../../../services/logement.service';
import { Logement } from './../../../model/logement';
import { Component, OnInit } from '@angular/core';
import { Activite } from 'src/app/model/activite';

@Component({
  selector: 'app-activites-logements-list',
  templateUrl: './activites-logements-list.component.html',
  styleUrls: [
    './activites-logements-list.component.css',
    '../../../app.component.css',
  ],
})
export class ActivitesLogementsListComponent implements OnInit {
  activites: Activite[] = [];
  logements: Logement[] = [];
  ville: string = '';
  constructor(
    private activiteService: ActiviteService,
    private logementService: LogementService
  ) {}

  ngOnInit(): void {}

  list() {
    this.activiteService.getAllByVille(this.ville).subscribe((result) => {
      this.activites = result;
    });
    this.logementService.getAllByVille(this.ville).subscribe((result) => {
      this.logements = result;
    });
  }
}
