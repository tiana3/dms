package com.dms.dao;

import java.util.List;

import com.dms.entity.CarType;
import com.dms.entity.CustomerCarInfo;
import com.dms.entity.Employee;
import com.dms.entity.Orders;
import com.dms.entity.Part;
import com.dms.entity.WorkHour;

	
public interface CustomerCarInfoDao {
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
	
	//配件操作
	public void addPart(Part part);	 								//添加材料
	public void delPart(int id); 									//删除材料
	public void updatePart(Part part);								//修改材料
	public List<Part> getPart(String keyword,int modelId);			//根据配件号和配件名、车型查询材料

	//员工的操作
	List<Employee> getEmployee(String name);
	List<Employee> getAllEmployee();
	void addEmployee(Employee employee);
	void removeEmployee(int EmployeeId);
	void updateEmployee(Employee employee);
	
	//车辆型号的 操作
	List<CarType> getAllCarType();
	void addCarType(CarType carType);
	void removeCarType(int CarTypeId);
	void updateCarType(CarType carType);
	
	//订单 的 操作
	List<Orders> getAllOrders();
	List<Orders> getOrders(String plateNumber, String employeeName, int repairId);
	void addOrder(Orders order);
	void updateOrder(Orders order);	
}
