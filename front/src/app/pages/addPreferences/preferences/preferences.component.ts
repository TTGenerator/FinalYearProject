/**
 * Created by maheshika on 4/7/2017.
 */


import {Component, ViewChild, ViewEncapsulation} from '@angular/core';

import {PreferencesService} from "./preferences.service";
import {Preference} from "../../../model/preference";
import 'style-loader!./preferences.scss';
import {ModalComponent} from "ng2-bs4-modal/components/modal";
import {FormGroup} from "@angular/forms";
import {RoomCategory} from "../../../model/room-category";

import {FORM_DIRECTIVES} from "angular2/forms";
import {RadioControlValueAccessor} from "./radio_value_accessor";
import {bootstrap} from 'angular2/angular2';

@Component({
  selector: 'preferences',
  templateUrl: './preferences.html',
  encapsulation: ViewEncapsulation.None,
  directives: [FORM_DIRECTIVES, RadioControlValueAccessor]
})
export class Preferences {
  model;

  constructor() {
    this.model = {
      sex: "female"
    };
  }

}
