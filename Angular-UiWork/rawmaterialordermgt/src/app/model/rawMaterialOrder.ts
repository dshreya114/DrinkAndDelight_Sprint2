export class RawMaterialOrder{
    orderId     : String;
    name        : String;
    quantityValue:number;
    warehouseId : String;
    pricePerUnit: number;
    quantityUnit: String;
    deliveryStatus:String;
    totalPrice: number;
    dateOfOrder : Date;
    dateOfDelivery: Date;
    supplierId  : String;

  constructor(name : String,orderId : String,totalPrice: number)
  {
this.name = name;
this.orderId=orderId;
this.totalPrice=totalPrice;
  }
  
    
}