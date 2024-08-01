package jdbcdemo;

import jdbcdemo.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wenxiangmin
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2024年05月26日 21:26:00
 */
public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		IUserDao userDao = context.getBean(IUserDao.class);
		List<User> allUser = userDao.getAllUser();
		System.out.println(allUser);
		List<User> slaveAllUser = userDao.getSlaveAllUser();
		System.out.println(slaveAllUser);
	}
}
