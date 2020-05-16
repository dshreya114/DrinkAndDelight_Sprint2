import { Component, OnInit } from '@angular/core';
import { RawMaterialOrder } from '../model/rawMaterialOrder';
import { RawMaterialOrderService } from '../services/rawmaterialorderservice';


@Component({
  selector: 'add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  service : RawMaterialOrderService;
  constructor(service : RawMaterialOrderService) {
    this.service=service;
   }
  

  rawMaterialOrder : RawMaterialOrder=null;

  ngOnInit(): void {
  }
   
  addOrder(orderForm:any)
  {
    let data = orderForm.value;
    let name = data.name;
    let supplierId = data.supplierId;
    let warehouseId = data.warehouseId;
    let quantityValue = data.quantityValue;
    let pricePerUnit = data.pricePerUnit;
    this.rawMaterialOrder = new RawMaterialOrder();
    this.rawMaterialOrder.name=name;
    this.rawMaterialOrder.supplierId=supplierId;
    this.rawMaterialOrder.warehouseId=warehouseId;
    this.rawMaterialOrder.quantityValue=quantityValue;
    this.rawMaterialOrder.pricePerUnit=pricePerUnit;
  
  let result=this.service.addOrder(this.rawMaterialOrder); // adding to the store
  result.subscribe((rawMaterialOrder:RawMaterialOrder)=>{
    this.rawMaterialOrder=rawMaterialOrder;
  },
   err=>{
  console.log("error ="+err);
  } );
   orderForm.reset();
  }

}
