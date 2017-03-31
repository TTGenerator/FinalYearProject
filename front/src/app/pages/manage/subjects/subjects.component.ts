/**
 * Created by jayani on 3/29/2017.
 */
import {Component, ViewChild} from '@angular/core';

import {SubjectsService} from "./subjects.service";
import {Subject} from "../../../model/subject";
import 'style-loader!./subjects.scss';
import {ModalDirective} from "ng2-bootstrap";

@Component({
  selector: 'subjects',
  templateUrl: './subjects.html'
})
export class Subjects {
  public subjectsList:Array<Subject>;
  @ViewChild('childModal') childModal: ModalDirective;

  constructor(private _subjectsService:SubjectsService) {
    this.subjectsList = this._subjectsService.getSubjectsList();
  }
  showChildModal(): void {
    this.childModal.show();
  }

  hideChildModal(): void {
    this.childModal.hide();
  }

  getNotDeleted() {
    return this.subjectsList.filter((item:Subject) => {
      return !item.deleted
    })
  }

  addToDoItem($event) {
    //
    // if (($event.which === 1 || $event.which === 13) && this.newTodoText.trim() != '') {
    //
    //   this.subjectsList.unshift({
    //     text: this.newTodoText,
    //     color: this._getRandomColor(),
    //   });
    //   this.newTodoText = '';
    // }
  }

  deleteSubjects(){
    for(let subject of this.subjectsList){
        if(subject.isChecked == true){
          subject.deleted = true;
        }
    }
  }
}
