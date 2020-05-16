package com.cg.rawmaterialordermgt.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.cg.rawmaterialordermgt.dto.DeliveryStatusDto;
import com.cg.rawmaterialordermgt.dto.RawMaterialDetailsDto;
import com.cg.rawmaterialordermgt.dto.RawMaterialOrderRequestDto;
import com.cg.rawmaterialordermgt.dto.RawMaterialOrderResponseDto;
import com.cg.rawmaterialordermgt.entities.RawMaterialOrderEntity;
import com.cg.rawmaterialordermgt.exceptions.RawMaterialOrderNotFoundException;
import com.cg.rawmaterialordermgt.service.RawMaterialOrderServiceImpl;


@RestController
  
//maps HTTP request with a path to a controller method
@RequestMapping(value = "/rawMaterialOrders")  
public class RawMaterialOrderController {

	//logger is used for debugging
	 private static final Logger log = LoggerFactory.getLogger(RawMaterialOrderController.class);
	 
	 
	@Autowired
	private RawMaterialOrderServiceImpl service;
	
	@PostMapping("/placeRawMaterialOrder")    //method for placing an order
	public ResponseEntity<RawMaterialOrderResponseDto> placeRawMaterialOrder(@RequestBody RawMaterialOrderRequestDto  requestDto) throws ParseException
	{
		RawMaterialOrderEntity rawMaterialOrderEntity = convertFromDto(requestDto) ;
		String msg = service.placeRawMaterialOrder(rawMaterialOrderEntity);
		RawMaterialOrderResponseDto responseDto= convertRawMaterialOrder(rawMaterialOrderEntity);
		ResponseEntity<RawMaterialOrderResponseDto> response = new ResponseEntity<>(responseDto,HttpStatus.OK);
		return response;
	}
  
	//method for converting requestDto to entity class
	public  RawMaterialOrderEntity  convertFromDto(RawMaterialOrderRequestDto  requestDto)
	{
		RawMaterialOrderEntity rawMaterialOrderEntity = new RawMaterialOrderEntity();
		rawMaterialOrderEntity.setName(requestDto.getName());
		rawMaterialOrderEntity.setSupplierId(requestDto.getSupplierId());
		rawMaterialOrderEntity.setWarehouseId(requestDto.getWarehouseId());
		rawMaterialOrderEntity.setQuantityValue(requestDto.getQuantityValue());
		rawMaterialOrderEntity.setPricePerUnit(requestDto.getPricePerUnit());
		return rawMaterialOrderEntity;
	}
	
	//method for converting entity class to responseDto
	private RawMaterialOrderResponseDto convertRawMaterialOrder(RawMaterialOrderEntity rawMaterialOrderEntity) {
		RawMaterialOrderResponseDto responseDto = new RawMaterialOrderResponseDto();
		responseDto.setOrderId(rawMaterialOrderEntity.getOrderId());
		responseDto.setTotalPrice(rawMaterialOrderEntity.getTotalPrice());
		responseDto.setDateOfOrder(rawMaterialOrderEntity.getDateOfOrder());
		responseDto.setDateOfDelivery(rawMaterialOrderEntity.getDateOfDelivery());
		return responseDto;
	}

	@PutMapping("/updateRawMaterialDeliveryStatus")   //method for updating an order
	public ResponseEntity<RawMaterialOrderEntity> updateDeliveryStatus (@RequestBody DeliveryStatusDto dto)
	{
		RawMaterialOrderEntity rawMaterialOrder = service.updateStatusRawMaterialOrder(dto.getOrderId(),dto.getDeliveryStatus());
		ResponseEntity<RawMaterialOrderEntity>  response = new ResponseEntity<>(rawMaterialOrder,HttpStatus.OK); 
		return response;
	}
	
	@GetMapping("/displayRawMaterialOrders")   //method for fetching all the orders
	public ResponseEntity<List<RawMaterialDetailsDto>> displayRawMaterialOrders()
	{
		List<RawMaterialOrderEntity> rawMaterials = service.displayRawMaterialOrders();
		List<RawMaterialDetailsDto> detailsDto = convertRawMaterialDetails(rawMaterials);
	        ResponseEntity<List<RawMaterialDetailsDto>> response = new ResponseEntity<>(detailsDto, HttpStatus.OK);
	        return response;
	    }
	
	//method for converting list of entity class to dto 
	    public List<RawMaterialDetailsDto> convertRawMaterialDetails(List<RawMaterialOrderEntity> rawMaterials) {
	        List<RawMaterialDetailsDto> list = new ArrayList<>();
	        for (RawMaterialOrderEntity rawMaterial : rawMaterials) {
	        	RawMaterialDetailsDto detailsDto = convertRawMaterialDetails(rawMaterial);
	            list.add(detailsDto);
	        }
	        return list;
	    }

	    //method for converting entity class to response dto 
	        RawMaterialDetailsDto convertRawMaterialDetails(RawMaterialOrderEntity  rawMaterialOrder) {
	    	RawMaterialDetailsDto detailsDto = new  RawMaterialDetailsDto();
	       detailsDto.setOrderId(rawMaterialOrder.getOrderId());
	       detailsDto.setName(rawMaterialOrder.getName());
	       detailsDto.setQuantityValue(rawMaterialOrder.getQuantityValue());
	       detailsDto.setWarehouseId(rawMaterialOrder.getWarehouseId());
	       detailsDto.setSupplierId(rawMaterialOrder.getSupplierId());
	       detailsDto.setTotalPrice(rawMaterialOrder.getTotalPrice());
	       detailsDto.setDateOfOrder(rawMaterialOrder.getDateOfOrder());
	       return detailsDto;
	    }
	        
	        //handling exception RawMaterialOrderNotFound by this method
	        @ExceptionHandler( RawMaterialOrderNotFoundException.class)
	        public ResponseEntity<String> handleOrderNotFound ( RawMaterialOrderNotFoundException ex) {
	           log.error("handling Order not found exception", ex);  // this will get logged
	            String msg = ex.getMessage();
	            ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	            return response;
	        }
 
	        //handling all the exceptions by this method
	        @ExceptionHandler(Throwable.class)
	        public ResponseEntity<String> handleAll(Throwable ex) {
	            log.error("handling all the exceptions", ex);  // this will get logged
	            String msg = ex.getMessage();
	            ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	            return response;
	        }


	
}
