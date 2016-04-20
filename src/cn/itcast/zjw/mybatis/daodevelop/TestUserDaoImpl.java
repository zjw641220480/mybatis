package cn.itcast.zjw.mybatis.daodevelop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.domain.User;

public class TestUserDaoImpl {
	private SqlSessionFactory sqlSessionFactory = null;
	private UserDaoImpl daoImpl = null;
	@Before
	public void beforeTest(){
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���;
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// �����Ự����,
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		daoImpl = new UserDaoImpl(sqlSessionFactory);
	}
	@Test
	public void testFindUserByIdDaoDevelop() throws Exception{
		User user = daoImpl.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void testInsertUserDaoDevelop() throws Exception{
		User user = new User();
		user.setId(1);
		user.setAddress("�Ϻ�");
		user.setBirthday(new Date());
		user.setUsername("����");
		daoImpl.insertUser(user);
	}
}
