package com.dms.entity;

public class CustomerCarInfo {
		
	private int customerCraInfo ;						//客户车辆信息
	private String customerName ;						//客户名
	private String gender ; 							//客户性别
	private String address ;							//客户地址
	private String phone ; 								//手机号
	private String idCard ; 							//客户身份证号
	private String plateNumber ;						//车牌号
	private String vin ; 								//车架号	
	private String color ;								//车颜色
	private String gearBox ;							//变速箱
	private String buyDate ;							//购买日期
	private String poilcyDate ;							//保险日期
	private int modelid ; 								//车型号id
	
	public CustomerCarInfo(){}

	public CustomerCarInfo(int customerCraInfo, String customerName, String gender, String address, String phone,
			String idCard, String plateNumber, String vin, String color, String gearBox, String buyDate,
			String poilcyDate, int modelid) {
		super();
		this.customerCraInfo = customerCraInfo;
		this.customerName = customerName;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.idCard = idCard;
		this.plateNumber = plateNumber;
		this.vin = vin;
		this.color = color;
		this.gearBox = gearBox;
		this.buyDate = buyDate;
		this.poilcyDate = poilcyDate;
		this.modelid = modelid;
	}

	public int getCustomerCraInfo() {
		return customerCraInfo;
	}

	public void setCustomerCraInfo(int customerCraInfo) {
		this.customerCraInfo = customerCraInfo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGearBox() {
		return gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public String getPoilcyDate() {
		return poilcyDate;
	}

	public void setPoilcyDate(String poilcyDate) {
		this.poilcyDate = poilcyDate;
	}

	public int getModelid() {
		return modelid;
	}

	public void setModelid(int modelid) {
		this.modelid = modelid;
	}
	
	
}
