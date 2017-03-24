/**
 * Created by jayani on 3/23/2017.
 */
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import {HomeComponent} from "./home/home.component";
import {LoginRouteGuard} from "./common/services/login/loginRouteGuard";


const appRoutes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'page-login', component: LoginComponent },
  { path: 'page-home', component: HomeComponent, canActivate: [LoginRouteGuard],},
  { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
