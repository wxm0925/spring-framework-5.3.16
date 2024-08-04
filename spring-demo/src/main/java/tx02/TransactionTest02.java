package tx02;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import tx02.service.UserService;

import java.util.List;

/**
 * @author wenxiangmin
 * @ClassName TransactionTest01.java
 * @Description 事务学习
 * @createTime 2024年08月03日 09:05:00
 */
public class TransactionTest02 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tx02/spring-config.xml");
		System.out.println(context.isActive());
		UserService bean = context.getBean(UserService.class);
		List<User> allUsers = bean.getAllUsers();
		for (User allUser : allUsers) {
			System.out.println(allUser);
		}

		User user = new User();
		user.setId(42);
		user.setName("hahaha42");
		bean.createUser(user);
	}
}
