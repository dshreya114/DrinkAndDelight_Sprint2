import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddOrderComponent } from './add-order/add-order.component';
import { DisplayOrdersComponent } from './display-orders/display-orders.component';
import { UpdateOrderComponent } from './update-order/update-order.component';

@NgModule({
  declarations: [
    AppComponent,
    AddOrderComponent,
    DisplayOrdersComponent,
    UpdateOrderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
