package cyclereference;

/**
 * Demo class
 *
 * @author xmwenk
 * @date 2024/8/5
 */
public class OrderService {
	private String username;
	private UserService userService;

	public OrderService() {
	}

	public OrderService(UserService userService) {
		this.userService = userService;
	}

	public void saveOrder() {
		System.out.println("save success");
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
