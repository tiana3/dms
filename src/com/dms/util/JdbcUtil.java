package com.dms.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private static String url = null; //不同数据库，或者连接不同的数据库url不一样
	private static String user = null;//账户名可能也不一样
	private static String password = null;//密码也可能不一样
	private static String driverClass = null;//不同的数据库，这个驱动类名不一样
	
	//静态代码块，只在类加载时，执行一次
	static {
		//我一些可能会变的信息放在在Properties配置文件里，以后直接从配置文件读取数据
		//如信息需要改变，直接该配置文件就行了   
		//配置文件就在src下写，会自动保存到
		//在java项目下，会保存到bin目录下
		//在web项目下，会保存到目录从WEB-INF/classes目录下
		
		//创建properties对象
		try {
			Properties properties = new Properties();
			
			/*
			 * 使用类路径的读取方式
			 *  / : 斜杠表示classpath的根目录
			 *     在java项目下，classpath的根目录从bin目录开始
			 *     在web项目下，classpath的根目录从WEB-INF/classes目录开始
			 *     
			 *     记住这样写就行！！ 还没理解
			 */
			//获取到  连接properties的输入流
			InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");
			
			//把properties里的文件数据加载到  properties对象里
			properties.load(in);
			//读取信息
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			driverClass = properties.getProperty("driverClass");
			
			//加载驱动类，并注册添加到了DriverManager里了
			Class.forName(driverClass);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动程序注册出错");
		}
	}
	
	//获取连接对象的方法
	public static Connection getConnection(){
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//关闭资源的方法
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				try {
					if(statement != null) {
						statement.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);				
				} finally {
					try {
						if(connection != null) {
							connection.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException(e);	
					}
				}
			}
		
	}
	
	
}
