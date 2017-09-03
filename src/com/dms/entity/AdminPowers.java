package com.dms.entity;

import java.util.List;

public class AdminPowers {

	private Integer adminId ;	  //����Աid
	private String name;		//����Ա��ʵ����
	private List<Integer> powerIds;   //����Ա��Ȩ��ID
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
