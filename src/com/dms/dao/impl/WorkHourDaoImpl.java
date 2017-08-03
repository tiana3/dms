package com.dms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dms.dao.WorkHourDao;
import com.dms.entity.WorkHour;

public class WorkHourDaoImpl implements WorkHourDao{

	private Connection con = null;
	private PreparedStatement pre = null;
	private ResultSet res = null;
	
	public WorkHourDaoImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dms?useSSL=false&useUnicode=true&characterCoding=utf-8","root","965200");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		try 
		{
			if(res != null){
				res.close();
			}
			if(pre != null) {
				pre.close();
			}
			if(con != null) {
				con.close();
			}
		}catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<WorkHour> getWorkHour(String workplaceName, int modelId) {
		ArrayList<WorkHour> workhour = new ArrayList<WorkHour>();
		String sql = "select * from dms.workplace";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()) 
			{
				WorkHour woh = new WorkHour();
				woh.setWorkplaceId(res.getInt(1));
				woh.setWorkplaceName(res.getString(2));
				workhour.add(woh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(res != null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return workhour;
	}

	@Override
	public void addWorkHour(WorkHour workhour) {
		String sql = "insert into workplace (workplaceName, workhour, workpay) values (?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, workhour.getWorkplaceName());
			pre.setDouble(2, workhour.getWorkhour());
			pre.setDouble(3, workhour.getWorkpay());
			pre.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeWorkHour(int workplaceId) {
		String sql = "delete from workplace where workplaceId = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, workplaceId);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateWorkHour(WorkHour workhour) {
		String sql = "update workplace set workplaceName=?,workhour=?,workpay=? where workplaceId=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, workhour.getWorkplaceName());
			pre.setDouble(2, workhour.getWorkhour());
			pre.setDouble(3, workhour.getWorkpay());
			pre.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
