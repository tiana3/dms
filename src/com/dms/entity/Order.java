package com.dms.entity;

import java.util.List;

public class Order {

	private int orderId;									//订单Id
	private CustomerCarInfo customerCarInfo;						//用户车辆信息
	private int SA;										//服务顾问
	private String  Date;									//开单时间
	private Double mileage;								//里程
	private String carRemark; 								//外观，饰品
	private String remark;									//备注
	private String expectDate;								//预计完成时间
	private List<Integer> workplaceIds;                    //存储 选择的 多个工位
	private List<Integer> partIds;							// 存储 选择的 多个材料
	private List<Custom> customs;                           //存储 自定义维修项目
	private int repairId;	
	
	public Order(){}

	public Order(int orderId, CustomerCarInfo customerCarInfo, int sA, String date, Double mileage, String carRemark,
			String remark, String expectDate, List<Integer> workplaceIds, List<Integer> partIds, List<Custom> customs,
			int repairId) {
		super();
		this.orderId = orderId;
		this.customerCarInfo = customerCarInfo;
		SA = sA;
		Date = date;
		this.mileage = mileage;
		this.carRemark = carRemark;
		this.remark = remark;
		this.expectDate = expectDate;
		this.workplaceIds = workplaceIds;
		this.partIds = partIds;
		this.customs = customs;
		this.repairId = repairId;
	}



	public List<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(List<Custom> customs) {
		this.customs = customs;
	}

	public int getRepairId() {
		return repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	public List<Integer> getWorkplaceIds() {
		return workplaceIds;
	}


	public void setWorkplaceIds(List<Integer> workplaceIds) {
		this.workplaceIds = workplaceIds;
	}



	public List<Integer> getPartIds() {
		return partIds;
	}



	public void setPartIds(List<Integer> partIds) {
		this.partIds = partIds;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public CustomerCarInfo getCustomerCarInfo() {
		return customerCarInfo;
	}

	public void setCustomerCarInfoId(CustomerCarInfo customerCarInfo) {
		this.customerCarInfo = customerCarInfo;
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
