import { Organisateur } from './../../../model/organisateur';
import { Categorie } from './../../../model/categorie';
import { ActiviteService } from './../../../services/activite.service';
import { Activite } from './../../../model/activite';
import { Adresse } from './../../../model/adresse';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-activite-edit',
  templateUrl: './activite-edit.component.html',
  styleUrls: ['./activite-edit.component.css', '../../../app.component.css'],
})
export class ActiviteEditComponent implements OnInit {
  activite: Activite = new Activite();
  activites: Activite[] = [];
  categories = Categorie;

  constructor(
    private aR: ActivatedRoute,
    private activiteService: ActiviteService,
    private router: Router
  ) {
    this.activite.adresse = new Adresse();
    this.activite.organisateur = new Organisateur();
    this.activite.organisateur.id = parseInt(localStorage.getItem('id')!);
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.activiteService.get(params['id']).subscribe((result) => {
          this.activite = result;
        });
      }
    });
  }

  save() {
    if (this.activite.id) {
      this.activiteService.update(this.activite).subscribe((result) => {
        this.goList();
      });
    } else {
      this.activiteService.create(this.activite).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/activite');
  }

  byId(obj1: Activite, obj2: Activite) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    return false;
  }
}
