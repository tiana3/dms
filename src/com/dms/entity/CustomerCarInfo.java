package com.dms.entity;

public class CustomerCarInfo {
		
	private int customerCarInfoId;						//�ͻ�������Ϣid
	private String customerName;						//�ͻ���
	private String gender; 							//�ͻ��Ա�
	private String address;							//�ͻ���ַ
	private String phone; 								//�ֻ���
	private String idCard; 							//�ͻ����֤��
	private String plateNumber;						//���ƺ�
	private String VIN; 								//���ܺ�	
	private String engineNumber;     //���ͻ���
	
	private String color;								//����ɫ
	private String gearBox;							//������
	private String buyDate;							//��������
	private String policyDate;							//��������
	private int modelid; 								//���ͺ�id
	
	public CustomerCarInfo(){}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public CustomerCarInfo(int customerCarInfoId, String customerName, String gender, String address, String phone,
			String idCard, String plateNumber, String vIN, String engineNumber, String color, String gearBox,
			String buyDate, String policyDate, int modelid) {
		super();
		this.customerCarInfoId = customerCarInfoId;
		this.customerName = customerName;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.idCard = idCard;
		this.plateNumber = plateNumber;
		VIN = vIN;
		this.engineNumber = engineNumber;
		this.color = color;
		this.gearBox = gearBox;
		this.buyDate = buyDate;
		this.policyDate = policyDate;
		this.modelid = modelid;
	}



	public int getCustomerCarInfoId() {
		return customerCarInfoId;
	}

	public void setCustomerCarInfoId(int customerCraInfoId) {
		this.customerCarInfoId = customerCraInfoId;
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

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vin) {
		this.VIN = vin;
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

	public String getPolicyDate() {
		return policyDate;
	}

	public void setPolicyDate(String policyDate) {
		this.policyDate = policyDate;
	}

	public int getModelid() {
		return modelid;
	}

	public void setModelid(int modelid) {
		this.modelid = modelid;
	}
	
	
}
