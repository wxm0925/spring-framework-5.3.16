package aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author wenxiangmin
 * @ClassName LogingAdcive.java
 * @Description TODO
 * @createTime 2024年05月18日 18:13:00
 */
public class LogingAdcive extends NameMatchMethodPointcutAdvisor implements Advice {

	public LogingAdcive () {
		setAdvice((methodInvocation) -> {
			System.out.println("loging before");
			Object proceed = methodInvocation.proceed();
			System.out.println("loging before");
			return proceed;
		});

		setMappedName("save");
	}

	public void setAdvice(MethodInterceptor methodInterceptor) {
		super.setAdvice(methodInterceptor);
	}
}
