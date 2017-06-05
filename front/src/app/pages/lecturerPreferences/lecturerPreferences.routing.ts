/**
 * Created by maheshika on 6/4/2017.
 */
import { Routes, RouterModule }  from '@angular/router';

import { ModuleWithProviders } from '@angular/core';
import {LecturerPreferences} from "./lecturerPreferences.component";
// noinspection TypeScriptValidateTypes
export const routes: Routes = [
  {
    path: '',
    component: LecturerPreferences
  }
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
