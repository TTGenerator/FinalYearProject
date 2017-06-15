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
  public incorrectUsername:boolean = false;
  private _usersList;

  constructor(public _http: Http) {
    super(_http);
    this._usersList = this._http.get("http://localhost:8080/api/userRole/getAllUsers");

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

  setUser(name: string) {
    let userlist = this.getUsersList();
    for (let user of userlist) {
      if (user.name == name) {
        this.user = user;
      }
    }
  }

  getUser(): User {
    return this.user;
  }

  getPasswordByUsername(name: string): string {
    let userlist = this.getUsersList();
    for (let user of userlist) {
      if (user.name == name) {
        return user.password;
      }
    }
    this.incorrectUsername = true;

  }

  getRoleByeUsername(name: string): string {
    let userlist = this.getUsersList();
    for (let user of userlist) {
      if (user.name == name) {
        return user.role;
      }
    }
  }

  getUsersList() {
    return this._usersList;
  }

}

class UserModel implements User {
  name: string;
  password: string;
  role: string;
}

