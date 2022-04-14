import { Logement } from './../../model/logement';
import { Activite } from 'src/app/model/activite';
import { LogementService } from './../../services/logement.service';
import { ActiviteService } from './../../services/activite.service';
import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit } from '@angular/core';
import * as L from 'leaflet';
import 'leaflet-routing-machine';
import Geocoder from 'leaflet-control-geocoder';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
})
export class MapComponent implements OnInit, AfterViewInit {
  constructor(
    private http: HttpClient,
    private activiteService: ActiviteService,
    private logementService: LogementService
  ) {}

  activites: Activite[] = [];
  logements: Logement[] = [];
  ville: string = '';
  ngAfterViewInit(): void {}

  ngOnInit(): void {
    this.carte();
  }

  carte() {
    // Déclaration de la carte avec les coordonnées du centre et le niveau de zoom.
    const myfrugalmap = L.map('frugalmap').setView([50.6311634, 3.0599573], 12);

    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
      attribution: 'Frugal Map',
    }).addTo(myfrugalmap);
    console.log(myfrugalmap);

    L.Routing.control({
      router: L.Routing.osrmv1({
        serviceUrl: `http://router.project-osrm.org/route/v1/`,
        language: 'fr',
        profile: 'car', //car, bike
      }),
      geocoder: Geocoder,
      lineOptions: {
        styles: [
          {
            color: '#839c49',
            opacity: 1,
            weight: 7,
          },
        ],
        extendToWaypoints: true,
        missingRouteTolerance: 10,
      },
      waypoints: [L.latLng(48.856614, 2.3522219), L.latLng(43.604, 1.44305)],
    }).addTo(myfrugalmap);
    console.log('apres :' + myfrugalmap);

    const myIcon = L.icon({
      iconUrl:
        'https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.2.0/images/marker-icon.png',
    });

    this.http
      .get(
        'https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=bornes-podotactiles'
      )
      .subscribe((data: any) => {
        data.records.forEach(
          (podotactile: { geometry: { coordinates: number[] } }) => {
            L.marker(
              [
                podotactile.geometry.coordinates[1],
                podotactile.geometry.coordinates[0],
              ],
              { icon: myIcon }
            ).addTo(myfrugalmap);
          }
        );
      });
  }

  list() {
    this.activiteService.getAllByVille(this.ville).subscribe((result) => {
      this.activites = result;
    });
    this.logementService.getAllByVille(this.ville).subscribe((result) => {
      this.logements = result;
    });
  }
}
