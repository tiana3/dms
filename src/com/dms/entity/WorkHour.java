package com.dms.entity;
//  ��ʱ��λʵ�壬  �ϲ������ݿ�����ű�
public class WorkHour {
	private Integer standardHourId; //��׼��ʱ��id
	private Double standardHour; //��׼��ʱ
	
	private Integer workplaceId;//��λid
	private String workplaceName;//��λ��
	private Double workhour;// ��λ���蹤ʱ
	private Double workpay;// �ù�λ ��ʱ��  ʵ���� standardHour*workhour
	private Integer modelId;  //�����ͺŵ�id
	
	public WorkHour(Integer workplaceId, String workplaceName, Double workhour, Double workpay, Integer modelId) {
		super();
		this.workplaceId = workplaceId;
		this.workplaceName = workplaceName;
		this.workhour = workhour;
		this.workpay = workpay;
		this.modelId = modelId;
	}

	public WorkHour() {
		super();
	}
	
	public WorkHour(String workplaceName) {
		super();
		this.workplaceName = workplaceName;
	}
	
	public WorkHour(String workplaceName,Double workhour, Double workpay) {
		super();
		this.workplaceName = workplaceName;
		this.workhour = workhour;
		this.workpay = workpay;
	}
	
	public WorkHour(Integer workplaceId, String workplaceName, Double workhour, Double workpay) {
		super();
		this.workplaceId = workplaceId;
		this.workplaceName = workplaceName;
		this.workhour = workhour;
		this.workpay = workpay;
	}
	
	public WorkHour(Integer standardHourId, Double standardHour, Integer workplaceId, String workplaceName, Double workhour,
			double workpay, Integer modelId) {
		super();
		this.standardHourId = standardHourId;
		this.standardHour = standardHour;
		this.workplaceId = workplaceId;
		this.workplaceName = workplaceName;
		this.workhour = workhour;
		this.workpay = workpay;
		this.modelId = modelId;
	}
	public Integer getStandardHourId() {
		return standardHourId;
	}
	public void setStandardHourId(Integer standardHourId) {
		this.standardHourId = standardHourId;
	}
	public Double getStandardHour() {
		return standardHour;
	}
	public void setStandardHour(Double standardHour) {
		this.standardHour = standardHour;
	}
	public Integer getWorkplaceId() {
		return workplaceId;
	}
	public void setWorkplaceId(Integer workplaceId) {
		this.workplaceId = workplaceId;
	}
	public String getWorkplaceName() {
		return workplaceName;
	}
	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}
	public Double getWorkhour() {
		return workhour;
	}
	public void setWorkhour(Double workhour) {
		this.workhour = workhour;
	}
	public Double getWorkpay() {
		return workpay;
	}
	public void setWorkpay(Double workpay) {
		this.workpay = workpay;
	}
	public Integer getModelId() {
		return modelId;
	}
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	@Override
	public String toString() {
		return "WorkHour [workplaceId=" + workplaceId + ", workplaceName=" + workplaceName + ", workhour=" + workhour
				+ ", workpay=" + workpay + "]";
	}
	
	
}
