package com.dms.entity;
//  工时工位实体，  合并了数据库的两张表
public class WorkHour {
	private int standardHourId; //标准工时的id
	private double standardHour; //标准工时
	
	private int workplaceId;//工位id
	private String workplaceName;//工位名
	private double workhour;// 工位所需工时
	private double workpay;// 该工位 工时费  实际是 standardHour*workhour
	private int modelId;  //车辆型号的id
	
	
	
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
