/**
 * Created by jayani on 6/14/2017.
 */
import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, Headers, Request, Response, URLSearchParams, RequestOptions} from "@angular/http";
import "rxjs/add/operator/map";
import {Router} from "@angular/router";

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
  checkResult:any;
  public incorrectUsername:boolean = false;

  constructor(public _http: Http, public router: Router) {
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

  checkIsValidUser(name:string, password:string){
    return Observable.of(this._http.get('http://localhost:8080/api/userRole/checkUser/'+name+'/'+password));
  }

  setValidUser(user: User){
    this.user = user
  }

  checkUser(name:string, password:string){
    let data = new URLSearchParams();
    data.append('name', name);
    data.append('password', password);

    this._http
      .get('http://localhost:8080/api/userRole/checkUser/'+name+'/'+password)
      .subscribe(data => {
        this.checkResult = data.json();
        console.log(this.checkResult)
        if(!this.checkResult.valid || data.status == 500){
          this.incorrectUsername = true;
          return true;
        } else {
          //  this.getUserByUsername(name);
          //   this.setUser();
          this.user = this.checkResult.data;
            let redirect = this.redirectUrl ? this.redirectUrl : '/pages/dashboard';
            this.router.navigate([redirect]);
        }
      }, error => {
        this.incorrectUsername = true;
        console.log(error.json());
        return false;
      });

      return true;
  }
}

class UserModel implements User {
  name: string;
  password: string;
  role: string;
}

