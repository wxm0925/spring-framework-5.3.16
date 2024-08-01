package eventdemo;

/**
 * @author wenxiangmin
 * @ClassName SimpleMethodInvokeListener.java
 * @Description TODO
 * @createTime 2024年05月11日 22:20:00
 */
public class SimpleMethodInvokeListener implements MethodInvokeListener{
	@Override
	public void onMethodBegin(MethodInvokeEvent evt) {
		String methodName = evt.getMethodName();
		System.out.println("onMethodBegin methodName= " + methodName);
	}

	@Override
	public void onMethodEnd(MethodInvokeEvent evt) {
		String methodName = evt.getMethodName();
		System.out.println("onMethodBegin methodName= " + methodName);
	}
}
