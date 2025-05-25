package aop.step1;

import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.aop.framework.adapter.DefaultAdvisorAdapterRegistry;

import java.lang.reflect.Method;

/**
 * @author wenxiangmin
 * @ClassName ProxyCreatorSupportDemo.java
 * @createTime 2025年05月25日 10:45:00
 */
public class JdkDynamicAopProxyDemo {
	/**
	 * 使用 Spring 较早期版本的方式，基于 JDK 动态代理实现 AOP。
	 *
	 * 执行流程如下：
	 * 1. 创建代理配置对象（AdvisedSupport），设置目标对象（target）和通知（advice），
	 *    并指定代理接口以启用 JDK 动态代理。
	 *
	 * 2. 当真正调用目标方法时，会进入 JDK 动态代理的调用逻辑：
	 *    由 {@link JdkDynamicAopProxy#invoke} 方法拦截并处理。
	 *
	 * 3. 在 invoke 方法内部：
	 *    3.1 首先通过配置对象（AdvisedSupport）获取该方法对应的拦截器链：
	 *        调用 {@link AdvisedSupport#getInterceptorsAndDynamicInterceptionAdvice}。
	 *    3.2 该方法的底层实现是 {@link DefaultAdvisorChainFactory#getInterceptorsAndDynamicInterceptionAdvice}，
	 *         它会遍历所有 Advisor，并判断其PointCut {@code ClassFilter} 和 {@code MethodMatcher} 是否匹配当前方法：
	 *         - 若匹配成功，则通过 {@link DefaultAdvisorAdapterRegistry} 将 dvice 转换为 MethodInterceptor。
	 *
	 * 4. 拦截器链构造完成后，Spring 会构造 {@link org.springframework.aop.framework.ReflectiveMethodInvocation}，
	 *    并以递归方式调用拦截器链中的各个拦截器，最终执行目标方法。
	 *
	 * 核心类梳理：
	 * - {@link DefaultAopProxyFactory}：创建代理对象的工厂类，是入口类，根据 AdvisedSupport 的配置决定使用 JDK 还是 CGLIB 代理。
	 * - {@link AdvisedSupport}：Spring AOP 的核心配置对象，维护 Advisor 列表、目标对象、接口信息等。
	 *      - Advisor = Pointcut + Advice
	 *      - 在本示例中，虽然只配置了 target + advice，但底层 Spring 会自动构造一个 Advisor，Pointcut 为 {@link org.springframework.aop.support.TruePointcut}。
	 *
	 * @see org.springframework.aop.framework.adapter.DefaultAdvisorAdapterRegistry#getInterceptors
	 */

	@Test
	public void simpleTest() {
		AdvisedSupport advisedSupport = new AdvisedSupport();
		advisedSupport.setTarget(new SimpleService());

		MethodBeforeAdvice methodBeforeAdvice = new MethodBeforeAdvice() {

			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("before .............");
			}
		};
		advisedSupport.addAdvice(methodBeforeAdvice);
		advisedSupport.setInterfaces(ISimpleService.class);
		DefaultAopProxyFactory defaultAopProxyFactory = new DefaultAopProxyFactory();

		AopProxy aopProxy = defaultAopProxyFactory.createAopProxy(advisedSupport);
		ISimpleService proxy = (ISimpleService)aopProxy.getProxy();
		proxy.doSomething();
	}
}
