/**
 * Created by jayani on 4/10/2017.
 */
import {Injectable} from "@angular/core";
import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, Routes} from "@angular/router";
import {LoginService} from "../login/loginService";
import {PAGES_MENU} from "../../pages/pages.menu";
import {BaMenuService} from "../../theme/services/baMenu/baMenu.service";
@Injectable()
export class ManageRouteGuard implements CanActivate {

  constructor(private LoginService: LoginService, private router: Router, private BaMenuService:BaMenuService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let url: string = state.url;
    return this.isAuthorized(url);
  }

  isAuthorized(url: string): boolean {
    let manageUserRole = this.BaMenuService.manageUserRole;
    let user_role =  this.LoginService.getUserRole();
    if (manageUserRole==user_role){
      return true;
    }
    this.LoginService.redirectUrl = url;
    this.router.navigate(['/login']);
    return false;
  }
}
