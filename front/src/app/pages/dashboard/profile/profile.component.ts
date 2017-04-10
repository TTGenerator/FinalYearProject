/**
 * Created by maheshika on 4/1/2017.
 */

import {Component} from '@angular/core';
import {LoginService} from "../../../services/login/loginService";
import {User} from "../../../model/user";

@Component({
  selector: 'profile',
  templateUrl: './profile.html'
})
export class Profile {
  user:User;
  constructor(public LoginService: LoginService) {
    this.user= this.LoginService.getUser();
  }
}
