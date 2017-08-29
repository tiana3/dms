
package com.dms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.CustomerCarInfo;

	
public interface CustomerCarInfoDao {
	//�ͻ�������Ϣ����

    CustomerCarInfo getCustomerCarInfoByKey(@Param("plateNumber")String plateNumber, @Param("VIN")String VIN); //���ݳ��ƻ��߳��ܺţ���ѯ��ȡ�ͻ�������Ϣ
	void addCustomerCarInfo(CustomerCarInfo info);  //��ӿͻ�������Ϣ
	void removeCustomerCarInfo(int customerCarInfoId);//����idɾ����Ϣ
	void updateCustomerCarInfo(CustomerCarInfo info);//�޸Ŀͻ�������Ϣ				
	List<CustomerCarInfo> getCustomerCarInfoByWordKey(@Param("plateNumber")String plateNumber,@Param("VIN")String VIN,@Param("customerName")String customerName,@Param("phone")String phone);
	CustomerCarInfo getCustomerCarInfoById(int customerCarInfoIdid );  //����id ��ѯ����             
}
