import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';

import { routing }       from './pages.routing';
import { NgaModule } from '../theme/nga.module';

import { Pages } from './pages.component';
import {LoginService} from "../services/login/loginService";
import {LoginRouteGuard} from "../services/login/loginRouteGuard";

@NgModule({
  imports: [CommonModule, NgaModule, routing],
  declarations: [Pages],
  providers: [ // expose our Services and Providers into Angular's dependency injection
    LoginService,
    LoginRouteGuard
  ]
})
export class PagesModule {
}
