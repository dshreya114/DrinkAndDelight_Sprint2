package  com.cg.rawmaterialordermgt.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity  //indicates that this class is an entity class
@Table(name = "rawmaterialorders")   
public class RawMaterialOrderEntity {

    @Id    
    private  String  orderId;
    private String name;
    private String supplierId;
    private double quantityValue;
    private String quantityUnit;
    private Date dateOfOrder;
    private Date dateOfDelivery;
    private double pricePerUnit;
    private double totalPrice;
    private String  deliveryStatus;
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
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public double getQuantityValue() {
		return quantityValue;
	}
	public void setQuantityValue(double quantityValue) {
		this.quantityValue = quantityValue;
	}
	public String getQuantityUnit() {
		return quantityUnit;
	}
	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RawMaterialOrderEntity entity = (RawMaterialOrderEntity )object;
        return orderId ==entity.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
    
}
