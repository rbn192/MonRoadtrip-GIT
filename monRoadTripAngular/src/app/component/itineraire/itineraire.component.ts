import { ScriptService } from './../../services/test/script.service';
import { Component, OnInit, Renderer2 } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-itineraire',
  templateUrl: './itineraire.component.html',
  styleUrls: ['./itineraire.component.css'],
})
export class ItineraireComponent implements OnInit {
  depart: string = '';
  arrivee: string = '';

  constructor(
    private activatedRoute: ActivatedRoute,
    private scriptService: ScriptService,
    private renderer: Renderer2
  ) {}

  ngOnInit(): void {
    /*const scriptElement = this.scriptService.load(this.renderer);
    scriptElement.onload = () => {
      console.log('cript charge');
    };*/
    this.activatedRoute.params.subscribe((params) => {
      this.depart = params['depart'];
      this.arrivee = params['arrivee'];
      console.log(this.depart);
      //let varFromJsFile: any = window['macarte'];
    });
  }
}
