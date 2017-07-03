/**
 * Created by jayani on 6/14/2017.
 */
import {Injectable} from '@angular/core';
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
import {User} from "../../model/user";


@Injectable()
export class LoginService extends HTTPAppService {
  isLoggedIn: boolean = false;
  redirectUrl: string;
  username: string;
  user: User = new UserModel();
  tempUser: User = new UserModel();
  checkResult:boolean;
  public incorrectUsername:boolean = false;

  constructor(public _http: Http) {
    super(_http);
  }

  login(): Observable<boolean> {
    return Observable.of(true).delay(1000).do(val => this.isLoggedIn = true);
  }

  logout(): void {
    this.isLoggedIn = false;
  }

  getUsername(): string {
    return this.user.name;
  }

  getPassword(): string {
    return this.user.password;
  }

  getRole(): string {
    return this.user.role;
  }

  setUser() {
        this.user = this.tempUser;
  }

  getUser(): User {
    return this.user;
  }

  getUserByUsername(name:string){
    let data = new URLSearchParams();
    data.append('name', name);
    this._http
      .post('http://localhost:8080/api/userRole/getUserByUsername', data)
      .subscribe(data => {
        //console.log("successfully");
        this.tempUser = data.json();
      }, error => {
        console.log(error.json());
      });
  }

  checkUser(name:string, password:string){
    let data = new URLSearchParams();
    data.append('name', name);
    data.append('password', password);

    this._http
      .post('http://localhost:8080/api/userRole/checkUser', data)
      .subscribe(data => {
        this.checkResult = data.json();
        if(!this.checkResult){
          this.incorrectUsername = true;
        }
      }, error => {
        console.log(error.json());
      });
    this.getUserByUsername(name);
    this.setUser();
    return this.checkResult;

    // console.log(this.tempUser);
    // if(this.user!= null && password == this.tempUser.password){
    //   this.setUser();
    //   return true;
    // }else {
    //   this.incorrectUsername = true;
    //   return false;
    // }
  }
}

class UserModel implements User {
  name: string;
  password: string;
  role: string;
}

