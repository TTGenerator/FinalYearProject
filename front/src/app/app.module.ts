import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { FormsModule }    from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing }  from './app.routing';

import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {LoginService} from "./common/services/login/loginService";
import {LoginRouteGuard} from "./common/services/login/loginRouteGuard";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent
  ],
  providers: [LoginService,LoginRouteGuard],
  bootstrap: [AppComponent]
})

export class AppModule { }
