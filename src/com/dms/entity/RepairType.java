package com.dms.entity;

public class RepairType {
	int repairTypeId;
	String repairType;
	public RepairType(int repairTypeId, String repairType) {
		super();
		this.repairTypeId = repairTypeId;
		this.repairType = repairType;
	}
	public RepairType() {
		super();
	}
	public int getRepairTypeId() {
		return repairTypeId;
	}
	public void setRepairTypeId(int repairTypeId) {
		this.repairTypeId = repairTypeId;
	}
	public String getRepairType() {
		return repairType;
	}
	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}
	
	@Override
	public String toString() {
		return "RepairType [repairTypeId=" + repairTypeId + ", repairType=" + repairType + "]";
	}
	
}
