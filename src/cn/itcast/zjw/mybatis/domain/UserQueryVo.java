package cn.itcast.zjw.mybatis.domain;

import java.util.List;

/**
 * ClassName: UserQueryVo 
 * @Description: �û���װ����,��Ҫ���ڸ߼���ѯ
 * @author Tom
 * @date 2015-12-21
 */
public class UserQueryVo {
	private List<Integer> ids;
	//�������װ����Ҫ�Ĳ�ѯ����
	//�û���ѯ����;
	private UserCustomer userCustomer;
	//���԰�װ������ѯ����,����,��Ʒ;

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

}
