package com.cg.rawmaterialordermgt.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.rawmaterialordermgt.dao.IRawMaterialOrderDao;
import com.cg.rawmaterialordermgt.entities.RawMaterialOrderEntity;
import com.cg.rawmaterialordermgt.exceptions.RawMaterialOrderNotFoundException;

@Service    //indicates that this  class is a service class.
@Transactional     
public class RawMaterialOrderServiceImpl implements IRawMaterialOrderService
{
	@Autowired
    private IRawMaterialOrderDao orderDao ;
	
	//method to check orderId exists or not in the database
	@Override
	public boolean doesRawMaterialOrderIdExist(String orderId) {
		 Optional<RawMaterialOrderEntity> optional= orderDao.findById(orderId);
		 if(optional.isPresent())
		 {
			 RawMaterialOrderEntity	order = optional.get();
			 return true;
		 }
		 throw new RawMaterialOrderNotFoundException("Order Id doesn't exist");
	}

	//method for updating an order
	@Override
	public RawMaterialOrderEntity updateStatusRawMaterialOrder(String orderId, String deliveryStatus) {
		 Optional<RawMaterialOrderEntity> optional= orderDao.findById(orderId);
		 if(optional.isPresent())
		 {
			 RawMaterialOrderEntity	order = optional.get();
			 order.setOrderId(orderId);
			 order.setDeliveryStatus(deliveryStatus);
			 return order;
		 }
		 throw new RawMaterialOrderNotFoundException("Order Id doesn't exist");
		 	    
	}

	//method to auto generate a random orderId
	public String generateId()
	{
		StringBuilder id = new StringBuilder();
		for(int i=0; i<10;i++)
		{
			Random random = new Random();
			int number = random.nextInt(9);
			id.append(number);
		}
		return id.toString();
	}
	
	//method for placing an order
	@Override
	public String placeRawMaterialOrder(RawMaterialOrderEntity rawMaterialOrder) {
		String orderId = generateId();
		rawMaterialOrder.setOrderId(orderId);
		
		Date dateOfOrder = new Date();
		 rawMaterialOrder.setDateOfOrder(dateOfOrder);
		 
		 LocalDate todayDate = LocalDate.now();
		 LocalDate deliveryDate = todayDate .plusDays(7);
		 Date dateOfDelivery = new Date(deliveryDate.getYear(), deliveryDate.getMonthValue(),deliveryDate.getDayOfMonth());
		 rawMaterialOrder.setDateOfDelivery(dateOfDelivery);
		 
		 double pricePerUnit = rawMaterialOrder.getPricePerUnit();
		 double quantityValue = rawMaterialOrder.getQuantityValue();
		 double totalPrice = pricePerUnit * quantityValue;
		 rawMaterialOrder.setTotalPrice(totalPrice);
		
		 rawMaterialOrder = 	orderDao.save( rawMaterialOrder);
	   return "Order placed successfully";
	  
	}
	
	//method to display all the orders present in the database
	@Override
	public List<RawMaterialOrderEntity> displayRawMaterialOrders() {
        List<RawMaterialOrderEntity> orders=  orderDao.findAll();
        return orders;
	}

}
