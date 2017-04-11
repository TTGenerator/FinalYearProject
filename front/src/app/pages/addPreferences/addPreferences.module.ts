/**
 * Created by maheshika on 4/7/2017.
 */
import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import {routing} from "./addPreferences.routing";
import {AddPreferences} from "./addPreferences.component";


import {Preferences} from "./preferences/preferences.component";
import {PreferencesService} from "./preferences/preferences.service";

import {ModalModule} from "ng2-bs4-modal/module/ng2-bs4-modal.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    routing,
    ModalModule,
  ],
  declarations: [
    AddPreferences,
    Preferences

  ],
  providers: [
    PreferencesService
  ]
})
export class AddPreferencesModule {}
