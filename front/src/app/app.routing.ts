import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import {LoginRouteGuard} from "./services/login/loginRouteGuard";

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: '**', redirectTo: 'login'},
  { path: 'pages/dashboard', redirectTo: 'pages/dashboard',canActivate: [LoginRouteGuard] }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes, { useHash: true });
