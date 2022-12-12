import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {PointRequestDto} from "../dto/point-request-dto";
import {Observable} from "rxjs";
import {PointResponseDto} from "../dto/point-response-dto";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PointService {

  private saveUrl = 'http://localhost:8080/api/points/save';
  private getUrl = 'http://localhost:8080/api/points';

  private pointList: PointResponseDto[] = [];


  savePoint(point: PointRequestDto): Observable<PointResponseDto> {
    return this.http.post<PointResponseDto>(this.saveUrl, point, httpOptions);
  }

  getPoints():PointResponseDto[]{
    this.http.get<PointResponseDto[]>(this.getUrl).subscribe(data => {
        this.pointList = data;
      },
      error => {
        console.log(error);
      });
    return this.pointList;
  }

  constructor(private http: HttpClient) {
  }
}
