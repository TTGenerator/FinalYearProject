/**
 * Created by jayani on 3/29/2017.
 */
import {Injectable} from '@angular/core';

@Injectable()
export class RoomsService {
  private _roomsList = [
    {
      code: 'SR1',
      name: '',
      teacher: '',
      duration: '2 hrs',
      maxStudents: 60,
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      code: 'SR2',
      name: '',
      teacher: '',
      duration: '3 hrs',
      maxStudents: 64,
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      code: 'LR9',
      name: '',
      teacher: '',
      duration: '2.5 hrs',
      maxStudents: 57,
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      code: 'LR10',
      name: '',
      teacher: '',
      duration: '1 hrs',
      maxStudents: 65,
      deleted: false,
      isChecked: false,
      isActive: false
    }
  ];

  getRoomsList() {
    return this._roomsList;
  }
}

