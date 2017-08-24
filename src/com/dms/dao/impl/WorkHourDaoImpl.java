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
	
	public static void main(String[] args) {
		WorkHourDaoImpl s = new WorkHourDaoImpl();
		System.out.println(s.getWorkHour());
	}
	
	@Override
	public List<WorkHour> getWorkHour() {
		List<WorkHour> list = new ArrayList<WorkHour>();
		String sql = "select * from workplace";
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql);
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
		List<WorkHour> list = new ArrayList<WorkHour>();
		String sql = "SELECT * FROM workplace WHERE workplaceName LIKE concat('%',?,'%')";
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, workplaceName);
			res = pre.executeQuery();
			while(res.next()) {
				int workplaceId = res.getInt(1);
				String workplacename = res.getString(2);
				double workhour = res.getDouble(3);
				double workpay = res.getDouble(4);
				list.add(new WorkHour(workplaceId, workplacename, workhour, workpay));
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
	public Integer addWorkHour(WorkHour workhour) {
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
		String sql = "UPDATE workplace SET workplaceName=?, workhour=?, workpay=? WHERE workplaceId=?";
		try {
			con = JdbcUtil.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, workhour.getWorkplaceName());
			pre.setDouble(2, workhour.getWorkhour());
			pre.setDouble(3, workhour.getWorkpay());
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