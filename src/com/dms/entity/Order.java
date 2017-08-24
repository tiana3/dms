package com.dms.entity;

import java.util.List;

public class Order {

	private Integer orderId;									//����Id
	private CustomerCarInfo customerCarInfo;						//�û�������Ϣ
	private Integer SA;										//�������
	private String  Date;									//����ʱ��
	private Double mileage;								//���
	private String carRemark; 								//��ۣ���Ʒ
	private String remark;									//��ע
	private String expectDate;								//Ԥ�����ʱ��
	private List<Integer> workplaceIds;                    //�洢 ѡ��� �����λ
	private List<Integer> partIds;							// �洢 ѡ��� �������
	private List<Custom> customs;                           //�洢 �Զ���ά����Ŀ
	private Integer repairId;	                               //ά������ID
	private String sender;							//������
	private String senderPhone;                         //�����˵绰
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
