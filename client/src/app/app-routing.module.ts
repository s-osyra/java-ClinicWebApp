import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PricesRouteComponent } from './prices-route/prices-route.component';
import { HomeComponent } from './home/home.component'



const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  { 
    path: 'cennik', 
    component: PricesRouteComponent 
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
