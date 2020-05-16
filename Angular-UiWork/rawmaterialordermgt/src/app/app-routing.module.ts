import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddOrderComponent } from './add-order/add-order.component';
import { DisplayOrdersComponent } from './display-orders/display-orders.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { OrderMgtComponent } from './order-mgt/order-mgt.component';


const routes: Routes = [
  {
    path:'add-order',
  component:AddOrderComponent
  },

  {
   path:'display-orders',
   component:DisplayOrdersComponent
  },

  {
  path:'update-order',
  component:UpdateOrderComponent
  },

  {
  path :'order-mgt',
  component:OrderMgtComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
