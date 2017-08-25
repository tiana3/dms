package com.dms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dms.entity.Employee;
import com.dms.entity.Part;
import com.dms.util.JdbcUtil;

public class EmployeeDaoImlp {
	public static void main(String[] args) {
		System.out.println(getAllEmployee());
	}

	public static void addEmployee(Employee employee) {
		Connection conn = JdbcUtil.getConnection();
		String sql = "insert into employee set employee.`name`='" + employee.getEmployeeName() + "',gender='"
				+ employee.getGender() + "',phone='" + employee.getPhone() + "',idCard='" + employee.getIdCard()
				+ "',jobId='" + employee.getJobId() + "'";
		PreparedStatement statment;
		try {
			statment = conn.prepareStatement(sql);
			statment.execute(sql);
			statment.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Employee> getEmployee(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = JdbcUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement patm = null;
		String sql = null;
		
			sql = "select employee.employeeId,employee.name,employee.gender,employee.phone,employee.idCard,job.NAME, "
					+ "department.name from employee left join job on employee.jobId=job.jobId left join department on job.departmentId=department.departmentId where 1=1 and employee.name like concat('%',?,'%')"
					+ "and employee.phone like concat('%',?,'%') and employee.idCard like concat('%',?,'%')";

		try {
			patm = conn.prepareStatement(sql);
			patm.setString(1, employee.getEmployeeName());
			patm.setString(2, employee.getPhone());
			patm.setString(3, employee.getIdCard());
			rs = patm.executeQuery();
			while (rs.next()) {
				Employee resultpart = new Employee();
				resultpart.setEmployeeId(rs.getInt(1));
				resultpart.setEmployeeName(rs.getString(2));
				resultpart.setGender(rs.getString(3));
				resultpart.setPhone(rs.getString(4));
				resultpart.setIdCard(rs.getString(5));
				resultpart.setJobName(rs.getString(6));
				resultpart.setDepartmentName(rs.getString(7));
				list.add(resultpart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
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

	public static void updateEmployee(Employee employee) {
		Connection conn = JdbcUtil.getConnection();
		String sql = "UPDATE employee SET employee.`name`='" + employee.getEmployeeName() + "',employee.`gender`='"
				+ employee.getGender() + "',employee.`phone`='" + employee.getPhone() + "',employee.`idCard`='"
				+ employee.getIdCard() + "',employee.`jobId`='" + employee.getJobId()
				+ "' WHERE employee.`employeeId`='" + employee.getEmployeeId() + "'";

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

	public static void removeEmployee(int EmployeeId) {
		Connection conn = JdbcUtil.getConnection();
		String sql = "delete from employee where employeeId='" + EmployeeId + "'";
		PreparedStatement statment;
		try {
			statment = conn.prepareStatement(sql);
			statment.executeUpdate();
			statment.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Employee> getAllEmployee() {
		Connection conn = JdbcUtil.getConnection();
		String sql = "SELECT employee.`employeeId`,employee.`name`,employee.`gender`,employee.`phone`,employee.`idCard`,department.`departmentId`,department.`name`,job.`jobId`,job.`NAME` FROM employee,job,department  WHERE employee.jobId = job.jobId AND job.departmentId = department.departmentId ";
		PreparedStatement statment;
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			statment = conn.prepareStatement(sql);
			ResultSet rs = statment.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				// System.out.println(rs.getInt(1) + "," + rs.getString(2) + ","
				// + rs.getString(3) +"," +
				// rs.getString(4));
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

	public static ArrayList<Employee> getEmployee(String name) {
		Connection conn = JdbcUtil.getConnection();
		String sql = "SELECT employee.`employeeId`,employee.`name`,employee.`gender`,employee.`phone`,employee.`idCard`,department.`departmentId`,department.`name`,job.`jobId`,job.`NAME` FROM employee,job,department  WHERE employee.jobId = job.jobId AND job.departmentId = department.departmentId "
				+ "AND employee.name = '" + name + "'";
		PreparedStatement statment;
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			statment = conn.prepareStatement(sql);
			ResultSet rs = statment.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				// System.out.println(rs.getInt(1) + "," + rs.getString(2) + ","
				// + rs.getString(3) +"," +
				// rs.getString(4));
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
	public static Employee getEmployeeById(int id) {
		Connection conn = JdbcUtil.getConnection();
		String sql = "SELECT employee.`employeeId`,employee.`name`,employee.`gender`,employee.`phone`,employee.`idCard`,department.`departmentId`,department.`name`,job.`jobId`,job.`NAME` FROM employee,job,department  WHERE employee.jobId = job.jobId AND job.departmentId = department.departmentId "
				+ "AND employee.employeeId = '" + id + "'";
		PreparedStatement statment;
		Employee employee = null;
		try {
			statment = conn.prepareStatement(sql);
			ResultSet rs = statment.executeQuery();
			while (rs.next()) {
				 employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				// System.out.println(rs.getInt(1) + "," + rs.getString(2) + ","
				// + rs.getString(3) +"," +
				// rs.getString(4));
				
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	public static ArrayList<Employee> getJob(){
		Connection conn = JdbcUtil.getConnection();
		String sql = "SELECT * from job";
		PreparedStatement statment;
		ArrayList<Employee>list = new ArrayList<Employee>();
		try {
			statment = conn.prepareStatement(sql);
			ResultSet rs = statment.executeQuery();
			while (rs.next()) {
				 Employee employee = new Employee(rs.getInt(1),rs.getString(2));
				// System.out.println(rs.getInt(1) + "," + rs.getString(2) + ","
				// + rs.getString(3) +"," +
				// rs.getString(4));
				list.add(employee);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
