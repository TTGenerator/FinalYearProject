/**
 * Created by maheshika on 4/2/2017.
 */
import {Injectable} from '@angular/core';

@Injectable()
export class LecturersService {
  private _lecturersList = [
    {
      id: 'CO01',
      name:'Dr.Roshan G Ragel',
      deptID:'CO',
      coursesCodes:'CO221 CO222',
      email:'roshanr@pdn.ac.lk',
      deleted:false,
      isChecked:false,
      isActive: false
    },
    {
      id: 'CO02',
      name:'Dr.Dhammika Elkaduwe',
      deptID:'CO',
      coursesCodes:'CO223 CO224',
      email:'dhammika@ce.pdn.ac.lk',
      deleted:false,
      isChecked:false,
      isActive: false
    },
    {
      id: 'CO03',
      name:'Mr.Sampath Deegalla',
      deptID:'CO',
      coursesCodes:'CO322 CO225',
      email:'dsdeegalla@pdn.ac.lk',
      deleted:false,
      isChecked:false,
      isActive: false
    },
    {
      id: 'CO04',
      name:'Dr.Suneth Namal Karunarathna',
      deptID:'CO',
      coursesCodes:'CO226 CO421',
      email:'namal@ce.pdn.ac.lk',
      deleted:false,
      isChecked:false,
      isActive: false
    }
  ];

  getLecturersList() {
    return this._lecturersList;
  }
}

