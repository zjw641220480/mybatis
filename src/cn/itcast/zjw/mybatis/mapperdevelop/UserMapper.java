package cn.itcast.zjw.mybatis.mapperdevelop;

import java.util.List;
import java.util.Map;

import cn.itcast.zjw.mybatis.domain.User;
import cn.itcast.zjw.mybatis.domain.UserCustomer;
import cn.itcast.zjw.mybatis.domain.UserQueryVo;

/**
 * ClassName: UserMapper 
 * @Description: mapper����ʽ�Ŀ���,������mapper������,�൱��dao�ӿ�;
 * @author Tom
 * @date 2015-12-26
 */
public interface UserMapper {
	//����id�����û�;
	public User findUserById(int id) throws Exception;
	//�����û���ģ�������û�
	public List<User> findUserByName(String name) throws Exception;
	//�����û�
	public void insertUser(User user) throws Exception;
	//ɾ���û�
	public void deleteUser(int id) throws Exception;
	//�����û�
	public void updateUser(User user) throws Exception;
	
	
	//�û���Ϣ���ۺϲ�ѯ;
	public List<UserCustomer> findUserList(UserQueryVo userQueryVo) throws Exception;
	//�������Ϊmap;
	public List<UserCustomer> findUserListMap(Map<String,String> params) throws Exception;
	//�û���Ϣ�ۺϲ�ѯ������,�Ա���з�ҳ
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	//����resultMap���н����ӳ��
	public User findUserByIdResultMap(int id) throws Exception;
}
