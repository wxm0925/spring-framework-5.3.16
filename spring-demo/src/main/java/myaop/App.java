package myaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wenxiangmin
 * @ClassName App.java
 * @Description TODO
 * @createTime 2024年04月21日 18:17:00
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		XxxService bean = context.getBean(XxxService.class);
		System.out.println(bean);

		IUserService bean1 = context.getBean(IUserService.class);
		bean1.saveUser();
	}
}
