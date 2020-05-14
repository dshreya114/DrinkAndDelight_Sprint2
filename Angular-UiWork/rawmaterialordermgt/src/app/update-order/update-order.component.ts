import { Component, OnInit } from '@angular/core';
import { RawMaterialOrder } from '../model/rawMaterialOrder';

@Component({
  selector: 'update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit {

  constructor() { }

  rawMaterialOrder:RawMaterialOrder = null;
  ngOnInit(): void {
  }

  updateOrder(form:any)
  {
    let data=form.value;
    let orderId= data.orderId;
    let deliveryStatus = data.deliveryStatus;
    this.rawMaterialOrder= new RawMaterialOrder();
    this.rawMaterialOrder.orderId=orderId;
    this.rawMaterialOrder.deliveryStatus= deliveryStatus;
    form.reset();
  }
}
