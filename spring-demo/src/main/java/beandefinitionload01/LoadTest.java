package beandefinitionload01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demo class
 *
 * @author xmwenk
 * @date 2024/8/5
 */
public class LoadTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beandefinitionload01/spring-beandefinitionload01.xml");
		OrderService bean = applicationContext.getBean(OrderService.class);
		bean.saveOrder();
	}
}
