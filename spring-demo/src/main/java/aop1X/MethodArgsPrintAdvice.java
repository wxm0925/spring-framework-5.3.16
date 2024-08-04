package aop1X;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 方法参数打印通知
 *
 * @author xmwenk
 * @date 2024/8/2
 */
public class MethodArgsPrintAdvice implements MethodBeforeAdvice {
	Log logger = LogFactory.getLog(MethodArgsPrintAdvice.class);
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.debug("方法名称:" + method.getName() + " -- 参数:" + Arrays.asList(args));
	}
}
