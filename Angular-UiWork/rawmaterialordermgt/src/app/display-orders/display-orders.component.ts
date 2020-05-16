import { Component, OnInit } from '@angular/core';
import { RawMaterialOrder } from '../model/rawMaterialOrder';
import { RawMaterialOrderService } from '../services/rawmaterialorderservice';
import { Observable } from 'rxjs';

@Component({
  selector: 'display-orders',
  templateUrl: './display-orders.component.html',
  styleUrls: ['./display-orders.component.css']
})
export class DisplayOrdersComponent implements OnInit {
  
  orders:RawMaterialOrder[]=[];
   service: RawMaterialOrderService;
   
  constructor(service: RawMaterialOrderService) {
    this.service=service;
    let observable:Observable<RawMaterialOrder[]>=this.service.fetchAllOrders();

  observable.subscribe(
    order=>{
      this.orders=order;
     console.log("Length = "+this.orders.length);
    },
    err=>console.log("Error:" +err)
    );
  }
  
  ngOnInit(): void {

  }
  

  
}
