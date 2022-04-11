import { Hote } from './hote';
import { Adresse } from './adresse';
export class Logement {
  constructor(
    private _id?: number | undefined,
    private _date?: Date | undefined,
    private _prix?: number | undefined,
    private _adresse?: Adresse | undefined,
    private _nbPlaces?: number | undefined,
    private _hote?: Hote | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get date(): Date | undefined {
    return this._date;
  }

  public set date(value: Date | undefined) {
    this._date = value;
  }

  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }

  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  public get nbPlaces(): number | undefined {
    return this._nbPlaces;
  }

  public set nbPlaces(value: number | undefined) {
    this._nbPlaces = value;
  }

  public get hote(): Hote | undefined {
    return this._hote;
  }

  public set hote(value: Hote | undefined) {
    this._hote = value;
  }
}
