package com.dms.service.impl;

import java.util.List;

import com.dms.dao.WorkHourDao;
import com.dms.dao.impl.WorkHourDaoImpl;
import com.dms.entity.WorkHour;

public class WorkHourService implements WorkHourDao{
	WorkHourDaoImpl work= new WorkHourDaoImpl();
	@Override
	public List<WorkHour> getWorkHour() {
		return work.getWorkHour();
	}

	@Override
	public List<WorkHour> getWorkHour(String workplaceName) {
		return work.getWorkHour(workplaceName);
	}

	@Override
	public void removeWorkHour(int workplaceId) {
		work.removeWorkHour(workplaceId);
	}

	@Override
	public void updateWorkHour(WorkHour workhour) {
		work.updateWorkHour(workhour);
	}

	@Override
	public Integer addWorkHour(WorkHour workhour) {
		// TODO Auto-generated method stub
		return work.addWorkHour(workhour);
	}

	@Override
	public WorkHour getWorkHourById(int workplaceId) {
		// TODO Auto-generated method stub
		return null;
	}
}
