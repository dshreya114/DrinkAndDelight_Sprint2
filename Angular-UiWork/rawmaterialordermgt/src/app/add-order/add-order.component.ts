import { Component, OnInit } from '@angular/core';
import { RawMaterialOrder } from '../model/rawMaterialOrder';


@Component({
  selector: 'add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  constructor() { }
  

  rawMaterialOrder : RawMaterialOrder=null;

  ngOnInit(): void {
  }
   
  addOrder(form:any)
  {
    let data = form.value;
    let name = data.name;
    let supplierId = data.supplierId;
    let warehouseId = data.warehouseId;
    let quantityValue = data.quantityValue;
    let pricePerUnit = data.pricePerUnit;
    this.rawMaterialOrder = new RawMaterialOrder();
   this.rawMaterialOrder.orderId = "93838121";
   let totalPrice = pricePerUnit*quantityValue;
   this.rawMaterialOrder.totalPrice= totalPrice;
   form.reset();
  }

}
