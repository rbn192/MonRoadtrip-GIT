import { Adresse } from './adresse';
export class Compte {
  constructor(
    private _id?: number | undefined,
    private _dateNaissance?: Date | undefined,
    private _mail?: string | undefined,
    private _nom?: string | undefined,
    private _password?: string | undefined,
    private _prenom?: string | undefined,
    private _adresse?: Adresse | undefined,
    private _solde?: number | undefined,
    private _typePaiement?: string | undefined, //a passer en enum,
    private _type?: string | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public get dateNaissance(): Date | undefined {
    return this._dateNaissance;
  }

  public get mail(): string | undefined {
    return this._mail;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public get password(): string | undefined {
    return this._password;
  }

  public get prenom(): string | undefined {
    return this._prenom;
  }

  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  public get solde(): number | undefined {
    return this._solde;
  }

  public get typePaiement(): string | undefined {
    return this._typePaiement;
  }

  public get type(): string | undefined {
    return this._type;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }
  public set mail(value: string | undefined) {
    this._mail = value;
  }
  public set password(value: string | undefined) {
    this._password = value;
  }
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }
  public set solde(value: number | undefined) {
    this._solde = value;
  }
  public set typePaiement(value: string | undefined) {
    this._typePaiement = value;
  }

  public set dateNaissance(value: Date | undefined) {
    this._dateNaissance = value;
  }

  public set type(value: string | undefined) {
    this._type = value;
  }
}
