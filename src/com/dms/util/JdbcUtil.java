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
	private static String url = null; //��ͬ���ݿ⣬�������Ӳ�ͬ�����ݿ�url��һ��
	private static String user = null;//�˻�������Ҳ��һ��
	private static String password = null;//����Ҳ���ܲ�һ��
	private static String driverClass = null;//��ͬ�����ݿ⣬�������������һ��
	
	//��̬����飬ֻ�������ʱ��ִ��һ��
	static {
		//��һЩ���ܻ�����Ϣ������Properties�����ļ���Ժ�ֱ�Ӵ������ļ���ȡ����
		//����Ϣ��Ҫ�ı䣬ֱ�Ӹ������ļ�������   
		//�����ļ�����src��д�����Զ����浽
		//��java��Ŀ�£��ᱣ�浽binĿ¼��
		//��web��Ŀ�£��ᱣ�浽Ŀ¼��WEB-INF/classesĿ¼��
		
		//����properties����
		try {
			Properties properties = new Properties();
			
			/*
			 * ʹ����·���Ķ�ȡ��ʽ
			 *  / : б�ܱ�ʾclasspath�ĸ�Ŀ¼
			 *     ��java��Ŀ�£�classpath�ĸ�Ŀ¼��binĿ¼��ʼ
			 *     ��web��Ŀ�£�classpath�ĸ�Ŀ¼��WEB-INF/classesĿ¼��ʼ
			 *     
			 *     ��ס����д���У��� ��û���
			 */
			//��ȡ��  ����properties��������
			InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");
			
			//��properties����ļ����ݼ��ص�  properties������
			properties.load(in);
			//��ȡ��Ϣ
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			driverClass = properties.getProperty("driverClass");
			
			//���������࣬��ע����ӵ���DriverManager����
			Class.forName(driverClass);
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������ע�����");
		}
	}
	
	//��ȡ���Ӷ���ķ���
	public static Connection getConnection(){
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//�ر���Դ�ķ���
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
