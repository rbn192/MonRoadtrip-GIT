export class Participant {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _prenom?: string | undefined,
    private _age?: number | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get prenom(): string | undefined {
    return this._prenom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }

  public get age(): number | undefined {
    return this._age;
  }

  public set age(value: number | undefined) {
    this._age = value;
  }
}
