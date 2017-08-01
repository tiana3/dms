package com.dms.entity;

public class AdminRolePower {

	private int adminInt ;									//�û�id
	private String adminName ;								//�û���			
	private String passWord;								//����
	private int roleId ;									//��ɫid 
	private String role ;									//��ɫ��
	private String power ;									//Ȩ����
	private int powerId ;									//Ȩ��id 
	
	public AdminRolePower(){}
	
	public AdminRolePower(int adminInt, String adminName, String passWord, int roleId, String role, String power,
			int powerId) {
		super();
		this.adminInt = adminInt;
		this.adminName = adminName;
		this.passWord = passWord;
		this.roleId = roleId;
		this.role = role;
		this.power = power;
		this.powerId = powerId;
	}
	public int getAdminInt() {
		return adminInt;
	}
	public void setAdminInt(int adminInt) {
		this.adminInt = adminInt;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public int getPowerId() {
		return powerId;
	}
	public void setPowerId(int powerId) {
		this.powerId = powerId;
	} 
	
}
