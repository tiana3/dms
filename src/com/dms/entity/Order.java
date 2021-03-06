package com.dms.entity;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

	private String orderId;									//订单Id
	
	private CustomerCarInfo customerCarInfo;						//用户车辆信息
	
	private Integer SA;										//服务顾问 记录的是员工的id
	private String  Date;									//开单时间
	private Double mileage;								//里程
	private String carRemark; 								//外观，饰品
	private String remark;									//备注
	private String expectDate;								//预计完成时间
	
	private List<Integer> workplaceIds;                    //存储 选择的 多个工位
	private List<Part> parts;							// 存储 选择的 多个材料
	private List<Custom> customs;                           //存储 自定义维修项目
	
	private Integer repairId;	                               //维修类型ID
	private String sender;							//送修人
	private String senderPhone;                         //送修人电话
	private Integer orderStateId;                      //订单类型id
	private Integer inspector;   //质检，  记录的是员工的id
	//@DateTimeFormat(pattern="yyyy-MM-dd") 该注解将前端传过来的字符串转换成Date类型  暂时没用，因为完工时间不是前端生成，而是自己创建传入的     
	private Date completedDate;                //完工时间
	private Date settlementDate; 				//结算时间
	private Double workPrice;         //总工时费
	private Double partPrice;         //总材料费
	private Double discountPrice;        //折扣金额，结算时用
	private String completedDateString;     //用于对浏览器显示正常格式的时间
	private String 	settlementDateString;	//用于对浏览器显示正常格式的时间
	
	

	public String getSettlementDateString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(settlementDate!=null) {
			settlementDateString = format.format(settlementDate);
		}
		return settlementDateString;
	}
	

	public String getCompletedDateString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(completedDate!=null) {
			completedDateString = format.format(completedDate);
		}
		return completedDateString;
	}
	
	public void setCompletedDateString(String completedDateString) {
		this.completedDateString = completedDateString;
	}
	
	public Double getWorkPrice() {
		return workPrice;
	}
	public void setWorkPrice(Double workPrice) {
		this.workPrice = workPrice;
	}
	public Double getPartPrice() {
		return partPrice;
	}
	public void setPartPrice(Double partPrice) {
		this.partPrice = partPrice;
	}
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Date getCompletedDate() {
		return completedDate;
	}
	

	
	
	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}
	public Integer getOrderStateId() {
		return orderStateId;
	}
	public void setOrderStateId(Integer orderStateId) {
		this.orderStateId = orderStateId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Order(String orderId, CustomerCarInfo customerCarInfo, Integer sA, String date, Double mileage,
			String carRemark, String remark, String expectDate, List<Integer> workplaceIds, List<Part> parts,
			List<Custom> customs, Integer repairId, String sender, String senderPhone, Integer inspector,Date settlementdate) {
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
		this.parts = parts;
		this.customs = customs;
		this.repairId = repairId;
		this.sender = sender;
		this.senderPhone = senderPhone;
		this.inspector = inspector;
		this.settlementDate = settlementdate;
	}
	public Integer getInspector() {
		return inspector;
	}
	public void setInspector(Integer inspector) {
		this.inspector = inspector;
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
	public List<Part> getParts() {
		return parts;
	}
	public void setParts(List<Part> parts) {
		this.parts = parts;
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
	public Order() {
		super();
	}
	public CustomerCarInfo getCustomerCarInfo() {
		return customerCarInfo;
	}
	public void setCustomerCarInfo(CustomerCarInfo customerCarInfo) {
		this.customerCarInfo = customerCarInfo;
	}
	public Order(CustomerCarInfo customerCarInfo, Integer sA, Integer repairId) {
		super();
		this.customerCarInfo = customerCarInfo;
		SA = sA;
		this.repairId = repairId;
	}
	
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	

	
}
