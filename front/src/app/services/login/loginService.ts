/**
 * Created by jayani on 3/24/2017.
 */
import {Injectable} from '@angular/core';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';
import {UserRole} from "../../model/user-role";
import {User} from "../../model/user";

@Injectable()
export class LoginService {
  isLoggedIn: boolean = false;
  redirectUrl: string;
  username: string;
  user: User = new UserModel();
  private _usersList = [
    {
      user_name: "e12333",
      password: "e12333",
      user_role: UserRole[UserRole.STUDENT]
    },
    {
      user_name: "e12132",
      password: "e12132",
      user_role: UserRole[UserRole.STUDENT]
    },
    {
      user_name: "e12117",
      password: "e12117",
      user_role: UserRole[UserRole.STUDENT]
    },
    {
      user_name: "admin",
      password: "admin123",
      user_role: UserRole[UserRole.ADMIN]
    },
    {
      user_name: "staff",
      password: "staff123",
      user_role: UserRole[UserRole.STAFF]
    }
  ];

  login(): Observable<boolean> {
    return Observable.of(true).delay(1000).do(val => this.isLoggedIn = true);
  }

  logout(): void {
    this.isLoggedIn = false;
  }

  getUsername(): string {
    return this.user.user_name;
  }

  getPassword(): string {
    return this.user.password;
  }

  getUserRole(): string {
    return this.user.user_role;
  }

  setUser(user_name: string) {
    let userlist = this.getUsersList();
    for (let user of userlist) {
      if (user.user_name == user_name) {
        this.user = user;
      }
    }
  }

  getUser(): User {
    return this.user;
  }

  getPasswordByUsername(user_name: string): string {
    let userlist = this.getUsersList();
    for (let user of userlist) {
      if (user.user_name == user_name) {
        return user.password;
      }
    }
  }

  getUserRoleByeUsername(user_name: string): string {
    let userlist = this.getUsersList();
    for (let user of userlist) {
      if (user.user_name == user_name) {
        return user.user_role;
      }
    }
  }

  getUsersList() {
    return this._usersList;
  }
}
class UserModel implements User {
  user_name: string;
  password: string;
  user_role: string;
}
