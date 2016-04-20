package cn.itcast.zjw.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class StandartJdbc {
	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultSet = null;

	/**
	 * @Description: ���׼��JDBC�������ݿ��ʵ��;
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void insert() throws Exception {
		//A:��������
		Class.forName("com.mysql.jdbc.Driver");
		//B:��ȡ����
		String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8";
		connection = DriverManager.getConnection(url, "root", "123456");
		try {
			//����Ϊ�ֶ��ύ����
			connection.setAutoCommit(false);
			//C:���statement
			Statement statement = connection.createStatement();
			String sql = "insert into person(id,pname) value(122,'�ſ�ΰ')";
			//D:����SQL���;
			statement.executeUpdate(sql);
			System.out.println("�޸ĳɹ���");
			//�ֶ��ύ����
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			//E:�ر�����;
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
