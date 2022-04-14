import { Observable } from 'rxjs';
import { Participant } from 'src/app/model/participant';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ParticipantService {
  private static URL: string =
    'http://localhost:8080/monroadtrip/api/participant';

  constructor(private http: HttpClient) {}

  public get(id: number): Observable<any> {
    return this.http.get<any>(`${ParticipantService.URL}/${id}`);
  }

  public create(participant: any): Observable<any> {
    return this.http.post(ParticipantService.URL, participant);
  }

  public update(participant: Participant): Observable<any> {
    return this.http.put(
      `${ParticipantService.URL}/${participant.id}`,
      this.participantToJson(participant)
    );
  }

  private participantToJson(participant: Participant): any {
    let obj = {
      id: participant.id,
      prenom: participant.prenom,
      nom: participant.nom,
      age: participant.age,
    };
    return obj;
  }
}
