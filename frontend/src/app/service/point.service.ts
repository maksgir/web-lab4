import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {PointDto} from "../dto/point-dto";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PointService {

  private saveUrl = 'http://localhost:8080/api/points/save';

  constructor(private http: HttpClient) { }

  savePoint(point: PointDto): void {
    this.http.post<PointDto>(this.saveUrl, point, httpOptions)
  }
}
