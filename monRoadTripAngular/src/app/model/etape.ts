import { Logement } from './logement';
import { Activite } from './activite';
export class Etape {
  public constructor(
    private _id?: number | undefined,
    private _date?: Date | undefined,
    private _duree?: number | undefined,
    private _ville?: string | undefined,
    private _activite?: Activite | undefined,
    private _logement?: Logement | undefined
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
  public get duree(): number | undefined {
    return this._duree;
  }

  public set duree(value: number | undefined) {
    this._duree = value;
  }

  public get ville(): string | undefined {
    return this._ville;
  }

  public set ville(value: string | undefined) {
    this._ville = value;
  }

  public get activite(): Activite | undefined {
    return this._activite;
  }

  public set activite(value: Activite | undefined) {
    this._activite = value;
  }

  public get logement(): Logement | undefined {
    return this._logement;
  }

  public set logement(value: Logement | undefined) {
    this._logement = value;
  }
}
