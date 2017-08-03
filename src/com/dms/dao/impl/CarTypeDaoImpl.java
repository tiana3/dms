package com.dms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.dms.dao.CarTypeDao;
import com.dms.entity.CarType;
import com.dms.util.JdbcUtil;

public class CarTypeDaoImpl implements CarTypeDao {
	/*≤‚ ‘”√
	 * 
	 * public static void main(String[] args) {
		CarTypeDaoImpl c = new CarTypeDaoImpl();
		c.removeCarType(2);
		c.removeCarType(3);		
	}*/
	
	public List<CarType> getAllCarType() {
		List<CarType> list = new ArrayList<CarType>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			prepareStatement = connection.prepareStatement("select * from cartype");
			resultSet = prepareStatement.executeQuery();
					
			while(resultSet.next()) {
				int modelId = resultSet.getInt(1);
				String factory = resultSet.getString(2);
				String model = resultSet.getString(3);
				list.add(new CarType(modelId, factory, model));			
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, prepareStatement, resultSet);
		}	
		return list;		
	}

	@Override
	public void addCarType(CarType carType) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;		
		try {
			connection = JdbcUtil.getConnection();
			prepareStatement = connection.prepareStatement("insert into cartype(factory,model) values(?,?)");
			prepareStatement.setString(1, carType.getFactory());
			prepareStatement.setString(2, carType.getModel());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, prepareStatement, null);
		}
	
	}

	@Override
	public void removeCarType(int CarTypeId) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;		
		try {
			connection = JdbcUtil.getConnection();
			prepareStatement = connection.prepareStatement("delete from cartype where modelId = ?");
			prepareStatement.setInt(1, CarTypeId);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, prepareStatement, null);
		}
	}

	@Override
	public void updateCarType(CarType carType) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtil.getConnection();
			prepareStatement = connection.prepareStatement("update cartype set factory= ?,model = ? where modelId = ?");
			prepareStatement.setString(1, carType.getFactory());
			prepareStatement.setString(2, carType.getModel());
			prepareStatement.setInt(3, carType.getModelId());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, prepareStatement, null);
		}
	}

}
