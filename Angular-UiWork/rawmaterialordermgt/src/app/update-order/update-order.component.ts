import { Component, OnInit } from '@angular/core';
import { RawMaterialOrder } from '../model/rawMaterialOrder';
import { RawMaterialOrderService } from '../services/rawmaterialorderservice';
import { Observable } from 'rxjs';

@Component({
  selector: 'update-order',
  templateUrl: './update-order.component.html',
  styleUrls: ['./update-order.component.css']
})
export class UpdateOrderComponent implements OnInit {
  
  service: RawMaterialOrderService;
  constructor(service: RawMaterialOrderService) { 
    this.service=service;
  }

  rawMaterialOrder:RawMaterialOrder = null;
  errorMsg = null;
  foundStatus=null;


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

    let result =this.service.updateOrder(this.rawMaterialOrder); 
    result.subscribe(
      (rawMaterialOrder:RawMaterialOrder)=>{
      this.rawMaterialOrder=rawMaterialOrder;
      this.foundStatus= "found";
    },

     err=>{
      this.foundStatus = "notFound";
     this.errorMsg = err.error;
     console.log("error while fetching order:"+err);
    }
     );

     form.reset();
    }
  
  }

