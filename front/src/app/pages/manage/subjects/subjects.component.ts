/**
 * Created by jayani on 3/29/2017.
 */
import {Component, ViewChild, ViewEncapsulation} from '@angular/core';

import {Subject} from "../../../model/subject";
import 'style-loader!./subjects.scss';
import {ModalComponent} from "ng2-bs4-modal/components/modal";
import {FormGroup} from "@angular/forms";
import {SubjectsService} from "../../../services/manage/subjects/subjects.service";


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
  isEdit:boolean=false;
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
    this.isEdit=false;
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
    this.model.sub_id=new Date();
    console.log(this.model);
    if(this.isEdit==true){
      for(let subject of this.subjectsList){
        if(subject.sub_id === this.model.sub_id){
          console.log("edit");
          subject.code=this.model.code;
          subject.name=this.model.name;
          subject.teacher=this.model.teacher;
          subject.duration=this.model.duration;
          subject.maxStudents=this.model.maxStudents;
          subject.deleted=this.model.deleted;
          subject.isChecked=this.model.isChecked;
          subject.isActive=this.model.isActive;
          this.dismissed();
        }
      }
    }else {
      console.log("after edit");
      this.subjectsList.push(this.model);
      this.model= new SubjectModal();
    }
  }

  deleteSubjects(){
    for(let subject of this.subjectsList){
      if(subject.isChecked == true){
        subject.deleted = true;
      }
    }
  }

  editSubject(subject:Subject){
    this.isEdit=true;
    console.log(subject);
    this.model=subject;
    this.modal.open();
  }
}

class SubjectModal implements Subject {
  sub_id:Date;
  code: string;
  name:string;
  teacher:string;
  duration:string;
  maxStudents:number;
  deleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
