package com.sg.cardealership.dto;

import java.math.BigDecimal;
import java.util.List;

public class SalesReport {
	
	private String user;
	private BigDecimal totalSaleValue;
	private int saleCount;
	public SalesReport(List<purchase> userPurchases) {
		user = userPurchases.get(0).getUser().getUserName();
		saleCount = 0;
		totalSaleValue = new BigDecimal("0.00");
		for(purchase p: userPurchases) {
			totalSaleValue.add(p.getPrice());
			saleCount++;
		}
	}
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
