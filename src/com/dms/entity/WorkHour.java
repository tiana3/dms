package com.dms.entity;
//  ��ʱ��λʵ�壬  �ϲ������ݿ�����ű�
public class WorkHour {
	private int standardHourId; //��׼��ʱ��id
	private double standardHour; //��׼��ʱ
	
	private int workplaceId;//��λid
	private String workplaceName;//��λ��
	private double workhour;// ��λ���蹤ʱ
	private double workpay;// �ù�λ ��ʱ��  ʵ���� standardHour*workhour
	private int modelId;  //�����ͺŵ�id
	
	
	
	public WorkHour() {
		super();
	}
	public WorkHour(int workplaceId, String workplaceName, double workhour, double workpay) {
		super();
		this.workplaceId = workplaceId;
		this.workplaceName = workplaceName;
		this.workhour = workhour;
		this.workpay = workpay;
	}
	public WorkHour(int standardHourId, double standardHour, int workplaceId, String workplaceName, double workhour,
			double workpay, int modelId) {
		super();
		this.standardHourId = standardHourId;
		this.standardHour = standardHour;
		this.workplaceId = workplaceId;
		this.workplaceName = workplaceName;
		this.workhour = workhour;
		this.workpay = workpay;
		this.modelId = modelId;
	}
	public int getStandardHourId() {
		return standardHourId;
	}
	public void setStandardHourId(int standardHourId) {
		this.standardHourId = standardHourId;
	}
	public double getStandardHour() {
		return standardHour;
	}
	public void setStandardHour(double standardHour) {
		this.standardHour = standardHour;
	}
	public int getWorkplaceId() {
		return workplaceId;
	}
	public void setWorkplaceId(int workplaceId) {
		this.workplaceId = workplaceId;
	}
	public String getWorkplaceName() {
		return workplaceName;
	}
	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}
	public double getWorkhour() {
		return workhour;
	}
	public void setWorkhour(double workhour) {
		this.workhour = workhour;
	}
	public double getWorkpay() {
		return workpay;
	}
	public void setWorkpay(double workpay) {
		this.workpay = workpay;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	
	
}
