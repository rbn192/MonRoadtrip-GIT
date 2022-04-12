export class Hote {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _prenom?: string | undefined,
    private _password?: string | undefined,
    private _dateNaissance?: Date | undefined,
    private _mail?: string | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get prenom(): string | undefined {
    return this._prenom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }
  public get password(): string | undefined {
    return this._password;
  }

  public set password(value: string | undefined) {
    this._password = value;
  }

  public get dateNaissance(): Date | undefined {
    return this._dateNaissance;
  }

  public set dateNaissance(value: Date | undefined) {
    this._dateNaissance = value;
  }

  public get mail(): string | undefined {
    return this._mail;
  }

  public set mail(value: string | undefined) {
    this._mail = value;
  }
}
