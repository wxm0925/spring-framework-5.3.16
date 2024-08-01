package eventdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenxiangmin
 * @ClassName MethodInvokeEventPublisher.java
 * @Description TODO
 * @createTime 2024年05月11日 22:21:00
 */
public class MethodInvokeEventPublisher {
	private List<MethodInvokeListener> listeners = new ArrayList();

	public void methodToMonitor() {
		MethodInvokeEvent event = new MethodInvokeEvent(this, "methodToMonitor");

		publishEvent("begin", event);
		System.out.println("执行业务逻辑");
		publishEvent("end", event);
	}

	protected void publishEvent(String status, MethodInvokeEvent evt) {
		List<MethodInvokeListener> copyListeners = new ArrayList(listeners);
		for (MethodInvokeListener listener : listeners) {
			if ("begin".equals(status)) {
				listener.onMethodBegin(evt);
			} else {
				listener.onMethodEnd(evt);
			}
		}
	}

	public void addMethodInvokeEventListener(MethodInvokeListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(MethodInvokeListener listener) {
		this.listeners.remove(listener);
	}

	public void removeAllListener() {
		this.listeners.clear();
	}

	public static void main(String[] args) {
		MethodInvokeEventPublisher publisher = new MethodInvokeEventPublisher();
		publisher.addMethodInvokeEventListener(new SimpleMethodInvokeListener());
		publisher.methodToMonitor();
	}
}
