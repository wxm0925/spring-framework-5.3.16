package aop;

import aop1_2.entity.User;

/**
 * @author wenxiangmin
 * @ClassName Order.java
 * @Description TODO
 * @createTime 2024年05月18日 18:58:00
 */
public class Order {
	private String orderNo;
	private User user;
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
