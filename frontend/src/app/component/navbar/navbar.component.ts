import {Component} from '@angular/core';
import {TokenStorageService} from "../../auth/token-storage.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  info: any;

  constructor(private token: TokenStorageService) {
  }

  ngOnInit(): void {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername() != null ? this.token.getUsername() : "Anonymous"
    };
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }
}
