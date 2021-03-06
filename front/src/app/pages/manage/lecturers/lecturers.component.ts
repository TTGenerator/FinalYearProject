/**
 * Created by maheshika on 4/2/2017.
 */

import {Component, ViewChild, ViewEncapsulation} from '@angular/core';

import {LecturersService} from "../../../services/manage/lecturers/lecturers.service";
import {Lecturer} from "../../../model/lecturer";
import 'style-loader!./lecturers.scss';
import {ModalComponent} from "ng2-bs4-modal/components/modal";
import {FormGroup} from "@angular/forms";


@Component({
  selector: 'lecturers',
  templateUrl: './lecturers.html',
  encapsulation: ViewEncapsulation.None
})
export class Lecturers {
  public form: FormGroup;
  public LecturersList:Array<Lecturer>;

  @ViewChild('validationModal')
  modal: ModalComponent;

  model : Lecturer = new LecturerModal();
  selected: string;
  output: string;

  index: number = 0;
  isEdit:boolean=false;

  constructor(private _LecturersService:LecturersService) {
    this.LecturersList = this._LecturersService.getLecturersList();
  }

  closed() {
    this.output = '(closed) ' + this.selected;
    this.addToDoItem();
  }

  dismissed() {
    this.output = '(dismissed)';
    this.isEdit=false;
    this.model= new LecturerModal();
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
    return this.LecturersList.filter((item:Lecturer) => {
      return !item.is_deleted
    })
  }

  addToDoItem() {
    this.model.is_deleted=false;
    this.model.isChecked=false;
    this.model.isActive=false;
    this.model.id=new Date();
    if(this.isEdit==true){
      for(let subject of this.LecturersList){
        if(subject.id === this.model.id){
          console.log("edit");
          subject.name=this.model.name;
          subject.deptID=this.model.deptID;
          subject.coursesCodes=this.model.coursesCodes;
          subject.email=this.model.email;
          subject.is_deleted=this.model.is_deleted;
          subject.isChecked=this.model.isChecked;
          subject.isActive=this.model.isActive;
          subject.is_deleted=this.model.is_deleted;
          subject.isChecked=this.model.isChecked;
          subject.isActive=this.model.isActive;
          this.dismissed();
        }
      }
    }else {
      console.log("after edit");
      this.LecturersList.push(this.model);
      this.model= new LecturerModal();
    }



  }

  deleteLecturers(){
    for(let Lecturer of this.LecturersList){
      if(Lecturer.isChecked == true){
        Lecturer.is_deleted = true;
      }
    }
  }

  editLecturer(Lecturer:Lecturer){
    this.isEdit=true;
    this.model=Lecturer;
    this.modal.open();
    console.log(this.modal);
  }
}

class LecturerModal implements Lecturer {
  id: Date;
  name:string;
  deptID:string;
  coursesCodes:string;
  email:string;
  is_deleted?:boolean;
  isChecked:boolean;
  isActive:boolean;
}
