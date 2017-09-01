package com.dms.entity;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {

	private String orderId;									//����Id
	private CustomerCarInfo customerCarInfo;						//�û�������Ϣ
	private Integer SA;										//������� ��¼����Ա����id
	
	private String  Date;									//����ʱ��
	private Double mileage;								//���
	private String carRemark; 								//��ۣ���Ʒ
	private String remark;									//��ע
	private String expectDate;								//Ԥ�����ʱ��
	private List<Integer> workplaceIds;                    //�洢 ѡ��� �����λ
	private List<Part> parts;							// �洢 ѡ��� �������
	private List<Custom> customs;                           //�洢 �Զ���ά����Ŀ
	private Integer repairId;	                               //ά������ID
	private String sender;							//������
	private String senderPhone;                         //�����˵绰
	private Integer orderStateId;                      //��������id
	
	private Integer inspector;   //�ʼ죬  ��¼����Ա����id
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")    ��ʱû�ã���Ϊ�깤ʱ�䲻��ǰ�����ɣ������Լ����������     
	private Date completedDate;     //��ǰ�˴��������ַ���ת����Date����
	
	
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
			List<Custom> customs, Integer repairId, String sender, String senderPhone, Integer inspector) {
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
	}
	public Integer getInspector() {
		return inspector;
	}
	public void setInspector(Integer inspector) {
		this.inspector = inspector;
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
	
	
}
