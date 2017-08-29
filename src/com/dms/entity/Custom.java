package com.dms.entity;

public class Custom {
	private String orderId;
	private String customName;
	private double customPrice;
	private Integer employeeId;    //¼¼Ê¦ID
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
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

	public Custom(String orderId, String customName, double customPrice, Integer employeeId) {
		super();
		this.orderId = orderId;
		this.customName = customName;
		this.customPrice = customPrice;
		this.employeeId = employeeId;
	}
	public Custom() {
		super();
	}
	
	
}
