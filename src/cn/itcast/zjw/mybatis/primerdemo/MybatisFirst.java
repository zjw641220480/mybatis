package cn.itcast.zjw.mybatis.primerdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.zjw.mybatis.domain.Person;
import cn.itcast.zjw.mybatis.domain.User;

/**
 * ClassName: MybatisFirst
 * 
 * @Description: ���ų���,mybatisԭʼdao��ʽ�Ŀ���,�ܶ�����Ķ���,
 * @author Tom
 * @date 2015-12-19
 */
public class MybatisFirst {
	@Test
	// ����id��ѯ�û���Ϣ,�õ�һ����¼���;
	public void findUserByIdTest() {
		// mybatisȫ�������ļ�����Դ·����;
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���;
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// �����Ự����,
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// ͨ�������õ�SqlSession;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ͨ��SqlSeesion�������ݿ�
		// ��һ������:ӳ���ļ�statement��id,����=�����ռ�+statement��id
		// �ڶ�������:ָ����ӳ���ļ�����ƥ���parameterTyper���͵Ĳ���;
		// sqlSession.selectOne�������ӳ���ļ�����ƥ���resultType���͵Ķ���;
		// selectOne��ʾֻ��ѯ����һ�����
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		// �ͷ���Դ;
		sqlSession.close();
	}

	/**
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 * @author Tom
	 * @date 2015-12-26
	 */
	@Test
	public void findUserByNameTest() {

		// mybatis��ȫ�������ļ���ַ;
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���;
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// �����Ự����,
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// ͨ�������õ�SqlSession;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ͨ��SqlSeesion�������ݿ�
		// ��һ������:ӳ���ļ�statement��id,����=�����ռ�+statement��id
		// �ڶ�������:ָ����ӳ���ļ�����ƥ���parameterTyper���͵Ĳ���;
		// sqlSession.selectOne�������ӳ���ļ�����ƥ���resultType���͵Ķ���;
		// list�е�User��ӳ���ļ���resultType��ָ��������һ��;

		 /*����ʹ��#{}ռλ������ģ����ѯ������,�Զ�������µ�����; List<User> list =*/
		List<User> list = sqlSession.selectList("test.findUserByName", "%��%");
		//List<User> list = sqlSession.selectList("test.findUserByName", "��");
		System.out.println(list);
		// �ͷ���Դ;
		sqlSession.close();
	}

	/**
	 * @param
	 * @return void
	 * @throws
	 * @author Tom
	 * @date 2015-12-21
	 */
	@Test
	public void insertUserTest() {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// �����û�����
		User user = new User();
		user.setUsername("zhangzan");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("����֣��");
		sqlSession.insert("test.insetUser", user);
		// ִ���ύ����
		sqlSession.commit();
		// ��ȡ�û���Ϣ������;mapper�����ļ��н�������
		System.out.println(user.getId() + "============");
		sqlSession.close();
	}
	@Test
	public void testInsertUserUUID(){
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person person = new Person();
		//person.setId(UUID.randomUUID().toString());
		person.setAge(13);
		person.setPname("zhangsan");
		sqlSession.insert("test.insertPerson",person);
		//����Ҫcommit�Ϳ��Եõ��������ݵ�UUID��ֵ
		System.out.println(person.getId());
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void deleteUserTest() {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.delete("test.deleteUser", 7);
		// ִ���ύ����
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void updateUserTest() {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ����Ҫ�޸ĵĶ���
		// ��hibernate���,�޸ĵ�ʱ��Ҳ����Ҫ�Ȳ�ѯ�����Ƶ�;
		User user = new User();
		user.setId(1);
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setAddress("����פ���");
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
}
