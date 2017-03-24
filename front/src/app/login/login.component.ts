
/**
 * Created by jayani on 3/23/2017.
 */
import {Component} from '@angular/core';
import { Router } from '@angular/router';
import { Http } from '@angular/http';

@Component({
  moduleId: module.id,
  selector: 'page-login',
  templateUrl: 'login.html'
})

export class LoginComponent {
  constructor(public router: Router, public http: Http){}

  login(username:string, password:string) {
    if(username== "e12132" && password=="e12132"||username== "e12117" && password=="e12117"||username== "e12333"&& password=="e12333"){
      this.router.navigate(['page-home']);
    }else{
      this.router.navigate(['page-login'])
    }
  }
};


