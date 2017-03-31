/**
 * Created by jayani on 3/29/2017.
 */
import {Component, ViewChild, ViewEncapsulation} from '@angular/core';

import {SubjectsService} from "./subjects.service";
import {Subject} from "../../../model/subject";
import 'style-loader!./subjects.scss';
import {ModalComponent} from "ng2-bs4-modal/components/modal";
import {FormGroup} from "@angular/forms";


@Component({
  selector: 'subjects',
  templateUrl: './subjects.html',
  encapsulation: ViewEncapsulation.None
})
export class Subjects {
  public form: FormGroup;
  public subjectsList:Array<Subject>;
  @ViewChild('modal')
  modal: ModalComponent;

  selected: string;
  output: string;

  subject: Subject;
  index: number = 0;

  constructor(private _subjectsService:SubjectsService) {
    this.subjectsList = this._subjectsService.getSubjectsList();
  }

  closed() {
    this.output = '(closed) ' + this.selected;
  }

  dismissed() {
    this.output = '(dismissed)';
  }

  opened() {
    this.output = '(opened)';
  }

  open() {
    this.modal.open();
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
