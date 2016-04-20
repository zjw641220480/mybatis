package cn.itcast.zjw.mybatis.mapperdevelop;

import java.util.List;

import cn.itcast.zjw.mybatis.domain.Orders;
import cn.itcast.zjw.mybatis.domain.OrdersCustomer;
import cn.itcast.zjw.mybatis.domain.User;

/**
 * ClassName: OrdersMapperCustomer
 * 
 * @Description: ������mapper.java,�߼�ӳ�������,һ��һ,һ�Զ�,��Զ�,�Լ��ӳټ���
 * @author Tom
 * @date 2015-12-24
 */
public interface OrdersMapperCustomer {
	// ��ѯ����,������ѯ�û�,ʹ��resultType����ӳ��(һ��һ��ResultType��ʽӳ��);
	public List<OrdersCustomer> findOrdersUserResultType() throws Exception;

	// ��ѯ����,������ѯ�û�,ʹ��resultMap����ӳ��(һ��һ��ResultMap��ʽӳ��);
	public List<Orders> findOrdersUserResultMap() throws Exception;

	// ��ѯ����(�����û�)��������ϸ(һ�Զ��ResultMap��ʽӳ��),
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

	// ��ѯ�û�������Ʒ��Ϣ(��Զ�����м�����ӳ��);
	public List<User> findUserAndItemsResultMap() throws Exception;

	// ��ѯ����������ѯ�û�,�û���Ϣ���ӳټ��ص�
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
