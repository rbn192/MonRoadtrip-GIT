import { Compte } from './../model/compte';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  private static URL: string = 'http://localhost:8080/monroadtrip/api/compte';

  constructor(private http: HttpClient) {}

  public get(id: number): Observable<any> {
    return this.http.get<any>(CompteService.URL + '/' + id);
  }

  public getCompteByMail(mail: string): Observable<Compte> {
    return this.http.get<Compte>(CompteService.URL + '/search/' + mail);
  }

  public inscriptionCompte(compte: any): Observable<any> {
    return this.http.post(
      //'http://localhost:8080/mon_roadtrip/api/compte/inscription',
      CompteService.URL + '/inscription',
      compte
    );
  }

  public findByMail(mail: string): Observable<any> {
    return this.http.get(
      'http://localhost:8080/monroadtrip/api/compte/search/' + mail
    );
  }
}
