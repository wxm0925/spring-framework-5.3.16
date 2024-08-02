package aop1X;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 方法参数打印通知
 *
 * @author xmwenk
 * @date 2024/8/2
 */
public class MethodArgsPrintAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("方法名称:" + method.getName() + " -- 参数:" + args);
	}
}
