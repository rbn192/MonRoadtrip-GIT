import { Roadtrip } from './roadtrip';
import { Participant } from './participant';
import { Client } from './client';
import { Statut } from './statut';
import { Etape } from './etape';
export class Reservation {
  public constructor(
    private _id?: number | undefined,
    private _dateReservation?: Date | undefined,
    private _statut?: Statut | undefined,
    //private _etape?: Etape | undefined,
    private _client?: Client | undefined,
    private _participant?: Participant | undefined,
    private _roadtrip?: Roadtrip | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get dateReservation(): Date | undefined {
    return this._dateReservation;
  }

  public set dateReservation(value: Date | undefined) {
    this._dateReservation = value;
  }

  public get statut(): Statut | undefined {
    return this._statut;
  }

  public set statut(value: Statut | undefined) {
    this._statut = value;
  }
  /*
  public get etape(): Etape | undefined {
    return this._etape;
  }

  public set etape(value: Etape | undefined) {
    this._etape = value;
  }
  */
  public get client(): Client | undefined {
    return this._client;
  }

  public set client(value: Client | undefined) {
    this._client = value;
  }

  public get participant(): Participant | undefined {
    return this._participant;
  }

  public set participant(value: Participant | undefined) {
    this._participant = value;
  }

  public get roadtrip(): Roadtrip | undefined {
    return this._roadtrip;
  }

  public set roadtrip(value: Roadtrip | undefined) {
    this._roadtrip = value;
  }
}
