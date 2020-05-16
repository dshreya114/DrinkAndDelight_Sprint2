import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RawMaterialOrder } from '../model/rawMaterialOrder';
import { Observable } from 'rxjs';

@Injectable()
export class RawMaterialOrderService{

   client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
  }
  
  baseOrderUrl = "http://localhost:8086/rawMaterialOrders";
  
 /**
  * fires post request to server with rawmaterialorder as body
  */
  addOrder(order:RawMaterialOrder): Observable<RawMaterialOrder>{
    let url=this.baseOrderUrl+"/placeRawMaterialOrder";
    let result:Observable<RawMaterialOrder>= this.client.post<RawMaterialOrder>(url,order);
    return result;
    }

    /**
   * fires get request to server to fetch all orders
   */
  fetchAllOrders():Observable<RawMaterialOrder[]>
  {
    let url=this.baseOrderUrl+"/displayRawMaterialOrders";
    let observable:Observable<RawMaterialOrder[]> =this.client.get<RawMaterialOrder[]>(url);
    return observable;
  }

    /**
   * fires put request to server to update the delivery status of order
   */
  updateOrder(order: RawMaterialOrder):Observable<RawMaterialOrder>
 {
     let url = this.baseOrderUrl+"/updateRawMaterialDeliveryStatus";
     let result: Observable<RawMaterialOrder>=this.client.put<RawMaterialOrder>(url,order);
     return result;
 }
}