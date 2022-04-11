import { LogementService } from './../../../services/logement.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Logement } from './../../../model/logement';
import { Component, OnInit } from '@angular/core';
import { Adresse } from 'src/app/model/adresse';

@Component({
  selector: 'app-logement-edit',
  templateUrl: './logement-edit.component.html',
  styleUrls: ['./logement-edit.component.css'],
})
export class LogementEditComponent implements OnInit {
  logement: Logement = new Logement();
  logements: Logement[] = [];

  constructor(
    private aR: ActivatedRoute,
    private logementService: LogementService,
    private router: Router
  ) {
    this.logement.adresse = new Adresse();
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.logementService.get(params['id']).subscribe((result) => {
          this.logement = result;
        });
      }
    });
  }

  save() {
    if (this.logement.id) {
      this.logementService.update(this.logement).subscribe((result) => {
        console.log(this.logement.adresse);
        console.log(result.adresse);
        this.goList();
      });
    } else {
      this.logementService.create(this.logement).subscribe((result) => {
        this.goList();
        console.log(this.logement.adresse);
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/logement');
  }

  byId(obj1: Logement, obj2: Logement) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    return false;
  }
}
