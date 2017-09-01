package com.dms.entity;

public class PartOut {
private String orderid;                       //������id
private String platenumber;                //���ƺ�
private String vin;                        //���ݺ�
private Integer repairtypeid;                  //ά������id
private String repairtype;               //ά������
private String name;                       //�������
private Integer partid;                     //����id
private String partname;                    //����
private Integer employeeid;                  //Ա��id
private String picker;                       //����Ա��
private double buyingPrice;                 //����
private double sellingPrice;                 //�ۼ�
public PartOut(String orderid, String platenumber, String vin, Integer repairtypeid, String repairtype, String name,
		Integer partid, String partname, Integer employeeid, String picker) {
	super();
	this.orderid = orderid;
	this.platenumber = platenumber;
	this.vin = vin;
	this.repairtypeid = repairtypeid;
	this.repairtype = repairtype;
	this.name = name;
	this.partid = partid;
	this.partname = partname;
	this.employeeid = employeeid;
	this.picker = picker;
}

public PartOut(Integer repairtypeid, String repairtype) {
	super();
	this.repairtypeid = repairtypeid;
	this.repairtype = repairtype;
}

public PartOut() {
	super();
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public String getPlatenumber() {
	return platenumber;
}
public void setPlatenumber(String platenumber) {
	this.platenumber = platenumber;
}
public String getVin() {
	return vin;
}
public void setVin(String vin) {
	this.vin = vin;
}
public Integer getRepairtypeid() {
	return repairtypeid;
}
public void setRepairtypeid(Integer repairtypeid) {
	this.repairtypeid = repairtypeid;
}
public String getRepairtype() {
	return repairtype;
}
public void setRepairtype(String repairtype) {
	this.repairtype = repairtype;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getPartid() {
	return partid;
}
public void setPartid(Integer partid) {
	this.partid = partid;
}
public String getPartname() {
	return partname;
}
public void setPartname(String partname) {
	this.partname = partname;
}
public Integer getEmployeeid() {
	return employeeid;
}
public void setEmployeeid(Integer employeeid) {
	this.employeeid = employeeid;
}
public String getPicker() {
	return picker;
}
public void setPicker(String picker) {
	this.picker = picker;
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

@Override
public String toString() {
	return "PartOut [orderid=" + orderid + ", platenumber=" + platenumber + ", vin=" + vin + ", repairtypeid="
			+ repairtypeid + ", repairtype=" + repairtype + ", name=" + name + ", partid=" + partid + ", partname="
			+ partname + ", employeeid=" + employeeid + ", picker=" + picker + "]";
}

}
