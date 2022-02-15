import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { StartComponent } from './start/start.component';
import { SaveUserComponent } from './users/save-user/save-user.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  { path: '', component: DashboardComponent, children: [
    { path: '', component: StartComponent },
    { path: 'users', component: UsersComponent },
    { path: 'save-user', component: SaveUserComponent }
  ]  
},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
