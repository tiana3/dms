package com.dms.service;

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
	public List<WorkHour> getWorkHour(WorkHour workhour) {
		return work.getWorkHour(workhour);
	}

	@Override
	public Integer addWorkHour(WorkHour workhour) {
		return work.addWorkHour(workhour);
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
	public WorkHour getWorkHourById(int workplaceId) {
		return work.getWorkHourById(workplaceId);
		// TODO Auto-generated method stub
		
	}

}
