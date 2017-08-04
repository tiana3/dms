package com.dms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dms.dao.WorkHourDao;
import com.dms.entity.WorkHour;
import com.dms.util.JdbcUtil;

public class WorkHourDaoImpl implements WorkHourDao{
	Connection con = null;
	PreparedStatement pre = null;
	ResultSet res = null;
	
	@Override
	public List<WorkHour> getWorkHour() {
		List<WorkHour> list = new ArrayList<WorkHour>();
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement("select * from workplace");
			res = pre.executeQuery();
			
			while(res.next()) {
				int workplaceId = res.getInt(1);
				String workplaceName = res.getString(2);
				double workhour = res.getDouble(3);
				double workpay = res.getDouble(4);
				list.add(new WorkHour(workplaceId, workplaceName, workhour, workpay));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, pre, res);
		}
		
		return list;
	}
	
	@Override
	public List<WorkHour> getWorkHour(String workplaceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addWorkHour(WorkHour workhour) {
		String sql = "insert into workplace (workplaceName,workhour,workpay) value(?,?,?)";
		
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, workhour.getWorkplaceName());
			pre.setDouble(2, workhour.getWorkhour());
			pre.setDouble(3, workhour.getWorkpay());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con,pre,null);
		}
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
		String sql = "update workplace set workplaceName=?, workhour=?, workpay=? where workplaceId=?";
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, workhour.getWorkplaceName());
			pre.setDouble(2, workhour.getWorkhour());
			pre.setDouble(3, workhour.getWorkpay());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con, pre, null);
		}
	}
}