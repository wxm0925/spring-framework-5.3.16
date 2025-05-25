package aop.step1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wenxiangmin
 * @ClassName ProxyFactoryBeanDemo.java
 * @createTime 2025年05月24日 21:23:00
 */
public class ProxyFactoryBeanDemo {
	/**
	 * ProxyFactoryBean是一个FactoryBean的实现，getBean返回的是getObject返回的对象
	 * 要注意底层在createBean之后、设置到一级缓存对象之后，还有一行如下代码
	 * getObjectForBeanInstance(sharedInstance, name, beanName, mbd)
	 * getObject就是在这里调用并返回的
	 *
	 */
	@Test
	public void testSimpleServiceProxy(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop/step1/config.xml");
		ISimpleService proxy = (ISimpleService) ctx.getBean("proxy");
		proxy.doSomething();

	}
}
