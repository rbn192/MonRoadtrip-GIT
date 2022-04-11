export class Adresse {
  constructor(
    private _numero?: string | undefined,
    private _voie?: string | undefined,
    private _ville?: string | undefined,
    private _cp?: string | undefined
  ) {}

  public get numero(): string | undefined {
    return this._numero;
  }

  public get voie(): string | undefined {
    return this._voie;
  }

  public get ville(): string | undefined {
    return this._ville;
  }

  public get cp(): string | undefined {
    return this._cp;
  }

  public set numero(value: string | undefined) {
    this._numero = value;
  }

  public set voie(value: string | undefined) {
    this._voie = value;
  }

  public set ville(value: string | undefined) {
    this._ville = value;
  }

  public set cp(value: string | undefined) {
    this._cp = value;
  }
}
