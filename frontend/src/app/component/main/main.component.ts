import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../../auth/token-storage.service";

@Component({
  selector: 'app-user',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  board: string | undefined;
  errorMessage: string | undefined;
  info: any;

  constructor(private token: TokenStorageService)  { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername()
    };
  }
}
