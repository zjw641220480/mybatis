package cn.itcast.zjw.mybatis.mapperdevelop;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.zjw.mybatis.domain.User;
import cn.itcast.zjw.mybatis.domain.UserCustomer;
import cn.itcast.zjw.mybatis.domain.UserQueryVo;

public class TestUserMapper {
	private SqlSessionFactory sqlSessionFactory = null;
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
	}
	/**
	 * @Description: ��������id����ѯ
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void testFindUserByIdMapperDevelop() throws Exception{
		//����UserMapper����;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
	/**
	 * @Description: ����name��ģ����ѯ
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void testFindUserByNameMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.findUserByName("��");
		System.out.println(list);
	}
	/**
	 * @Description: ���ݰ�װ����QueryVo���ۺϲ�ѯ(�߼���ѯ)
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void testFindUserListMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSex("1");
		userCustomer.setUsername("����");
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}
	
	/**
	 * @Description: ���ݰ�װ����QueryVo���ۺϲ�ѯ(�߼���ѯ),���ﻹʹ���˶�̬sql
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void testFindUserListDynamicSqlMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		//�ں��˶�̬sql�ĸ߼���ѯ,������ĳ��ֵ�Ļ�,��������ƴ����sql��;
		userCustomer.setSex("1");
		//userCustomer.setUsername("����");
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}
	@Test
	public void testFindUserListDynamicSqlForEachMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		//�ں��˶�̬sql�ĸ߼���ѯ,������ĳ��ֵ�Ļ�,��������ƴ����sql��;
		userCustomer.setSex("1");
		//userCustomer.setUsername("����");
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(4);
		//��idsͨ��UserQueryVo����statement��;
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustomer(userCustomer);
		//������sql
		//select * from user WHERE user.sex=? AND ( id=? OR id=? )
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}
	/**
	 * @Description: ����ӳ��ΪMap
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void testFindUserListMapMapperDevelop() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Map<String,String> params = new HashMap<String, String>();
		params.put("name", "����");
		List<UserCustomer> list = userMapper.findUserListMap(params);
		System.out.println(list);
	}
	/**
	 * @Description: ��ѯ���Ϊһ��һ��;
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void testFindUserCount() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSex("1");
		userCustomer.setUsername("����");
		userQueryVo.setUserCustomer(userCustomer);
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
	}
	/**
	 * @Description: ������ʹ��resultMap������ӳ��;
	 * @throws Exception   
	 * @return void  
	 * @throws
	 * @author Tom
	 * @date 2016��4��17��
	 */
	@Test
	public void testFindUserByIdResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByIdResultMap(1);
		System.out.println(user);
	}
}
