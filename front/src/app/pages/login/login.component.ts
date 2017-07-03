import {Component} from '@angular/core';
import {FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';

import 'style-loader!./login.scss';
import {Router} from "@angular/router";
import {LoginService} from "../../services/login/loginService";
import {User} from "../../model/user";

@Component({
  selector: 'login',
  templateUrl: './login.html',
})
export class Login {

  public form: FormGroup;
  public name: AbstractControl;
  public password: AbstractControl;
  public submitted: boolean = false;
  incorrectUsername:boolean;
  incorrectPassword:boolean=false;
  message: string;

  constructor(fb: FormBuilder, public router: Router, public LoginService: LoginService) {
    this.form = fb.group({
      'name': ['', Validators.compose([Validators.required, Validators.minLength(4)])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(4)])]
    });
    this.incorrectUsername=this.LoginService.incorrectUsername;
    this.name = this.form.controls['name'];
    this.password = this.form.controls['password'];
    this.setMessage();
  }

  setMessage() {
    this.message = 'Logged ' + (this.LoginService.isLoggedIn ? 'in' : 'out');
  }

  // public onSubmit(values: any): void {
  //   this.submitted = true;
  //   if (this.form.valid) {
  //     this.LoginService.getUserByUsername(values.name);
  //     if (values.password == this.LoginService.getPasswordByUsername(values.name)) {
  //       this.LoginService.setUser(values.name);
  //       console.log(this.LoginService.getUser());
  //       this.message = 'Trying to log in ...';
  //       this.LoginService.login().subscribe(() => {
  //         this.setMessage();
  //         if (this.LoginService.isLoggedIn) {
  //           let redirect = this.LoginService.redirectUrl ? this.LoginService.redirectUrl : '/pages/dashboard';
  //           this.router.navigate([redirect]);
  //         }
  //       });
  //     } else {
  //       this.incorrectUsername=this.LoginService.incorrectUsername;
  //       if(!this.incorrectUsername){
  //         this.incorrectPassword= true;
  //       }
  //       this.router.navigate(['/login'])
  //     }
  //   }
  // }

  public onSubmit(values: any): void {
    this.submitted = true;
    if (this.form.valid) {
      if (this.LoginService.checkUser(values.name, values.password)) {
        console.log(this.LoginService.getUser());
        this.message = 'Trying to log in ...';
        this.LoginService.login().subscribe(() => {
          this.setMessage();
          if (this.LoginService.isLoggedIn) {
            let redirect = this.LoginService.redirectUrl ? this.LoginService.redirectUrl : '/pages/dashboard';
            this.router.navigate([redirect]);
          }
        });
      } else {
        console.log(this.LoginService.checkUser(values.name, values.password));
        this.incorrectUsername=this.LoginService.incorrectUsername;
        if(!this.incorrectUsername){
          this.incorrectPassword= true;
        }
        this.router.navigate(['/login'])
      }
    }
  }


  logout() {
    this.LoginService.logout();
    this.setMessage();
  }

//   var isAuthorized = function(authorizedRoles) {
//   if (!angular.isArray(authorizedRoles)) {
//     authorizedRoles = [authorizedRoles];
//   }
//   return (isAuthenticated && authorizedRoles.indexOf(role) !== -1);
// };
}


