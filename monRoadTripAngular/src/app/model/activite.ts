import { Organisateur } from './organisateur';
import { Adresse } from './adresse';
import { Categorie } from './categorie';
import { Time } from '@angular/common';

export class Activite {
  public constructor(
    private _id?: number | undefined,
    private _date?: Date | undefined,
    private _heure?: Time | undefined,
    private _prix?: number | undefined,
    private _categorie?: Categorie | undefined,
    private _adresse?: Adresse | undefined,
    private _nbPlaces?: number | undefined,
    private _organisateur?: Organisateur | undefined,
    private _intitule?: string | undefined
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
  public get heure(): Time | undefined {
    return this._heure;
  }

  public set heure(value: Time | undefined) {
    this._heure = value;
  }

  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }

  public get categorie(): Categorie | undefined {
    return this._categorie;
  }

  public set categorie(value: Categorie | undefined) {
    this._categorie = value;
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

  public get organisateur(): Organisateur | undefined {
    return this._organisateur;
  }

  public set organisateur(value: Organisateur | undefined) {
    this._organisateur = value;
  }

  public get intitule(): string | undefined {
    return this._intitule;
  }

  public set intitule(value: string | undefined) {
    this._intitule = value;
  }
}
