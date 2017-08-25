package com.dms.entity;
//员工，部门，职位  实体类
public class Employee {
	private int employeeId;
	private String employeeName;
	private String gender;
	private String phone;
	private String idCard;
	private int departmentId;
	private String departmentName;
	private int jobId;
	private String jobName;
	
	
	
	public Employee() {
		super();
	}
	public Employee(int employeeId, String employeeName, String gender, String phone, String idCard, int departmentId,
			String departmentName, int jobId, String jobName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.gender = gender;
		this.phone = phone;
		this.idCard = idCard;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.jobId = jobId;
		this.jobName = jobName;
	}
	
	public Employee(int jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
	
}
