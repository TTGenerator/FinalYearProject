import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import {routing} from "./lecturerPreferences.routing";
import {LecturerPreferences} from "./lecturerPreferences.component";


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    routing
  ],
  declarations: [
    LecturerPreferences
  ],
  providers: [

  ]
})
export class LecturerPreferencesModule {}
