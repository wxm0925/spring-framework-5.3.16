package eventdemo;

import java.util.EventListener;

/**
 * @author wenxiangmin
 * @ClassName MethodInvokeListener.java
 * @Description TODO
 * @createTime 2024年05月11日 22:12:00
 */
public interface MethodInvokeListener extends EventListener {
	void onMethodBegin(MethodInvokeEvent evt);

	void onMethodEnd(MethodInvokeEvent evt);
}
