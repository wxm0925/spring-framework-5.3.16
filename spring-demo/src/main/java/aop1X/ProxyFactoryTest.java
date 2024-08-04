package aop1X;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * Demo class
 *
 * @author xmwenk
 * @date 2024/8/2
 */
public class ProxyFactoryTest {
	public static void main(String[] args) {
		UserService target = new UserServiceImpl();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);

		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
		advisor.setMappedName("getUsers");
		MethodArgsPrintAdvice methodArgsPrintAdvice = new MethodArgsPrintAdvice();
		advisor.setAdvice(methodArgsPrintAdvice);
		proxyFactory.addAdvisors(advisor);

		NameMatchMethodPointcutAdvisor advisor2 = new NameMatchMethodPointcutAdvisor();
		advisor2.setMappedName("getUsers");
		InvokeResultPringAdvice invokeResultPringAdvice = new InvokeResultPringAdvice();
		advisor2.setAdvice(invokeResultPringAdvice);
		proxyFactory.addAdvisors(advisor2);

		proxyFactory.setInterfaces(UserService.class);
		UserService userService = (UserService) proxyFactory.getProxy();
		userService.getUsers();
	}
}
