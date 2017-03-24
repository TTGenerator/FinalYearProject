/**
 * Created by jayani on 3/23/2017.
 */
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';


const appRoutes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'page-login', component: LoginComponent },
  { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
