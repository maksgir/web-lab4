import {Component, OnInit} from '@angular/core';
import {RegisterInfo} from "../dto/register-info";
import {AuthService} from "../auth/auth.service";
import {TokenStorageService} from "../auth/token-storage.service";
import {LoginInfo} from "../dto/login-info";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isSignedUp = false;
  isRegistrationFailed = false;
  errorMessage = '';
  private registerInfo: RegisterInfo| undefined;

  constructor(private authService: AuthService,
              public tokenStorage: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  onSubmit() {
    this.registerInfo = new RegisterInfo(
      this.form.username,
      this.form.password2
    );

    this.authService.signUp(this.registerInfo).subscribe(
      data => {
        this.isSignedUp = true;
        this.isRegistrationFailed = false;

        let loginInfo = new LoginInfo(
          this.form.username,
          this.form.password2
        );
        this.authService.attemptAuth(loginInfo).subscribe(
          data => {
            this.tokenStorage.saveToken(data.token);
            this.tokenStorage.saveUsername(data.username);
            this.isLoggedIn = true;
          },
          error => {
            console.log(error);
            console.log(error.message);
            this.errorMessage = error.message;
          }
        );
      },
      error => {
        console.log(error);
        this.errorMessage = error.error;
        this.isRegistrationFailed = true;
      }
    );
  }



}
