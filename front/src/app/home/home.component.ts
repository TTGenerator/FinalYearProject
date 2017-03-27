/**
 * Created by jayani on 3/24/2017.
 */
import {Component} from '@angular/core';
import {LoginService} from "../common/services/login/loginService";
import {LoaderService} from "../common/services/loader/loaderService";


@Component({
  moduleId: module.id,
  selector: 'page-home',
  templateUrl: 'home.html'
})

export class HomeComponent {
public username:string;
  constructor(public LoginService: LoginService, private loaderService: LoaderService){
    this.username = this.LoginService.getUsername();
  }
  ngOnInit() {
    //http call starts
    this.loaderService.display(true);
    //http call ends
    this.loaderService.display(false);
  }

  logout() {
    this.LoginService.logout();
  }
}
