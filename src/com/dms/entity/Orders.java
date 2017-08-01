package com.dms.entity;

public class Orders {

	private int orderId ;									//订单Id
	private String customerCarInfoId ;						//用户车辆信息id
	private int SA ;										//服务顾问
	private String  Date ;									//开单时间
	private Double mileage ;								//里程
	private String carRemark ; 								//外观，饰品
	private String remark ;									//备注
	private String expectDate ;								//预计完成时间
	
	public Orders(){}

	public Orders(int orderId, String customerCarInfoId, int sA, String date, Double mileage, String carRemark,
			String remark, String expectDate) {
		super();
		this.orderId = orderId;
		this.customerCarInfoId = customerCarInfoId;
		SA = sA;
		Date = date;
		this.mileage = mileage;
		this.carRemark = carRemark;
		this.remark = remark;
		this.expectDate = expectDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerCarInfoId() {
		return customerCarInfoId;
	}

	public void setCustomerCarInfoId(String customerCarInfoId) {
		this.customerCarInfoId = customerCarInfoId;
	}

	public int getSA() {
		return SA;
	}

	public void setSA(int sA) {
		SA = sA;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public String getCarRemark() {
		return carRemark;
	}

	public void setCarRemark(String carRemark) {
		this.carRemark = carRemark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExpectDate() {
		return expectDate;
	}

	public void setExpectDate(String expectDate) {
		this.expectDate = expectDate;
	}
	
	
	
}
