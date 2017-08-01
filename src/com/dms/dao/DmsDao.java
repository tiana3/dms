package com.dms.dao;

import com.dms.entity.Part;

import java.util.List;

import com.dms.entity.CustomerCarInfo;
import com.dms.entity.WorkHour;

	
public interface DmsDao {
	public void addPart(Part part);	 								//添加材料
	public void delPart(int id); 									//删除材料
	public void updatePart(Part part);								//修改材料
	public List<Part> getPart(String keyword,int modelId);			//根据配件号和配件名、车型查询材料
	//客户车辆信息操作
	CustomerCarInfo getCustomerCarInfo(String key); //根据车牌或者车架号，查询获取客户车辆信息
	void addCustomerCarInfo(CustomerCarInfo info);  //添加客户车辆信息
	void removeCustomerCarInfo(int customerCarInfoId);//根据id删除信息
	void updateCustomerCarInfo(CustomerCarInfo info);//修改客户车辆信息
	
	//工时工位操作
	List<WorkHour> getWorkHour(String workplaceName, int modelId); //根据工位名和车型查询获取工位项目
	void addWorkHour(WorkHour workhour);     //添加工位
	void removeWorkHour(int workplaceId); //根据工位id删除工位
	void updateWorkHour(WorkHour workhour); //修改工位
	
}
