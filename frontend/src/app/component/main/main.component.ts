import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../../auth/token-storage.service";
import {PointResponse} from "../../dto/point-response";
import {PointService} from "../../service/point.service";

@Component({
  selector: 'app-user',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  info: any;

  constructor(private token: TokenStorageService,
              private pointService: PointService)  { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername()
    };

  }
}
