export class PointResponseDto {
  private _x: number;
  private _y: number;
  private _r: number;
  private _dt: Date;
  private _hit: boolean;


  constructor(x: number, y: number, r: number, dt: Date, hit: boolean) {
    this._x = x;
    this._y = y;
    this._r = r;
    this._dt = dt;
    this._hit = hit;
  }


  get x(): number {
    return this._x;
  }

  set x(value: number) {
    this._x = value;
  }

  get y(): number {
    return this._y;
  }

  set y(value: number) {
    this._y = value;
  }

  get r(): number {
    return this._r;
  }

  set r(value: number) {
    this._r = value;
  }

  get dt(): Date {
    return this._dt;
  }

  set dt(value: Date) {
    this._dt = value;
  }

  get hit(): boolean {
    return this._hit;
  }

  set hit(value: boolean) {
    this._hit = value;
  }
}
