import { Adresse } from './../../model/adresse';
import { Compte } from './../../model/compte';
import { Router, ActivatedRoute } from '@angular/router';
import { CompteService } from './../../services/compte.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-compte-modif',
  templateUrl: './compte-modif.component.html',
  styleUrls: ['./compte-modif.component.css'],
})
export class CompteModifComponent implements OnInit {
  compte: Compte = new Compte();
  prenom: string = '';

  constructor(
    private compteService: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.compte.adresse = new Adresse();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['login']) {
        this.compteService
          .getCompteByMail(params['login'])
          .subscribe((result) => {
            this.compte = result;
          });
      }
    });
  }

  edit() {
    if (this.compte.id) {
      this.compteService.update(this.compte).subscribe((result) => {
        (this.compte = result),
          console.log(this.compte.adresse!.voie),
          this.goList();
      });
    } else {
      console.log("création d'un nouveau compte");
    }
    console.log(this.compte.prenom);
  }

  goList() {
    this.router.navigateByUrl('/home');
  }
}
