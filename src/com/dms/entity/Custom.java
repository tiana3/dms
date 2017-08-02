package com.dms.entity;

public class Custom {
	private String orderId;
	private String customName;
	private double customPrice;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public double getCustomPrice() {
		return customPrice;
	}
	public void setCustomPrice(double customPrice) {
		this.customPrice = customPrice;
	}
	public Custom(String orderId, String customName, double customPrice) {
		super();
		this.orderId = orderId;
		this.customName = customName;
		this.customPrice = customPrice;
	}
	public Custom() {
		super();
	}
	
	
}
