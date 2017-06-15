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
  public activeRole;

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
        this.activeRole = this.BaMenuService.dashboardRole;
        break;
      case "manage":
        this.activeRole = this.BaMenuService.manageRole;
        break;
      case "generateTT":
        this.activeRole = this.BaMenuService.generateTTRole;
        break;
      case "viewTT":
        this.activeRole = this.BaMenuService.viewTTRole;
        break;
      case "addPreferences":
        this.activeRole = this.BaMenuService.addPreferencesRole;
        break;
      case "mail":
        this.activeRole = this.BaMenuService.mailRole;
        break;
    }
    let role = this.LoginService.getRole();
    if (this.activeRole == role) {
      return true;
    }
    this.LoginService.redirectUrl = url;
    this.router.navigate(['/login']);
    return false;
  }
}
