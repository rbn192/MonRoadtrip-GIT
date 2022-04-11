import { Compte } from './../model/compte';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ConnexionService {
  constructor(private http: HttpClient) {}

  public authentication(login: string, password: string): Observable<Compte> {
    let httpHeaders: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });

    return this.http.get<Compte>('http://localhost:8080/monroadtrip/api/auth', {
      headers: httpHeaders,
    });
  }

  isAuthenticated(): boolean {
    return localStorage.getItem('login') ? true : false;
  }
}
