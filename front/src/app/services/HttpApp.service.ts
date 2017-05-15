/**
 * Created by Jayani on 05/15/2017.
 */

import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable"
import {Http, Headers, Request, Response, URLSearchParams, RequestOptions} from "@angular/http";
import 'rxjs/add/operator/map'
// Statics
import 'rxjs/add/observable/throw';

// Operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/toPromise';

@Injectable()
export  class HTTPAppService {
    constructor(public _http:Http) {}

    getTimetable(){
      return this._http.get("http://localhost:8080/app/genetic/getTimetable");
    }

}
