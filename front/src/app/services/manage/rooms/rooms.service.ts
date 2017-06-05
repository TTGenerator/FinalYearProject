/**
 * Created by jayani on 3/29/2017.
 */
import {Injectable} from '@angular/core';
import {RoomCategory} from "../../../model/room-category";
import {Observable} from "rxjs/Observable";
import {Http, Headers, Request, Response, URLSearchParams, RequestOptions} from "@angular/http";
import "rxjs/add/operator/map";

// Statics
import "rxjs/add/observable/throw";

// Operators
import "rxjs/add/operator/catch";
import "rxjs/add/operator/debounceTime";
import "rxjs/add/operator/distinctUntilChanged";
import "rxjs/add/operator/switchMap";
import "rxjs/add/operator/toPromise";
import {HTTPAppService} from "../../HttpApp.service";
import {Room} from "../../../model/room";


@Injectable()
export class RoomsService extends HTTPAppService {

  constructor(public _http: Http) {
    super(_http);
  }

  getRoomsList() {
    return this._http.get("http://localhost:8080/api/classroom/getAllClassrooms");
  }

  deleteClassRoomByID(roomID:string){
    let data = new URLSearchParams();
    data.append('room_id', roomID);
    this._http
      .post('http://localhost:8080/api/classroom/deleteClassRoomByID', data)
      .subscribe(data => {
        alert('deleted successfully');
      }, error => {
        console.log(error.json());
      });
  }

  addClassRoom(room:Room){
    let data = new URLSearchParams();
    data.append('room_id', room.roomId);
    data.append('room_name', room.roomName);
    data.append('room_category', room.roomCategory);
    data.append('capacity', (room.capacity).toString());
    if(room.isDeleted){
      data.append('is_deleted', "T");
    }else{
      data.append('is_deleted', "F");
    }

    this._http
      .post('http://localhost:8080/api/classroom/addClassRoom', data)
      .subscribe(data => {
        alert('added successfully');
      }, error => {
        console.log(error.json());
      });
  }

  updateClassRoom(room:Room) {
    console.log(room);
    let data = new URLSearchParams();
    data.append('room_id', room.roomId);
    data.append('room_name', room.roomName);
    data.append('room_category', room.roomCategory);
    data.append('capacity', (room.capacity).toString());
    if(room.isDeleted){
      data.append('is_deleted', "T");
    }else{
      data.append('is_deleted', "F");
    }

    this._http
      .post('http://localhost:8080/api/classroom/updateClassRoom', data)
      .subscribe(data => {
        alert('updated successfully');
      }, error => {
        console.log(error.json());
      });
  }
}

