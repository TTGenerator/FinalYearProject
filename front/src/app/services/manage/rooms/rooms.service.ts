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

  deleteClassRoomByID(roomID:String){
    console.log(roomID);
    return this._http.delete("http://localhost:8080/api/classroom/updateClassRoom/{roomID}")
  }

  addClassRoom(room:Room){
    console.log(room);
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this._http.post("http://localhost:8080/api/classroom/getAllClassrooms", room, options)
  }

  updateClassRoom(room:Room) {
    console.log(room);
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this._http.post("http://localhost:8080/api/classroom/updateClassRoom", room, options)
  }
}

