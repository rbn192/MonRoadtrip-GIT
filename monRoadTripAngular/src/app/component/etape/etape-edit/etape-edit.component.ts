import { ActivatedRoute, Router } from '@angular/router';
import { EtapeService } from './../../../services/etape.service';
import { Component, OnInit } from '@angular/core';
import { Etape } from 'src/app/model/etape';

@Component({
  selector: 'app-etape-edit',
  templateUrl: './etape-edit.component.html',
  styleUrls: ['./etape-edit.component.css', '../../../app.component.css'],
})
export class EtapeEditComponent implements OnInit {
  etape: Etape = new Etape();
  etapes: Etape[] = [];

  constructor(
    private aR: ActivatedRoute,
    private etapeService: EtapeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.etapeService.get(params['id']).subscribe((result) => {
          this.etape = result;
        });
      }
    });
  }
}
