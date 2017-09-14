/**
 * Created by jayani on 5/15/2017.
 */
import {Component} from '@angular/core';
import {GeneticTimetableService} from "../../services/genetic/GeneticTimetable.service";
import {HTTPAppService} from "../../services/HttpApp.service";
import {ClassType} from "../../model/classType";

@Component({
  selector: 'generateTT',
  templateUrl: './generateTT.html',

})
export class GenerateTT {

  Timetable:ClassType[];
  Timetable_new:ClassType[];
  private matrix: ClassType[][];
  TimetableDay:string[] = ["Monday" , "Tuesday" , "Wednsday" , "Thursday" , "Friday"];

  constructor( private _httpService : HTTPAppService, private _geneticTimetableService: GeneticTimetableService) {
    this.loadTimetable();
  }

  loadTimetable() {
    this._geneticTimetableService.getTimetable().subscribe(
      data => {
          this.Timetable = data.json();

        this.Timetable.sort((leftside, rightside): number => {
            if (leftside.timeslotId < rightside.timeslotId) {
              return -1;
            }
            if (leftside.timeslotId > rightside.timeslotId) {
              return 1;
            }
            return 0;
          });

          console.log(this.Timetable);
          let count:number =1 ;
          this.matrix = [];
          for(let i: number = 0; i < 5; i++){
            this.matrix[i] = [];
            for (let j: number = 0; j <8; j++){
              for (let item of this.Timetable) {
                if(item.timeslotId == count){
                  this.matrix[i][j]= this.Timetable[count];

                }
              }

              count = count + 1;
            }
          }
          console.log(this.matrix);
      }
    );
  }
}

class ClassTypeModal implements ClassType {
  classId:number;
  groupId:number;
  moduleId:number;
  professorId:number;
  timeslotId:number;
  roomid:number;
}
