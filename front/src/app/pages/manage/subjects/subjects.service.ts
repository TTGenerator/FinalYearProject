/**
 * Created by jayani on 3/29/2017.
 */
import {Injectable} from '@angular/core';

@Injectable()
export class SubjectsService {
  private _subjectsList = [
    {
      code: 'CO421',
      name: 'Final Year Project I',
      teacher: '',
      duration: '2 hrs',
      maxStudents: 60,
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      code: 'CO422',
      name: 'Professional Practices',
      teacher: '',
      duration: '3 hrs',
      maxStudents: 64,
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      code: 'CO423',
      name: 'Software Project Management',
      teacher: '',
      duration: '2.5 hrs',
      maxStudents: 57,
      deleted: false,
      isChecked: false,
      isActive: false
    },
    {
      code: 'CO424',
      name: 'Information Systems Management',
      teacher: '',
      duration: '1 hrs',
      maxStudents: 65,
      deleted: false,
      isChecked: false,
      isActive: false
    }
  ];

  getSubjectsList() {
    return this._subjectsList;
  }
}

