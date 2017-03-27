/**
 * Created by jayani on 3/24/2017.
 */
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';

@Injectable()
export class LoginService {
  isLoggedIn: boolean = false;
  redirectUrl: string;
  username:string;
  login(): Observable<boolean> {
    return Observable.of(true).delay(1000).do(val => this.isLoggedIn = true);
  }

  logout(): void {
    this.isLoggedIn = false;
  }

  setUsername(username:string):void{
    this.username= username;
  }

  getUsername():string{
    return this.username;
  }
}
