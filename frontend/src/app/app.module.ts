import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {HomePageComponent} from './home-page/home-page.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {httpInterceptorProviders} from "./auth/token-injector";
import { UserComponent } from './user/user.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomePageComponent,
    UserComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'home', component: HomePageComponent},
      {path: '', redirectTo: 'home', pathMatch: 'full'},
      {path: 'register', component: RegistrationComponent},
      {path: 'login', component: LoginComponent},
      {path: 'user', component: UserComponent},
    ]),
    BrowserAnimationsModule,
    MatButtonModule,
    MatMenuModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
