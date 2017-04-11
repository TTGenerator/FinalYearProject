import {Routes, RouterModule}  from '@angular/router';
import {Pages} from './pages.component';
import {ModuleWithProviders} from '@angular/core';
import {LoginRouteGuard} from "../services/login/loginRouteGuard";
import {ManageRouteGuard} from "../services/manage/manageRouteGuard";
// noinspection TypeScriptValidateTypes

// export function loadChildren(path) { return System.import(path); };

export const routes: Routes = [
  {
    path: 'login',
    loadChildren: 'app/pages/login/login.module#LoginModule'
  },
  {
    path: 'register',
    loadChildren: 'app/pages/register/register.module#RegisterModule'
  },
  {
    path: 'pages',
    component: Pages,
    children: [
      {path: '', redirectTo: 'dashboard', pathMatch: 'full',canActivate: [LoginRouteGuard]},
      {path: 'dashboard', loadChildren: 'app/pages/dashboard/dashboard.module#DashboardModule',canActivate: [LoginRouteGuard]},
      {path: 'manage', loadChildren: 'app/pages/manage/manage.module#ManageModule',canActivate: [LoginRouteGuard,ManageRouteGuard]}

    ]
  }
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
