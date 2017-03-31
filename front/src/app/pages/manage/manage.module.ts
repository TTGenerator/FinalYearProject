/**
 * Created by jayani on 3/29/2017.
 */
import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import {routing} from "./manage.routing";
import {Manage} from "./manage.component";
import {Subjects} from "./subjects/subjects.component";
import {SubjectsService} from "./subjects/subjects.service";
import {Rooms} from "./rooms/rooms.component";
import {RoomsService} from "./rooms/rooms.service";
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
    Manage,
    Subjects,
    Rooms
  ],
  providers: [
    SubjectsService,
    RoomsService
  ]
})
export class ManageModule {}
