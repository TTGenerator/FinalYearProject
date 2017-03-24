import { Component } from '@angular/core';
import {LoaderService} from "./common/services/loader/loaderService";

@Component({
  moduleId: module.id,
  selector: 'my-app',
  templateUrl: 'app.component.html'
})
export class AppComponent  {
  showLoader: boolean;
  constructor(
    private loaderService: LoaderService) {
  }
  ngOnInit() {
    this.loaderService.status.subscribe((val: boolean) => {
      this.showLoader = val;
    });
  }

}
