package aop1_2.impl;

import aop.Order;
import aop1_2.OrderService;

/**
 * @author wenxiangmin
 * @ClassName OrderServiceImpl.java
 * @Description TODO
 * @createTime 2024年05月18日 18:48:00
 */
public class OrderServiceImpl implements OrderService {
	@Override
	public Order createOrder(String orderNo) {
		Order order = new Order();
		order.setOrderNo(orderNo);
		return order;
	}
}
