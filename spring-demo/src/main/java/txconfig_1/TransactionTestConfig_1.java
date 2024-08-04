package txconfig_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import txconfig_1.service.IUserService;

import java.util.List;

/**
 * @author wenxiangmin
 * @ClassName TransactionTest01.java
 * @Description 事务学习
 * @createTime 2024年08月03日 09:05:00
 */
public class TransactionTestConfig_1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("txconfig_1/spring-config.xml");
		System.out.println(context.isActive());
		IUserService bean = (IUserService)context.getBean("userService");
		List<User> allUsers = bean.getAllUsers();
		for (User allUser : allUsers) {
			System.out.println(allUser);
		}

//		User user = new User();
//		user.setId(43);
//		user.setName("hahaha43");
//		bean.createUser(user);
	}
}
