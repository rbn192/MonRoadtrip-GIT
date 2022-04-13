import { Organisateur } from './../../../model/organisateur';
import { Categorie } from '../../../model/categorie';
import { ActiviteService } from '../../../services/activite.service';
import { Activite } from '../../../model/activite';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-activite-list',
  templateUrl: './activite-list.component.html',
  styleUrls: ['./activite-list.component.css', '../../../app.component.css'],
})
export class AcliviteListComponent implements OnInit {
  activites: Activite[] = [];
  organisateur: Organisateur = new Organisateur();

  constructor(private activiteService: ActiviteService) {}

  ngOnInit(): void {
    this.list(localStorage.getItem('login')!);
  }

  list(mail: string) {
    this.activiteService.getAllByOrganisateur(mail).subscribe((result) => {
      this.activites = result;
    });
  }

  delete(id: number) {
    this.activiteService.delete(id).subscribe((ok) => {
      this.list(localStorage.getItem('login')!);
    });
  }
}
