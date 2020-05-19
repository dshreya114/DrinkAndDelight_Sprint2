package com.cg.rawmaterialordermgt.service;

import java.text.ParseException;
import java.util.List;
import com.cg.rawmaterialordermgt.entities.RawMaterialOrderEntity;


public interface IRawMaterialOrderService {
	
	 boolean doesRawMaterialOrderIdExist(String orderId);
	RawMaterialOrderEntity  updateStatusRawMaterialOrder(String orderId, String deliveryStatus);
	String placeRawMaterialOrder(RawMaterialOrderEntity rawMaterialOrder) throws ParseException;
	List<RawMaterialOrderEntity> displayRawMaterialOrders();

	
}
