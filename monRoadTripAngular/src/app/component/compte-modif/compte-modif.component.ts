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
  password: string = '';

  constructor(
    private compteService: CompteService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.compte.adresse = new Adresse();
  }

  ngOnInit(): void {
    /*this.activatedRoute.params.subscribe((params) => {
      if (params['login']) {
        this.compteService
          .getCompteByMail(params['login'])
          .subscribe((result) => {
            this.compte = result;
            console.log('result ' + result);
            console.log('prenom ' + this.compte.prenom);
          });
      }
    });*/

    if (localStorage.getItem('login')) {
      console.log('login ' + localStorage.getItem('login')!);
      this.compteService
        .getCompteByMail(localStorage.getItem('login')!)
        .subscribe((result) => {
          console.log('subscribe');
          this.compte = result;
          console.log('compte ' + this.compte);
        });
    }
  }

  edit() {
    if (this.compte.id) {
      console.log('yes : ' + this.compte.password);
      this.password = this.compte.password!;
      console.log('pass ' + this.compte.password);
      this.compteService.update(this.compte).subscribe((result) => {
        console.log(this.password),
          ((this.compte = result), (this.compte.password = this.password)),
          this.goList();
      });
    } else {
      console.log("création d'un nouveau compte");
    }
  }

  editPassword() {
    console.log(this.compte.password);
  }

  goList() {
    this.router.navigateByUrl('/home');
  }
}
