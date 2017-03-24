import {NgModule, CUSTOM_ELEMENTS_SCHEMA}      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { FormsModule }    from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing }  from './app.routing';
import { MaterialModule } from '@angular/material';
import '../../node_modules/hammerjs/hammer.js';

import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {LoginService} from "./common/services/login/loginService";
import {LoginRouteGuard} from "./common/services/login/loginRouteGuard";
import { LoaderService } from './common/services/loader/loaderService';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    //ui module
    MaterialModule.forRoot()
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent
  ],
  providers: [LoginService,LoginRouteGuard,LoaderService],
  bootstrap: [AppComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ]

})

export class AppModule { }
