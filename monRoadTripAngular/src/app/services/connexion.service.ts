import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ConnexionService {
  constructor(private http: HttpClient) {}

  public authentication(login: string, password: string): Observable<any> {
    let httpHeaders: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });

    return this.http.get<any>('http://localhost:8080/monroadtrip/api/auth', {
      headers: httpHeaders,
      responseType: 'text' as 'json',
    });
  }

  isAuthenticated(): boolean {
    return localStorage.getItem('login') ? true : false;
  }
}
