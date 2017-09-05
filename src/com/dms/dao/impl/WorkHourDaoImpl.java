package com.dms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dms.dao.WorkHourDao;
import com.dms.entity.WorkHour;
import com.dms.util.JdbcUtil;

public class WorkHourDaoImpl implements WorkHourDao{
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	
	public static void main(String[] args) {
		WorkHourDaoImpl s = new WorkHourDaoImpl();
		System.out.println(s.getWorkHour());
	}
	
	@Override
	public List<WorkHour> getWorkHour() {
		return null;
	}
	
	@Override
	public List<WorkHour> getWorkHour(WorkHour workhour) {
		List<WorkHour> list = new ArrayList<WorkHour>();
		String sql = null;
		if(workhour.getModelId() == 0) {
			sql="select workplace.workplaceId, workplace.workplaceName,workplace.workhour,"
					+ "workplace.workpay,cartype.modelId from "
					+ "workplace left join cartype on workplace.modelId=cartype.modelId "
					+ "where 1=1 and workplace.workplaceName like concat('%',?,'%')";
		}else {
			sql="select workplace.workplaceId, workplace.workplaceName,workplace.workhour,"
					+ "workplace.workpay,cartype.modelId from "
					+ "workplace left join cartype on workplace.modelId=cartype.modelId where 1=1 "
					+ "and workplace.workplaceName like concat('%',?,'%') and workplace.modelId=?";
		}
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, workhour.getWorkplaceName());
			if(workhour.getModelId() !=0) {
				pre.setInt(2, workhour.getModelId());
			}
			res = pre.executeQuery();
			while(res.next()) {
				WorkHour workHour = new WorkHour();
				workHour.setWorkplaceId(res.getInt(1));
				workHour.setWorkplaceName(res.getString(2));
				workHour.setWorkhour(res.getDouble(3));
				workHour.setWorkpay(res.getDouble(4));
				workHour.setModelId(res.getInt(5));

				list.add(workHour);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(res != null) {
			try {
				res.close();
				JdbcUtil.close(con, pre, res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return list;
		
	}

	@Override
	public Integer addWorkHour(WorkHour workhour) {
		String sql = "insert into workplace (workplaceName,workpay,modelId) value(?,?,?)";
		
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pre.setString(1, workhour.getWorkplaceName());
			pre.setDouble(2, workhour.getWorkpay());
			pre.setInt(3, workhour.getModelId());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pre != null){
				try {
					pre.cancel();
					JdbcUtil.close(con,pre,null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return null;
	}

	@Override
	public void removeWorkHour(int workplaceId) {
		String sql = "delete from workplace where workplaceId = ?";
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql);
			pre.setInt(1, workplaceId);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, pre, null);
		}
	}

	@Override
	public void updateWorkHour(WorkHour workhour) {
		String sql = "UPDATE workplace inner join cartype on workplace.modelId = cartype.modelId SET "
				+ "workplace.workplaceName=?, workplace.workpay=?,workplace.modelId=? WHERE workplaceId=?";
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, workhour.getWorkplaceName());
			pre.setDouble(2, workhour.getWorkpay());
			pre.setInt(3, workhour.getModelId());
			pre.setInt(4, workhour.getWorkplaceId());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, pre, null);
		}
	}

	@Override
	public WorkHour getWorkHourById(int workplaceId) {
		
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement("select * from workplace where workplaceId = ?");
			pre.setInt(1, workplaceId);
			res = pre.executeQuery();
			
			while(res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				double workhour = res.getDouble(3);
				double workpay = res.getDouble(4);
				WorkHour work = new WorkHour(id, name, workhour, workpay);
				return work;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, pre, res);
		}
		return null;
	}
	
}