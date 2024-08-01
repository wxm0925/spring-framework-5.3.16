package jdbcdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author wenxiangmin
 * @ClassName DefaultDSAspect.java
 * @Description TODO
 * @createTime 2024年05月26日 21:50:00
 */
@Aspect
@Component
public class DefaultDSAspect {
	private static final Log logger = LogFactory.getLog(DefaultDSAspect.class);

	@Pointcut("execution(* jdbcdemo.*.*(..))")
	public void defaultPonitCut() {}

	@Before("defaultPonitCut()")
	public void before(JoinPoint joinPoint) {
		logger.trace("执行了");

		// 获取目标类和方法
		Object target = joinPoint.getTarget();
		String methodName = joinPoint.getSignature().getName();
		Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();

		try {
			Method method = target.getClass().getMethod(methodName, parameterTypes);
			if (method.isAnnotationPresent(DS.class)) {
				DS dsAnnotation = method.getAnnotation(DS.class);
				String value = dsAnnotation.value();
				LookupKeyHolder.set(value);
				logger.trace("数据源切换到: " + value);
			}
		} catch (NoSuchMethodException e) {
			logger.error("方法不存在: " + methodName, e);
		}
	}
}
