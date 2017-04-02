/**
 * Created by jayani on 3/29/2017.
 */
import {Component, ViewChild, ViewEncapsulation} from '@angular/core';

import {RoomsService} from "./rooms.service";
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
  isEdit:boolean=false;
  index: number = 0;

  constructor(private _roomsService:RoomsService) {
    this.roomsList = this._roomsService.getRoomsList();
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
    console.log("opened");
    console.log(this.modal);
  }

  open() {
    this.modal.open();
    console.log("open");
  }

  getNotDeleted() {
    return this.roomsList.filter((item:Room) => {
      return !item.deleted
    })
  }

  addToDoItem() {
    this.model.deleted=false;
    this.model.isChecked=false;
    this.model.isActive=false;
    this.model.room_id=new Date();
    console.log(this.model);
    if(this.isEdit==true){
      for(let room of this.roomsList){
        if(room.room_id === this.model.room_id){
          console.log("edit");
          room.name=this.model.name;
          room.capacity=this.model.capacity;
          room.category=this.model.category;
          room.deleted=this.model.deleted;
          room.isChecked=this.model.isChecked;
          room.isActive=this.model.isActive;
          this.dismissed();
        }
      }
    }else {
      console.log("after edit");
      this.roomsList.push(this.model);
      this.model= new RoomModal();
    }
  }

  deleteRooms(){
    for(let room of this.roomsList){
      if(room.isChecked == true){
        room.deleted = true;
      }
    }
  }

  editRoom(room:Room){
    this.isEdit=true;
    console.log(room);
    this.model=room;
    this.modal.open();
  }

  parseValue(value : string) {
    this.model.category=value;
    // this.myValue = AgentStatus[value];
    // this.isOffline = this.myValue == AgentStatus.offline;
  }
}

class RoomModal implements Room {
  room_id:Date;
  name:string;
  capacity?:number;
  category:string;
  deleted:boolean;
  isChecked:boolean;
  isActive:boolean;
}
