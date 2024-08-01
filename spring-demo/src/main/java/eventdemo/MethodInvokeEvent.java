package eventdemo;

import java.util.EventObject;

/**
 * @author wenxiangmin
 * @ClassName MethodInvokeEvent.java
 * @Description TODO
 * @createTime 2024年05月11日 22:05:00
 */
public class MethodInvokeEvent extends EventObject {
	private String methodName;

	public MethodInvokeEvent(Object source) {
		super(source);
	}

	public MethodInvokeEvent(Object source, String methodName) {
		super(source);
		this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
}
