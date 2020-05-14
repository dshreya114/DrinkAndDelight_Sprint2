import { Component, OnInit } from '@angular/core';
import { RawMaterialOrder } from '../model/rawMaterialOrder';

@Component({
  selector: 'display-orders',
  templateUrl: './display-orders.component.html',
  styleUrls: ['./display-orders.component.css']
})
export class DisplayOrdersComponent implements OnInit {

  constructor() { }
  
  orders:RawMaterialOrder[]=[];
  
  ngOnInit(): void {
    this.orders.push( new RawMaterialOrder("Lemon","9687564",800));
    this.orders.push(new RawMaterialOrder("Apple","9745453",10000));
    this.orders.push(new RawMaterialOrder("Pineapple","5463431",2000));
  }
  
}
