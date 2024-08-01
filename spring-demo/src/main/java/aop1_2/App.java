package aop1_2;

import aop1_2.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wenxiangmin
 * @ClassName App.java
 * @Description TODO
 * @createTime 2024年05月18日 19:01:00
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springaop1_2.xml");

		UserService userService2 = (UserService)context.getBean("userService");
		User user2 = userService2.createUser("张三");
		userService2.getUser();

		OrderService bean = context.getBean(OrderService.class);
		bean.createOrder("22");
	}
}
