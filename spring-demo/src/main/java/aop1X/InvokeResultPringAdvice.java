package aop1X;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author wenxiangmin
 * @ClassName InvokeResultPringAdvice.java
 * @Description 返回结果打印通知
 * @createTime 2024年08月02日 22:05:00
 */
public class InvokeResultPringAdvice implements AfterReturningAdvice {
	Log logger = LogFactory.getLog(InvokeResultPringAdvice.class);
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		logger.debug("方法参数：" + Arrays.asList(args) + "  target=" + target);
		logger.debug("方法" + method.getName()+"执行结果：" + returnValue);
	}
}
