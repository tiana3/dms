package com.dms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dms.dao.PartDao;
import com.dms.entity.Part;
import com.dms.util.JdbcUtil;

public class PartDaoImpl implements PartDao {
	
	

	@Override
	public void addPart(Part part) {
		// TODO Auto-generated method stub		
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement patm = null ;
		String sql = "insert into part (partName,partNo,buyingPrice,sellingPrice,modelId) values(?,?,?,?,?)";
		try {
			patm=conn.prepareStatement(sql);
			patm.setString(1, part.getPartName());
			patm.setString(2,part.getPartNo());
			patm.setDouble(3, part.getBuyingPrice());
			patm.setDouble(4, part.getSellingPrice());
			patm.setInt(5, part.getModelId());
			patm.executeUpdate();
			
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
	}

	@Override
	public void delPart(int id) {
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
	public List<Part> getPart(String keyword1,String keyword2 ,int modelId) {
		// TODO Auto-generated method stub
		List<Part> list =new ArrayList<Part>();
		Connection conn = JdbcUtil.getConnection() ;
		ResultSet rs = null ;
		PreparedStatement patm = null ;
		String sql ="select part.partName,part.partNo,part.buyingPrice,part.sellingPrice,cartype.model "
				+ "from part left join cartype on part.modelId=cartype.modelId where part.partName=? "
				+ "or part.partNo=? or part.modelId =?";	
		
		try {
			patm =conn.prepareStatement(sql);
			patm.setString(1, "keyword1");
			patm.setString(2, "keyword2");
			patm.setInt(3, modelId);
			rs = patm.executeQuery();
			while(rs.next()){
			Part part = new Part();
			part.setPartName(rs.getString(1));
			part.setPartNo(rs.getString(2));
			part.setBuyingPrice(rs.getDouble(3));
			part.setSellingPrice(rs.getDouble(4));
			part.setModel(rs.getString(5));			
			list.add(part);
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

}
