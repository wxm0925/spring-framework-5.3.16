package myaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author wenxiangmin
 * @ClassName UserServiceAspect.java
 * @Description TODO
 * @createTime 2024年05月24日 22:24:00
 */
@Aspect
@Component
public class UserServiceAspect {

	@Pointcut("execution(* myaop.IUserService.saveUser(..))")
	public void saveUserPointCut(){}


	@Before("saveUserPointCut()")
	public void beforeInvoke() {
		System.out.println("before invoke....");
	}
}
