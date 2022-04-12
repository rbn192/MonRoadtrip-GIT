import { Hote } from './../../../model/hote';
import { LogementService } from './../../../services/logement.service';
import { Logement } from './../../../model/logement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logement-list',
  templateUrl: './logement-list.component.html',
  styleUrls: ['./logement-list.component.css', '../../../app.component.css'],
})
export class LogementListComponent implements OnInit {
  logements: Logement[] = [];
  hote: Hote = new Hote();

  constructor(private logementService: LogementService) {}

  ngOnInit(): void {
    this.list(localStorage.getItem('login')!);
  }

  list(mail: string) {
    this.logementService.getAllByHote(mail).subscribe((result) => {
      this.logements = result;
    });
  }

  delete(id: number) {
    this.logementService.delete(id).subscribe((ok) => {
      this.list(localStorage.getItem('login')!);
    });
  }
}
