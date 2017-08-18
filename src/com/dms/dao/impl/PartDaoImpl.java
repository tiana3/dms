package com.dms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dms.dao.PartDao;
import com.dms.entity.Part;
import com.dms.util.JdbcUtil;

public class PartDaoImpl implements PartDao {
	
	 
	

	@Override
	public Integer addPart(Part part) {
		// TODO Auto-generated method stub		
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement patm = null ;
		String sql = "insert into part (partName,partNo,buyingPrice,sellingPrice,modelId) values(?,?,?,?,?)";
		try {
			patm=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			patm.setString(1, part.getPartName());
			patm.setString(2,part.getPartNo());
			patm.setDouble(3, part.getBuyingPrice());
			patm.setDouble(4, part.getSellingPrice());
			patm.setInt(5, part.getModelId());
			int partId = patm.executeUpdate();
			return partId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(patm != null ){
				try {
					patm.close();
					JdbcUtil.close(conn, patm, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void delPart(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtil.getConnection() ;
		PreparedStatement patm = null;
		String sql = "delete from part where partId = ? ;";
		try {
			patm = conn.prepareStatement(sql) ;
			patm.setInt(1, id);
			patm.executeUpdate();
			System.out.println(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(patm != null){
				try {
					patm.close();
					JdbcUtil.close(conn, patm, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updatePart(Part part) {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement patm = null ;
		String sql = " update part inner join cartype on part.modelId = cartype.modelId set part."
				+ "partName=?, part.partNo=?,part.buyingPrice=?,part.sellingPrice=?,"
				+ "part.modelId=? where part.partId=?";
		
		try {
			patm = conn.prepareStatement(sql) ;
			patm.setString(1, part.getPartName());
			patm.setString(2, part.getPartNo());
			patm.setDouble(3, part.getBuyingPrice());
			patm.setDouble(4, part.getSellingPrice());
			patm.setInt(5, part.getModelId());
			patm.setInt(6, part.getPartId());
			patm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(patm != null){
				 try {
					patm.close();
					JdbcUtil.close(conn, patm, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Part> getPart(Part part) {
		// TODO Auto-generated method stub
		List<Part> list =new ArrayList<Part>();
		Connection conn = JdbcUtil.getConnection() ;
		ResultSet rs = null ;
		PreparedStatement patm = null ;
		String sql = null;
		if(part.getModelId()==0) {
			sql ="select part.partName,part.partNo,part.buyingPrice,part.sellingPrice,cartype.model, "
					+ "part.partId from part left join cartype on part.modelId=cartype.modelId where 1=1 and part.partName like concat('%',?,'%')"
					+ "and part.partNo like concat('%',?,'%')";	
		} else {
			sql ="select part.partName,part.partNo,part.buyingPrice,part.sellingPrice,cartype.model, "
				+ "part.partId from part left join cartype on part.modelId=cartype.modelId where 1=1 and part.partName like concat('%',?,'%')"
				+ "and part.partNo like concat('%',?,'%') and part.modelId =?";	
		}
		
		try {
			patm =conn.prepareStatement(sql);
			patm.setString(1, part.getPartName());
			patm.setString(2, part.getPartNo());
			if (part.getModelId()!=0) {
				patm.setInt(3, part.getModelId());
			}
			rs = patm.executeQuery();
			while(rs.next()){
				Part resultpart = new Part();
				resultpart.setPartName(rs.getString(1));
				resultpart.setPartNo(rs.getString(2));
				resultpart.setBuyingPrice(rs.getDouble(3));
				resultpart.setSellingPrice(rs.getDouble(4));
				resultpart.setModel(rs.getString(5));
				resultpart.setPartId(rs.getInt(6));
				list.add(resultpart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
					JdbcUtil.close(conn, patm, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}





	@Override
	public Part getPartById(Integer partId) {
		Connection connection =  null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtil.getConnection();
			prepareStatement = connection.prepareStatement("select * from part where partId = ?");
			prepareStatement.setInt(1, partId);
			ResultSet result = prepareStatement.executeQuery();
			
			if(result.next()) {
				Part part = new Part();
				part.setPartId(result.getInt("partId"));
				part.setPartName(result.getString("partName"));
				part.setPartNo(result.getString("partNo"));
				part.setBuyingPrice(result.getDouble("buyingPrice"));
				part.setSellingPrice(result.getDouble("sellingPrice"));
				part.setModelId(result.getInt("modelId"));
				
				return part;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, prepareStatement, resultSet);
		}
		
		
		return null;
	}


}
