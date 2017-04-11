/**
 * Created by maheshika on 4/7/2017.
 */

import { Routes, RouterModule }  from '@angular/router';
import {AddPreferences} from "./addPreferences.component";

import {Preferences} from "./preferences/preferences.component";


// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: AddPreferences,
    children: [
      { path: 'preferences', component: Preferences }

    ]
  }
];

export const routing = RouterModule.forChild(routes);
