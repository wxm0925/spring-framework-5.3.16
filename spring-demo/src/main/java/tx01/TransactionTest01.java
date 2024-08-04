package tx01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import tx01.service.UserService;

import java.util.List;

/**
 * @author wenxiangmin
 * @ClassName TransactionTest01.java
 * @Description 事务学习
 * @createTime 2024年08月03日 09:05:00
 */
public class TransactionTest01 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tx01/spring-config.xml");
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
