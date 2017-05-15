import { Routes, RouterModule }  from '@angular/router';

import { ModuleWithProviders } from '@angular/core';
import {GenerateTT} from "./generateTT.component";

// noinspection TypeScriptValidateTypes
export const routes: Routes = [
  {
    path: '',
    component: GenerateTT,
  }
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);

