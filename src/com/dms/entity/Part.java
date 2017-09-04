package com.dms.entity;

public class Part {
	private Integer Id;         //这是在order_part中间表里的 主键Id
	private int partId;
	private String partName;
	private String partNo;
	private double buyingPrice;
	private double sellingPrice;
	private int modelId;
	private String model;
	private Integer picker;          //维护一个领料人Id，用于存储订单中材料的领料人
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getPicker() {
		return picker;
	}
	public void setPicker(Integer picker) {
		this.picker = picker;
	}
	
	@Override
	public String toString() {
		return "Part [Id=" + Id + ", partId=" + partId + ", partName=" + partName + ", partNo=" + partNo
				+ ", buyingPrice=" + buyingPrice + ", sellingPrice=" + sellingPrice + ", modelId=" + modelId
				+ ", model=" + model + ", picker=" + picker + "]";
	}
	public Part(Integer id, int partId, String partName, String partNo, double buyingPrice, double sellingPrice,
			int modelId, String model, Integer picker) {
		super();
		Id = id;
		this.partId = partId;
		this.partName = partName;
		this.partNo = partNo;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.modelId = modelId;
		this.model = model;
		this.picker = picker;
	}
	public Part() {
		super();
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
