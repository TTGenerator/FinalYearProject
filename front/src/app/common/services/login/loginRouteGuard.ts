/**
 * Created by jayani on 3/24/2017.
 */
import { Injectable } from '@angular/core';
import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import { LoginService }      from '../login/loginService';

@Injectable()
export class LoginRouteGuard implements CanActivate {

  constructor(private LoginService: LoginService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let url: string = state.url;
    return this.checkLogin(url);
  }

  checkLogin(url: string): boolean {
    if (this.LoginService.isLoggedIn) { return true; }

    this.LoginService.redirectUrl = url;

    this.router.navigate(['page-login']);
    return false;
  }
}
