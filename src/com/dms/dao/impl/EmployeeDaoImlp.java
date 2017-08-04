package com.dms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dms.entity.Employee;
import com.dms.util.JdbcUtil;


public class EmployeeDaoImlp {
	public static void main(String[] args) {
		System.out.println(getAllEmployee());
	}
	public static void addEmployee(Employee employee){
		Connection conn = JdbcUtil.getConnection();
		String sql = "insert into employee set employeeId='" + employee.getEmployeeId() + "',name='" + 
				employee.getEmployeeName() + "',gender='" + employee.getGender() + "',phone='" + 
				employee.getPhone() + "',idCard='" + employee.getIdCard() + "',jobId='" + employee.getJobId() + "'";
		PreparedStatement statment;
		try {
			statment = conn.prepareStatement(sql);
			statment.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateEmployee(Employee employee){
		Connection conn = JdbcUtil.getConnection();
		String sql = "UPDATE job,employee,department SET job.`NAME`='"
				+ employee.getJobName() + "',department.`name`='"
						+ employee.getDepartmentName() + "',employee.`name`='"
								+ employee.getEmployeeName() + "',employee.`gender`='"
										+ employee.getGender() + "',employee.`phone`='"
												+ employee.getPhone() + "',employee.`idCard`='"
														+ employee.getIdCard() + "' WHERE job.`jobId` ='"
										+ employee.getJobId() + "' AND department.`departmentId`='"
												+ employee.getDepartmentId() + "' AND employee.`employeeId`='"
														+ employee.getEmployeeId() + "'";
				
		PreparedStatement statment;
		try {
			statment = conn.prepareStatement(sql);
			statment.executeUpdate(sql);
			statment.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void removeEmployee(int EmployeeId){
		Connection conn = JdbcUtil.getConnection();
		String sql = "delete from employee where employeeId='"+EmployeeId+"'";
		PreparedStatement statment;
		try {
			statment = conn.prepareStatement(sql);
			statment.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  ArrayList<Employee> getAllEmployee(){
		Connection conn = JdbcUtil.getConnection();
		String sql = "SELECT employee.`employeeId`,employee.`name`,employee.`gender`,employee.`phone`,employee.`idCard`,department.`departmentId`,department.`name`,job.`jobId`,job.`NAME` FROM employee,job,department  WHERE employee.jobId = job.jobId AND job.departmentId = department.departmentId ";	
		PreparedStatement statment;
		ArrayList<Employee> employees = new ArrayList<Employee>(); 
		try {
			statment = conn.prepareStatement(sql);
			ResultSet rs = statment.executeQuery();
			while(rs.next()){
				Employee employee = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9));
		//		System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) +"," +
			//	rs.getString(4));
				employees.add(employee);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	public static  ArrayList<Employee> getEmployee(String name){
		Connection conn = JdbcUtil.getConnection();
		String sql = "SELECT employee.`employeeId`,employee.`name`,employee.`gender`,employee.`phone`,employee.`idCard`,department.`departmentId`,department.`name`,job.`jobId`,job.`NAME` FROM employee,job,department  WHERE employee.jobId = job.jobId AND job.departmentId = department.departmentId "
				+ "AND employee.name = '" + name +"'";	
		PreparedStatement statment;
		ArrayList<Employee> employees = new ArrayList<Employee>(); 
		try {
			statment = conn.prepareStatement(sql);
			ResultSet rs = statment.executeQuery();
			while(rs.next()){
				Employee employee = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9));
		//		System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) +"," +
			//	rs.getString(4));
				employees.add(employee);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
}
