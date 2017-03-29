/**
 * Created by jayani on 3/29/2017.
 */
import {Component} from '@angular/core';

import {SubjectsService} from "./subjects.service";

@Component({
  selector: 'subjects',
  templateUrl: './subjects.html'
})
export class Subjects {

  // chartData:Object;

  constructor(private _subjectsService:SubjectsService) {
    // this.chartData = this._subjectsService.getData();
  }
}
