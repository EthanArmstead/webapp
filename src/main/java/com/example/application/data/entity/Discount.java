package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Discount extends AbstractEntity{
	@Nullable
	@ManyToOne
	private Product product;
	
	private int beginDate;
	private int endDate;
	private float discPerc;
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getBeginDate() {
		return beginDate;
	}
	
	public void setBeginDate(int beginDate) {
		this.beginDate = beginDate;
	}
	
	public int getEndDate() {
		return endDate;
	}
	
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	
	public float getDiscPerc() {
		return discPerc;
	}
	
	public void setDiscPerc(float discPerc) {
		this.discPerc = discPerc;
	}
}
