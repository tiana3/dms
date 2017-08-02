package com.dms.dao;

import java.util.List;

import com.dms.entity.WorkHour;

public interface WorkHourDao {
	//工时工位操作
	List<WorkHour> getWorkHour(String workplaceName, int modelId); //根据工位名和车型查询获取工位项目
	void addWorkHour(WorkHour workhour);     //添加工位
	void removeWorkHour(int workplaceId); //根据工位id删除工位
	void updateWorkHour(WorkHour workhour); //修改工位

}
