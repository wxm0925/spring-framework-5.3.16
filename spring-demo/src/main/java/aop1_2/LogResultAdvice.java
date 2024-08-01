package aop1_2;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author wenxiangmin
 * @ClassName LogResultAdvice.java
 * @Description TODO
 * @createTime 2024年05月18日 18:49:00
 */
public class LogResultAdvice implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("target is "+target+"  and  method name is "+method.getName()+" and  result is " + returnValue);
	}
}
