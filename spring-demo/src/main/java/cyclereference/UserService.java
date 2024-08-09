package cyclereference;

/**
 * Demo class
 *
 * @author xmwenk
 * @date 2024/8/9
 */
public class UserService {
	private OrderService orderService;

	void createUser() {}

	public UserService() {
	}

	public UserService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}
