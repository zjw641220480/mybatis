package cn.itcast.zjw.mybatis.daodevelop;

import cn.itcast.zjw.mybatis.domain.User;

/**
 * ClassName: UserDao 
 * @Description: dao�ӿ�,�û�����,ԭʼdao����mybatis
 * @author Tom
 * @date 2015-12-21
 */
public interface UserDao {
	//����id��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;
	//����û���Ϣ;
	public void insertUser(User user) throws Exception; 
	//ɾ���û���Ϣ
	public void deleteUser(int id) throws Exception;
	
}
