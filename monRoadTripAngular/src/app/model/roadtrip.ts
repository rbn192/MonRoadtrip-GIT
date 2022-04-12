import { Transport } from './transport';

export class Roadtrip {
  public constructor(
    private _id?: number | undefined,
    private _dateDepart?: Date | undefined,
    private _dateArrivee?: Date | undefined,
    private _lieuDepart?: string | undefined,
    private _destination?: string | undefined,
    private _prix?: number | undefined,
    private _transport?: Transport | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get dateDepart(): Date | undefined {
    return this._dateDepart;
  }

  public set dateDepart(value: Date | undefined) {
    this._dateDepart = value;
  }

  public get dateArrivee(): Date | undefined {
    return this._dateArrivee;
  }

  public set dateArrivee(value: Date | undefined) {
    this._dateArrivee = value;
  }

  public get lieuDepart(): string | undefined {
    return this._lieuDepart;
  }

  public set lieuDepart(value: string | undefined) {
    this._lieuDepart = value;
  }

  public get destination(): string | undefined {
    return this._destination;
  }

  public set destination(value: string | undefined) {
    this._destination = value;
  }

  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }

  public get transport(): Transport | undefined {
    return this._transport;
  }

  public set transport(value: Transport | undefined) {
    this._transport = value;
  }
}
