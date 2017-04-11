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
  public route: any;
  public activeUserRole;

  constructor(private LoginService: LoginService, private router: Router, private BaMenuService: BaMenuService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    this.route = route;
    let url: string = state.url;
    return this.isAuthorized(url);
  }

  isAuthorized(url: string): boolean {
    switch (this.route.routeConfig.path) {
      case "dashboard":
        this.activeUserRole = this.BaMenuService.dashboardUserRole;
        break;
      case "manage":
        this.activeUserRole = this.BaMenuService.manageUserRole;
        break;
      case "generateTT":
        this.activeUserRole = this.BaMenuService.generateTTUserRole;
        break;
      case "viewTT":
        this.activeUserRole = this.BaMenuService.viewTTUserRole;
        break;
      case "addPreferences":
        this.activeUserRole = this.BaMenuService.addPreferencesUserRole;
        break;
      case "mail":
        this.activeUserRole = this.BaMenuService.mailUserRole;
        break;
    }
    let user_role = this.LoginService.getUserRole();
    if (this.activeUserRole == user_role) {
      return true;
    }
    this.LoginService.redirectUrl = url;
    this.router.navigate(['/login']);
    return false;
  }
}
