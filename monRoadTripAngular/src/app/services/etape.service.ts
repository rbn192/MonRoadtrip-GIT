import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Etape } from '../model/etape';

@Injectable({
  providedIn: 'root',
})
export class EtapeService {
  private static URL: string = 'http://localhost:8080/monroadtrip/api/etape';

  constructor(private http: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.http.get<any[]>(EtapeService.URL);
  }

  public getAllByReservation(id: number): Observable<any[]> {
    return this.http.get<any[]>(`${EtapeService.URL}/reservation/${id}`);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${EtapeService.URL}/${id}`);
  }

  private etapeToJson(etape: Etape): any {
    let obj = {
      id: etape.id,
      date: etape.date,
      duree: etape.duree,
      ville: etape.ville,
      activite: etape.activite,
      logement: etape.logement,
    };
    return obj;
  }
}
