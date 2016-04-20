package cn.itcast.zjw.mybatis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class PersonJdbc {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	/**
	 * @Description: ʹ�����ӳ�����Jdbc�������ݿ�
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void insert() {
		conn = LianJie.getConnection();
		try {
			conn.setAutoCommit(false);
			String sql = "insert into person(pid,pname) value(14,'�ſ�ΰ')";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, rs, ps);
		}
	}
}
