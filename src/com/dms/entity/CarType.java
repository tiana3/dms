package com.dms.entity;

public class CarType {
	private int modelId;
	private String factory;
	private String model;
		
	public CarType() {
		super();
	}
	public CarType(int modelId, String factory, String model) {
		super();
		this.modelId = modelId;
		this.factory = factory;
		this.model = model;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}
