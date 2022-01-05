package com.sg.cardealership.dto;

import java.math.BigDecimal;

public class SalesReport {
	
	private String user;
	private BigDecimal totalSaleValue;
	private int saleCount;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public BigDecimal getTotalSaleValue() {
		return totalSaleValue;
	}
	public void setTotalSaleValue(BigDecimal totalSaleValue) {
		this.totalSaleValue = totalSaleValue;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

}
