import { Categorie } from '../../../model/categorie';
import { ActiviteService } from '../../../services/activite.service';
import { Activite } from '../../../model/activite';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-activite-list',
  templateUrl: './activite-list.component.html',
  styleUrls: ['./activite-list.component.css'],
})
export class AcliviteListComponent implements OnInit {
  activites: Activite[] = [];

  constructor(private activiteService: ActiviteService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.activiteService.getAll().subscribe((result) => {
      this.activites = result;
    });
  }

  delete(id: number) {
    this.activiteService.delete(id).subscribe((ok) => {
      this.list();
    });
  }
}
