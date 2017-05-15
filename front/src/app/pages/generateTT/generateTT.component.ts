/**
 * Created by jayani on 5/15/2017.
 */
import {Component} from '@angular/core';
import {GeneticTimetableService} from "../../services/genetic/GeneticTimetable.service";
import {HTTPAppService} from "../../services/HttpApp.service";

@Component({
  selector: 'generateTT',
  templateUrl: './generateTT.html'
})
export class GenerateTT {
  public Timetable:Object;
  constructor(private _httpService : HTTPAppService, private _geneticTimetableService: GeneticTimetableService) {
    this.loadTimetable();
  }

  loadTimetable() {
    this._geneticTimetableService.getTimetable().subscribe(
      data => {
        console.log(data.text());
      }
    );
  }
}
