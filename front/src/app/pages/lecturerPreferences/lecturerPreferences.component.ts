/**
 * Created by maheshika on 4/13/2017.
 */

import {Component} from '@angular/core';

@Component({
  selector: 'lecturerPreferences',
  templateUrl: './lecturerPreferences.html',

})
export class LecturerPreferences {

  constructor() {
  }
  public checkboxModel = [{
    name: 'Monday',
    checked: false,
    class: 'col-md-4'
  }, {
    name: 'Tuesday',
    checked: false,
    class: 'col-md-4'
  }, {
    name: 'Wednesday',
    checked: true,
    class: 'col-md-4'
  }, {
    name: 'Thursday',
    checked: false,
    class: 'col-md-4'
  }, {
    name: 'Friday',
    checked: false,
    class: 'col-md-4'
  }];

  //isDisabled: boolean = false;

  public checkboxPropertiesMapping = {
    model: 'checked',
    value: 'name',
    label: 'name',
    baCheckboxClass: 'class'
  };



  public checkboxTimeModel = [{
    name: '8.00-10.00',
    checked: false,
    class: 'col-md-4'
  }, {
    name: '10.00-12.00',
    checked: false,
    class: 'col-md-4'
  }, {
    name: '1.00-3.00',
    checked: true,
    class: 'col-md-4'
  }, {
    name: '3.00-5.00',
    checked: false,
    class: 'col-md-4'
  }, {
    name: '5.00-7.00',
    checked: false,
    class: 'col-md-4'
  }];

  public checkboxTimePropertiesMapping = {
    model: 'checked',
    value: 'name',
    label: 'name',
    baCheckboxClass: 'class'
  };

}
