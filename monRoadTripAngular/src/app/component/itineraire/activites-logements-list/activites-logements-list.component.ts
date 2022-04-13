import { ActiviteService } from './../../../services/activite.service';
import { LogementService } from './../../../services/logement.service';
import { Logement } from './../../../model/logement';
import { Component, OnInit } from '@angular/core';
import { Activite } from 'src/app/model/activite';
import { FormArray, FormControl, FormGroup } from '@angular/forms';
import { EtapeService } from 'src/app/services/etape.service';

@Component({
  selector: 'app-activites-logements-list',
  templateUrl: './activites-logements-list.component.html',
  styleUrls: [
    './activites-logements-list.component.css',
    '../../../app.component.css',
  ],
})
export class ActivitesLogementsListComponent implements OnInit {
  form: FormGroup;
  activites: Activite[] = [];
  logements: Logement[] = [];

  activitesReservees: number[] = [];
  logementsReserves: number = 0;

  isChecked: boolean = false;
  ville: string = '';
  constructor(
    private activiteService: ActiviteService,
    private logementService: LogementService,
    private etapeService: EtapeService
  ) {
    this.form = new FormGroup({
      logementsArray: new FormArray([]),
      activitesArray: new FormArray([]),
    });
  }

  ngOnInit(): void {}

  get logementsArray(): FormArray {
    return this.form.get('logementsArray') as FormArray;
  }
  get activitesArray(): FormArray {
    return this.form.get('activitesArray') as FormArray;
  }

  list() {
    this.activiteService.getAllByVille(this.ville).subscribe((result) => {
      this.activites = result;
      let formArray = this.form.get('activitesArray') as FormArray;
      this.activites.forEach((activite) => {
        formArray.push(new FormControl(false));
      });
    });
    this.logementService.getAllByVille(this.ville).subscribe((result) => {
      this.logements = result;
      let formArray = this.form.get('logementsArray') as FormArray;
      this.logements.forEach((logement) => {
        formArray.push(new FormControl(false));
      });
    });
  }

  resaLogements() {
    let etape = {
      duree: '2',
      date: '2022-07-29',
      ville: this.ville,
      logement: {
        id: this.logementsReserves,
      },
      activites: null,
    };
    console.log(etape);
    this.etapeService.create(etape).subscribe((ok) => {
      this.activitesReservees.forEach((activite) => {
        this.etapeService.addActivite(ok, activite).subscribe((result) => {});
      });
    });
  }

  submit() {
    const selectedLogementsIds = this.form.value.logementsArray
      .map((checked: boolean, i: number) =>
        checked ? this.logements[i].id : null
      )
      .filter((v: any) => v !== null);

    this.logementsReserves = selectedLogementsIds[0];
    console.log(this.logementsReserves);
    const selectedActivitesIds = this.form.value.activitesArray
      .map((checked: boolean, i: number) =>
        checked ? this.activites[i].id : null
      )
      .filter((v: any) => v !== null);

    this.activitesReservees = selectedActivitesIds;
    console.log(this.activitesReservees);

    this.resaLogements();
  }
}
