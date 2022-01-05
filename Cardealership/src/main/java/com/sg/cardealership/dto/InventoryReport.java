package com.sg.cardealership.dto;

import java.math.BigDecimal;

public class InventoryReport {
	
	private int year;
	private String make;
	private String model;
	private int count;
	private BigDecimal stockValue;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BigDecimal getStockValue() {
		return stockValue;
	}
	public void setStockValue(BigDecimal stockValue) {
		this.stockValue = stockValue;
	}

}
