import { NgModule } from '@angular/core';
import { Routes ,RouterModule } from '@angular/router';
import { MensstoreComponent } from './mensstore/mensstore.component';
import { WomensstoreComponent } from './womensstore/womensstore.component';
const routes: Routes = [{
  path: 'mensstore',
  component: MensstoreComponent},
{  path: 'womensstore',
  component: WomensstoreComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
