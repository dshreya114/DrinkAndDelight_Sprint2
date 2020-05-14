package com.cg.rawmaterialordermgt.dto;

public class RawMaterialDetailsDto {

	private String orderId;
	private String name;
	private  double quantityvalue;
	private String warehouseId;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQuantityvalue() {
		return quantityvalue;
	}
	public void setQuantityvalue(double quantityvalue) {
		this.quantityvalue = quantityvalue;
	}
	
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	
}
