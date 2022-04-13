import { Reservation } from './../model/reservation';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private static URL: string =
    'http://localhost:8080/monroadtrip/api/reservation';

  constructor(private http: HttpClient) {}

  public getAllByClient(mail: string): Observable<any[]> {
    return this.http.get<any[]>(`${ReservationService.URL}/client/${mail}`);
  }

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${ReservationService.URL}/${id}`);
  }

  public create(reservation: any): Observable<any> {
    return this.http.post(ReservationService.URL, reservation);
  }

  public update(reservation: Reservation): Observable<any> {
    return this.http.put(
      `${ReservationService.URL}/${reservation.id}`,
      this.reservationToJson(reservation)
    );
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<any>(`${ReservationService.URL}/${id}`);
  }

  private reservationToJson(reservation: Reservation): any {
    let obj = {
      id: reservation.id,
      date: reservation.dateReservation,
      statut: reservation.statut,
      client: {
        type: 'client',
        id: reservation.client?.id,
        prenom: reservation.client?.prenom,
        nom: reservation.client?.nom,
        dateNaissance: reservation.client?.dateNaissance,
        mail: reservation.client?.mail,
        typePaiement: reservation.client?.typePaiement,
        adresse: {
          cp: reservation.client?.adresse?.cp,
          voie: reservation.client?.adresse?.voie,
          numero: reservation.client?.adresse?.numero,
          ville: reservation.client?.adresse?.ville,
        },
      },
      participant: {
        id: reservation.participant?.id,
        prenom: reservation.participant?.prenom,
        nom: reservation.participant?.nom,
        age: reservation.participant?.age,
      },
      roadtrip: {
        id: reservation.roadtrip?.id,
        dateDepart: reservation.roadtrip?.dateDepart,
        dateArrivee: reservation.roadtrip?.dateArrivee,
        lieuDepart: reservation.roadtrip?.lieuDepart,
        destination: reservation.roadtrip?.destination,
        prix: reservation.roadtrip?.prix,
        transport: reservation.roadtrip?.transport,
      },
    };
    return obj;
  }
}
