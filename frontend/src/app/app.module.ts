import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {HomePageComponent} from './home-page/home-page.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {httpInterceptorProviders} from "./auth/token-injector";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
