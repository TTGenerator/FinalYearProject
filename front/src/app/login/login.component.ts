
/**
 * Created by jayani on 3/23/2017.
 */
import {Component} from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from "../common/services/login/loginService";
import {LoaderService} from "../common/services/loader/loaderService";

@Component({
  moduleId: module.id,
  selector: 'page-login',
  templateUrl: 'login.html'
})

export class LoginComponent {
  // constructor(public router: Router, public http: Http){}

  // login(username:string, password:string) {
  //   if(username== "e12132" && password=="e12132"||username== "e12117" && password=="e12117"||username== "e12333"&& password=="e12333"){
  //     this.router.navigate(['page-home']);
  //   }else{
  //     this.router.navigate(['page-login'])
  //   }
  // }



  message: string;
  constructor(public LoginService: LoginService, public router: Router,private loaderService: LoaderService) {
    this.setMessage();
  }
  ngOnInit() {
    //http call starts
    this.loaderService.display(true);
    //http call ends
    this.loaderService.display(false);
  }

  setMessage() {
    this.message = 'Logged ' + (this.LoginService.isLoggedIn ? 'in' : 'out');
  }

  login(username:string, password:string) {
    if(username== "e12132" && password=="e12132"||username== "e12117" && password=="e12117"||username== "e12333"&& password=="e12333"){
      this.message = 'Trying to log in ...';
      this.LoginService.login().subscribe(() => {
        this.setMessage();
        if (this.LoginService.isLoggedIn) {
          let redirect = this.LoginService.redirectUrl ? this.LoginService.redirectUrl : 'page-home';
          this.router.navigate([redirect]);
        }
      });
    }else{
      this.router.navigate(['page-login'])
    }

  }
  logout() {
    this.LoginService.logout();
    this.setMessage();
  }
};


