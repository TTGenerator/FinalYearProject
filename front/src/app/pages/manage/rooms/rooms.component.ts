/**
 * Created by jayani on 3/29/2017.
 */
import {Component, ViewChild} from '@angular/core';

import {RoomsService} from "./rooms.service";
import {Room} from "../../../model/room";
import 'style-loader!./rooms.scss';
import {ModalDirective} from "ng2-bootstrap";

@Component({
  selector: 'rooms',
  templateUrl: './rooms.html'
})
export class Rooms {
  public roomsList:Array<Room>;
  @ViewChild('childModal') childModal: ModalDirective;

  constructor(private _roomsService:RoomsService) {
    this.roomsList = this._roomsService.getRoomsList();
  }
  showChildModal(): void {
    this.childModal.show();
  }

  hideChildModal(): void {
    this.childModal.hide();
  }

  getNotDeleted() {
    return this.roomsList.filter((item:Room) => {
      return !item.deleted
    })
  }

  addToDoItem($event) {
    //
    // if (($event.which === 1 || $event.which === 13) && this.newTodoText.trim() != '') {
    //
    //   this.roomsList.unshift({
    //     text: this.newTodoText,
    //     color: this._getRandomColor(),
    //   });
    //   this.newTodoText = '';
    // }
  }

  deleteRooms(){
    for(let room of this.roomsList){
        if(room.isChecked == true){
          room.deleted = true;
        }
    }
  }
}
