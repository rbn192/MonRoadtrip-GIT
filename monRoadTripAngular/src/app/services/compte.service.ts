import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  constructor(private http: HttpClient) {}

  public inscriptionClient(compte: any): Observable<any> {
    return this.http.post(
      'http://localhost:8080/mon_roadtrip/api/compte/inscription',
      compte
    );
  }
}
