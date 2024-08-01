package aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wenxiangmin
 * @ClassName App.java
 * @Description TODO
 * @createTime 2024年05月18日 18:30:00
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
		MyService myService = (MyService)context.getBean("myService");
		myService.save();
	}
}
