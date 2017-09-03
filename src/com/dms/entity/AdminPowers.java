package com.dms.entity;

import java.util.List;

public class AdminPowers {

	private Integer adminId ;	  //操作员id
	private String name;		//操作员真实姓名
	private List<Integer> powerIds;   //操作员的权限ID
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getPowerIds() {
		return powerIds;
	}
	public void setPowerIds(List<Integer> powerIds) {
		this.powerIds = powerIds;
	}
	public AdminPowers(Integer adminId, String name, List<Integer> powerIds) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.powerIds = powerIds;
	}
	public AdminPowers() {
		super();
	}
	

	
}
