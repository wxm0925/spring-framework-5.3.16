package aop.step1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Before method: " + invocation.getMethod().getName());
        Object ret = invocation.proceed();
        System.out.println("After method: " + invocation.getMethod().getName());
        return ret;
    }
}
