package com.dms.entity;

public class Part {
	private int partId;
	private String partName;
	private String partNo;
	private double buyingPrice;
	private double sellingPrice;
	private int modelId;
	private String model;

	
	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partName=" + partName + ", partNo=" + partNo + ", buyingPrice="
				+ buyingPrice + ", sellingPrice=" + sellingPrice + ", modelId=" + modelId + ", model=" + model + "]";
	}
	public Part() {
		super();
	}
	public Part(int partId, String partName, String partNo, double buyingPrice, double sellingPrice, int modelId ,String model) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.partNo = partNo;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.modelId = modelId;
		this.model = model ;
	}
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
		
	
}
