package aop1_2;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author wenxiangmin
 * @ClassName LogArgAdcive.java
 * @Description TODO
 * @createTime 2024年05月18日 18:48:00
 */
public class LogArgAdcive implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("args is " + args);
	}
}
