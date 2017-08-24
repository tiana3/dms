package com.dms.dao;

import java.util.List;

import com.dms.entity.WorkHour;

public interface WorkHourDao {
	//工时工位操作
	List<WorkHour> getWorkHour();	//查询所有工时工位
	List<WorkHour> getWorkHour(String workplaceName); //根据工位名查询获取工位项目
	Integer addWorkHour(WorkHour workhour);     //添加工位
	void removeWorkHour(int workplaceId); //根据工位id删除工位
	void updateWorkHour(WorkHour workhour); //修改工位
	WorkHour getWorkHourById(int workplaceId);
}
