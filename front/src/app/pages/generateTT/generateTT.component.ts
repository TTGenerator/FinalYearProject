/**
 * Created by jayani on 5/15/2017.
 */
import {Component} from '@angular/core';
import {GeneticTimetableService} from "../../services/genetic/GeneticTimetable.service";
import {HTTPAppService} from "../../services/HttpApp.service";
import {ClassType} from "../../model/classType";
import jsPDF from 'jspdf'
@Component({
  selector: 'generateTT',
  templateUrl: './generateTT.html',

})
export class GenerateTT {

  Timetable:ClassType[];
  public matrix: ClassType[][][];
  TimetableDay:string[] = ["Monday" , "Tuesday" , "Wednsday" , "Thursday" , "Friday"];
  weekDays = [0,1,2,3,4,5];
  timeSlot = [0,1,2,3,4,5,6,7,8];
  returnValue:string;

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

          // Replace moduleId by name
          for(let item of this.Timetable){
            if(item.moduleId != -1){
              this._geneticTimetableService.findModuleById(item.moduleId).subscribe(
                data => {
                  item.courseCode = data.text();
                  // console.log(item.courseCode);
                });
            }

            this._geneticTimetableService.findRoomnameById(item.roomid).subscribe(
              data => {
                item.roomname = data.text();
                // console.log(item.courseCode);
              });
          }

          let count:number =1 ;
          this.matrix = [];
          for(let i: number = 0; i < 5; i++){
            this.matrix[i] = [];
            for (let j: number = 0; j <8; j++){
              this.matrix[i][j] = [];
              for (let item of this.Timetable) {
                if(item.timeslotId == count){
                  this.matrix[i][j].push(item);
                }
              }

              count = count + 1;
            }
          }
          // console.log(this.matrix);
      }
    );
  }
  //
  newGenerate(){
    this.loadTimetable();
  }
  download() {

    let pdf = new jsPDF();
    let options = {
      pagesplit: true,
      background:"#418423"
    };
    pdf.addHTML(this.el.nativeElement, 0, 0, options, () => {
      pdf.save("test.pdf");
    });
  }

}

class ClassTypeModal implements ClassType {
  classId:number;
  groupId:number;
  moduleId:number;
  professorId:number;
  timeslotId:number;
  roomid:number;
  courseCode:string;
  roomname:string;
}

