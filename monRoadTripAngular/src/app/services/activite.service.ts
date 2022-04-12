import { Organisateur } from './../model/organisateur';
import { Categorie } from './../model/categorie';
import { Activite } from './../model/activite';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ActiviteService {
  private static URL: string = 'http://localhost:8080/monroadtrip/api/activite';

  constructor(private http: HttpClient) {}

  public getAllByOrganisateur(mail: string): Observable<any[]> {
    return this.http.get<any[]>(`${ActiviteService.URL}/organisateur/${mail}`);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${ActiviteService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${ActiviteService.URL}/${id}`);
  }

  public create(activite: Activite): Observable<any> {
    return this.http.post(ActiviteService.URL, this.activiteToJson(activite));
  }

  public update(activite: Activite): Observable<any> {
    return this.http.put(
      `${ActiviteService.URL}/${activite.id}`,
      this.activiteToJson(activite)
    );
  }

  private activiteToJson(activite: Activite): any {
    let obj = {
      id: activite.id,
      date: activite.date,
      heure: activite.heure,
      prix: activite.prix,
      categorie: activite.categorie,
      adresse: {
        cp: activite.adresse?.cp,
        voie: activite.adresse?.voie,
        numero: activite.adresse?.numero,
        ville: activite.adresse?.ville,
      },
      nbPlaces: activite.nbPlaces,
      organisateur: {
        type: 'organisateur',
        id: activite.organisateur?.id,
        prenom: activite.organisateur?.prenom,
        mail: activite.organisateur?.mail,
        dateNaissance: activite.organisateur?.dateNaissance,
      },
      intitule: activite.intitule,
    };
    return obj;
  }
}
