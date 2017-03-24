/**
 * Created by jayani on 3/24/2017.
 */
import {Component} from '@angular/core';
import {LoginService} from "../common/services/login/loginService";


@Component({
  moduleId: module.id,
  selector: 'page-home',
  templateUrl: 'home.html'
})

export class HomeComponent {

  constructor(public LoginService: LoginService){}
  logout() {
    this.LoginService.logout();
  }
}
