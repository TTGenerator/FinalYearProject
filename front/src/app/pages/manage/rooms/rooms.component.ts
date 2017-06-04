/**
 * Created by jayani on 3/29/2017.
 */
import {Component, ViewChild, ViewEncapsulation} from '@angular/core';

import {RoomsService} from "../../../services/manage/rooms/rooms.service";
import {Room} from "../../../model/room";
import 'style-loader!./rooms.scss';
import {ModalComponent} from "ng2-bs4-modal/components/modal";
import {FormGroup} from "@angular/forms";
import {RoomCategory} from "../../../model/room-category";

@Component({
  selector: 'rooms',
  templateUrl: './rooms.html',
  encapsulation: ViewEncapsulation.None
})
export class Rooms {
  public form: FormGroup;
  public roomsList:Array<Room>;

  @ViewChild('validationModal')
  modal: ModalComponent;

  options : string[];
  model : Room = new RoomModal();
  selected: string;
  output: string;
  isEdit:boolean = false;
  index: number = 0;

  constructor(private _roomsService:RoomsService) {
    this._roomsService.getRoomsList().subscribe(
      data => {
        this.roomsList = data.json();
        console.log(this.roomsList);
        for(let room of this.roomsList){
          room.isChecked = false;
          room.isActive = false;
        };
      }
    );

    var options = Object.keys(RoomCategory);
    this.options = options.slice(options.length / 2);
  }

  closed() {
    this.output = '(closed) ' + this.selected;
    this.addToDoItem();
  }

  dismissed() {
    this.output = '(dismissed)';
    this.isEdit=false;
    this.model= new RoomModal();
  }

  opened() {
    this.output = '(opened)';
  }

  open() {
    this.modal.open();
  }

  getNotDeleted() {
    console.log(this.roomsList);
    if (this.roomsList ==null) {
        return null;
    }

    return this.roomsList.filter((item:Room) => {
      return !item.isDeleted;
    });
  }

  addToDoItem() {
    this.model.isDeleted=false;
    this.model.isChecked=false;
    this.model.isActive=false;
    this.model.roomId=new Date();
    if(this.isEdit==true){
      for(let room of this.roomsList){
        if(room.roomId === this.model.roomId){
          room.roomName=this.model.roomName;
          room.capacity=this.model.capacity;
          room.roomCategory=this.model.roomCategory;
          room.isDeleted=this.model.isDeleted;
          room.isChecked=this.model.isChecked;
          room.isActive=this.model.isActive;
          this.dismissed();
        }
      }
    }else {
      this.roomsList.push(this.model);
      this.model= new RoomModal();
    }

  }

  deleteRooms(){
    for(let room of this.roomsList){
      if(room.isChecked == true){
        room.isDeleted = true;
      }
    }
  }

  editRoom(room:Room){
    this.isEdit=true;
    this.model=room;
    this.modal.open();
  }

}

class RoomModal implements Room {
  roomId:Date;
  roomName:string;
  capacity?:number;
  roomCategory:string;
  isDeleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
