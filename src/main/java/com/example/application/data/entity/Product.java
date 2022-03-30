package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product extends AbstractEntity {
	@NotEmpty
	private String name = " ";
	
	@NotEmpty
	private String manufacturer = " ";
	
	@NotEmpty
	private String style = " ";
	
	private double purchasePrice;
	private double salePrice;
	private int qtyOnHand;
	private double commissionPerc;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	public int getQtyOnHand() {
		return qtyOnHand;
	}
	
	public void setQtyOnHand(int qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}
	
	public double getCommissionPerc() {
		return commissionPerc;
	}
	
	public void setCommissionPerc(double commissionPerc) {
		this.commissionPerc = commissionPerc;
	}
}
