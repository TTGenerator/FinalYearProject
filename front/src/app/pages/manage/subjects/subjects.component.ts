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

  @ViewChild('validationModal')
  modal: ModalComponent;

  model : Subject = new SubjectModal();
  selected: string;
  output: string;

  index: number = 0;

  constructor(private _subjectsService:SubjectsService) {
    this.subjectsList = this._subjectsService.getSubjectsList();
  }

  closed() {
    this.output = '(closed) ' + this.selected;
    this.addToDoItem();
  }

  dismissed() {
    this.output = '(dismissed)';
    this.model= new SubjectModal();
  }

  opened() {
    this.output = '(opened)';
    console.log("opened");
    console.log(this.modal);
  }

  open() {
    this.modal.open();
    console.log("open");
  }

  getNotDeleted() {
    return this.subjectsList.filter((item:Subject) => {
      return !item.deleted
    })
  }

  addToDoItem() {
    this.model.deleted=false;
    this.model.isChecked=false;
    this.model.isActive=false;
    console.log(this.model);
    for(let subject of this.subjectsList){
      if(subject.code === this.model.code){
        this.dismissed();
      }
    }
    this.subjectsList.push(this.model);
    this.model= new SubjectModal();
  }

  deleteSubjects(){
    for(let subject of this.subjectsList){
        if(subject.isChecked == true){
          subject.deleted = true;
        }
    }
  }

  editSubject(subject:Subject){
    console.log(subject);
    this.model=subject;
    this.modal.open();
    console.log(this.modal);
  }
}

class SubjectModal implements Subject {
  code: string;
  name:string;
  teacher:string;
  duration:string;
  maxStudents:number;
  deleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
