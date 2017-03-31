/**
 * Created by jayani on 3/29/2017.
 */
import {Component, ViewChild} from '@angular/core';

import {RoomsService} from "./rooms.service";
import {Room} from "../../../model/room";
import 'style-loader!./rooms.scss';

@Component({
  selector: 'rooms',
  templateUrl: './rooms.html'
})
export class Rooms {
  public roomsList:Array<Room>;

  constructor(private _roomsService:RoomsService) {
    this.roomsList = this._roomsService.getRoomsList();
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
