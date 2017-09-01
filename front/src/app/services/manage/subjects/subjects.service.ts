/**
 * Created by jayani on 3/29/2017.
 */
import {Injectable} from '@angular/core';

@Injectable()
export class SubjectsService {
  private _subjectsList = [
    {
      sub_id:new Date(),
      code: 'CO421',
      name: 'Final Year Project I',
      teacher: '',
      duration: '2 hrs',
      maxStudents: 60,
      is_deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      sub_id:new Date(),
      code: 'CO422',
      name: 'Professional Practices',
      teacher: '',
      duration: '3 hrs',
      maxStudents: 64,
      is_deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      sub_id:new Date(),
      code: 'CO423',
      name: 'Software Project Management',
      teacher: '',
      duration: '2.5 hrs',
      maxStudents: 57,
      is_deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      sub_id:new Date(),
      code: 'CO424',
      name: 'Information Systems Management',
      teacher: '',
      duration: '1 hrs',
      maxStudents: 65,
      is_deleted: false,
      isChecked: false,
      isActive: false
    }
  ];

  getSubjectsList() {
    return this._subjectsList;
  }
}

