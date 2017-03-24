/**
 * Created by jayani on 3/24/2017.
 */
import {Component} from '@angular/core';

@Component({
  moduleId: module.id,
  selector: 'page-home',
  templateUrl: 'home.html'
  // template: '<h1>{{welcome}}</h1>'
})

export class HomeComponent {
  private welcome:string;

  constructor(){
    this.welcome = "welcome home page"
  }
};
