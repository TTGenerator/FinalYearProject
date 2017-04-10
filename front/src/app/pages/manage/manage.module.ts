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
import {Rooms} from "./rooms/rooms.component";
import {RoomsService} from "../../services/manage/rooms/rooms.service";
import {Lecturers} from "./lecturers/lecturers.component";
import {LecturersService} from "../../services/manage/lecturers/lecturers.service";
import {ModalModule} from "ng2-bs4-modal/module/ng2-bs4-modal.module";
import {SubjectsService} from "../../services/manage/subjects/subjects.service";

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
    Rooms,
    Lecturers
  ],
  providers: [
    SubjectsService,
    RoomsService,
    LecturersService
  ]
})
export class ManageModule {}
