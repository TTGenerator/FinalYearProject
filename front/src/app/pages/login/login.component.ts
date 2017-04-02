import {Component} from '@angular/core';
import {FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';

import 'style-loader!./login.scss';
import {Router} from "@angular/router";
import {LoginService} from "../../services/login/loginService";

@Component({
  selector: 'login',
  templateUrl: './login.html',
})
export class Login {

  public form: FormGroup;
  public name: AbstractControl;
  public password: AbstractControl;
  public submitted: boolean = false;
  message: string;

  constructor(fb: FormBuilder, public router: Router, public LoginService: LoginService) {
    this.form = fb.group({
      'name': ['', Validators.compose([Validators.required, Validators.minLength(6)])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(4)])]
    });

    this.name = this.form.controls['name'];
    this.password = this.form.controls['password'];
    this.setMessage();
  }

  setMessage() {
    this.message = 'Logged ' + (this.LoginService.isLoggedIn ? 'in' : 'out');
  }

  public onSubmit(values: any): void {
    this.submitted = true;
    this.LoginService.setUsername(values.name);
    if (this.form.valid) {
      if (values.name == "e12132" && values.password == "e12132" || values.name == "e12117" && values.password == "e12117" || values.name == "e12333"  ) {
        this.message = 'Trying to log in ...';
        this.LoginService.login().subscribe(() => {
          this.setMessage();
          if (this.LoginService.isLoggedIn) {
            let redirect = this.LoginService.redirectUrl ? this.LoginService.redirectUrl : '/pages/dashboard';
            this.router.navigate([redirect]);
          }
        });
      } else {
        this.router.navigate(['/login'])
      }
    }
  }

  logout() {
    this.LoginService.logout();
    this.setMessage();
  }
}
