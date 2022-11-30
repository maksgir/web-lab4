import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  board: string | undefined;
  errorMessage: string | undefined;

  constructor(private userService: UserService)  { }

  ngOnInit() {
    this.userService.getUserBoard().subscribe(
      data => {
        console.log("belooooo");
        this.board = data;
      },
      error => {
        console.log("baddddd");
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }
}
