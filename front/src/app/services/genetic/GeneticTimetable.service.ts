/**
 * Created by Jayani on 05/15/2017.
 */

import {Injectable} from "@angular/core";
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
import {HTTPAppService} from "../HttpApp.service";

@Injectable()
export class GeneticTimetableService extends HTTPAppService {
    constructor(public _http: Http) {
        super(_http);
    }

    getTimetable() {
        return this._http.get("http://localhost:8080/api/genetic/getTimetable");
    }

    findModuleById(moduleId){
      let data = new URLSearchParams();
      data.append('courseid', moduleId);
      // console.log(data);
      return this._http.post('http://localhost:8080/api/genetic/findModuleById',data);
    }

    findRoomnameById(roomid){
      let data = new URLSearchParams();
      data.append('roomid', roomid);
      // console.log(data);
      return this._http.post('http://localhost:8080/api/genetic/findRoomnameById',data);
    }
}
