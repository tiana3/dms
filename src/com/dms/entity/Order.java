package com.dms.entity;

import java.util.List;

public class Order {

	private Integer orderId;									//订单Id
	private CustomerCarInfo customerCarInfo;						//用户车辆信息
	private Integer SA;										//服务顾问
	private String  Date;									//开单时间
	private Double mileage;								//里程
	private String carRemark; 								//外观，饰品
	private String remark;									//备注
	private String expectDate;								//预计完成时间
	private List<Integer> workplaceIds;                    //存储 选择的 多个工位
	private List<Integer> partIds;							// 存储 选择的 多个材料
	private List<Custom> customs;                           //存储 自定义维修项目
	private Integer repairId;	                               //维修类型ID
	private String sender;							//送修人
	private String senderPhone;                         //送修人电话
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public CustomerCarInfo getCustomerCarInfo() {
		return customerCarInfo;
	}
	public void setCustomerCarInfo(CustomerCarInfo customerCarInfo) {
		this.customerCarInfo = customerCarInfo;
	}
	public Integer getSA() {
		return SA;
	}
	public void setSA(Integer sA) {
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
	public List<Custom> getCustoms() {
		return customs;
	}
	public void setCustoms(List<Custom> customs) {
		this.customs = customs;
	}
	public Integer getRepairId() {
		return repairId;
	}
	public void setRepairId(Integer repairId) {
		this.repairId = repairId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public Order(Integer orderId, CustomerCarInfo customerCarInfo, Integer sA, String date, Double mileage,
			String carRemark, String remark, String expectDate, List<Integer> workplaceIds, List<Integer> partIds,
			List<Custom> customs, Integer repairId, String sender, String senderPhone) {
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
		this.sender = sender;
		this.senderPhone = senderPhone;
	}
	public Order() {
		super();
	}
	

	
	
	
}
