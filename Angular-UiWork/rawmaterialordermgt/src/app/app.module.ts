import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { DisplayOrdersComponent } from './display-orders/display-orders.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { RawMaterialOrderService } from './services/rawmaterialorderservice';
import { OrderMgtComponent } from './order-mgt/order-mgt.component';

@NgModule({
  declarations: [
    AppComponent,
    AddOrderComponent,
    DisplayOrdersComponent,
    UpdateOrderComponent,
    OrderMgtComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [RawMaterialOrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
