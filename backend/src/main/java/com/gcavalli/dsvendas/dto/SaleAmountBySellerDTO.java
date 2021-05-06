package com.gcavalli.dsvendas.dto;

import java.io.Serializable;

import com.gcavalli.dsvendas.entities.Seller;

public class SaleAmountBySellerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Double sum;
	
	public SaleAmountBySellerDTO() {
	}

	public SaleAmountBySellerDTO(Seller seller, Double sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
	
}
