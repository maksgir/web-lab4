import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {PointDto} from "../dto/point-dto";
import {Observable} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PointService {

  private saveUrl = 'http://localhost:8080/api/points/save';

  savePoint(point: PointDto): Observable<string> {
    return this.http.post<string>(this.saveUrl, point, httpOptions);
  }

  constructor(private http: HttpClient) {
  }
}
