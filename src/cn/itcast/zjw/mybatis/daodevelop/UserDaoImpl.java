package cn.itcast.zjw.mybatis.daodevelop;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.zjw.mybatis.domain.User;

/**
 * ClassName: UserDaoImpl 
 * @Description: Dao�ӿ�ʵ����,ԭʼdao����mybatis
 * @author Tom
 * @date 2015-12-21
 */
public class UserDaoImpl implements UserDao{
	//��Ҫ��daoʵ����ע��SqlSessionFactory
	//����ͨ�����캯��ע��
	private SqlSessionFactory sqlSessionFactory = null;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();		
	}
	
}
