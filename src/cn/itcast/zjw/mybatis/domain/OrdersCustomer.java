package cn.itcast.zjw.mybatis.domain;

/**
 * ClassName: OrdersCustomer 
 * @Description: ��������չ��;��ʾһ��һ��ѯ.
 * @author Tom
 * @date 2015-12-24
 */
//ͨ��������ӳ�䶩�����û���ѯ�Ľ��;�ô���ȥ�̳н϶��pojo
public class OrdersCustomer extends Orders{
	//����û�������
	private String username;
	private String sex;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrdersCustomer [username=" + username + ", sex=" + sex
				+ ", address=" + address + "]";
	}
}
