/**
 * Created by jayani on 3/29/2017.
 */
import { Routes, RouterModule }  from '@angular/router';
import {Manage} from "./manage.component";
import {Subjects} from "./subjects/subjects.component";
import {Rooms} from "./rooms/rooms.component";
// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: Manage,
    children: [
      { path: 'subjects', component: Subjects },
      { path: 'rooms', component: Rooms }
    ]
  }
];

export const routing = RouterModule.forChild(routes);
