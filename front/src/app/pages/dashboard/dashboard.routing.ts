import { Routes, RouterModule }  from '@angular/router';

import { Dashboard } from './dashboard.component';
import { ModuleWithProviders } from '@angular/core';
import {Profile} from "./profile/profile.component";

// noinspection TypeScriptValidateTypes
export const routes: Routes = [
  {
    path: '',
    component: Dashboard,
    children: [
      { path: 'profile', component: Profile }
    ]
  }
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);

