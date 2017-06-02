/**
 * Created by jayani on 5/15/2017.
 */
import {Component} from '@angular/core';
import {GeneticTimetableService} from "../../services/genetic/GeneticTimetable.service";
import {HTTPAppService} from "../../services/HttpApp.service";
import {ClassType} from "../../model/classType";
import {BasicTablesService} from "../../services/generateTT/basicTables.service";

@Component({
  selector: 'generateTT',
  templateUrl: './generateTT.html'
})
export class GenerateTT {

  metricsTableData:Array<any>;
  public Timetable:ClassType[];

  constructor(private _basicTablesService: BasicTablesService, private _httpService : HTTPAppService, private _geneticTimetableService: GeneticTimetableService) {
    this.loadTimetable();
    this.metricsTableData = this.Timetable;
  }

  loadTimetable() {
    this._geneticTimetableService.getTimetable().subscribe(
      data => {
        this.Timetable = data.json();
        console.log(this.Timetable);
      }
    );
  }
}
