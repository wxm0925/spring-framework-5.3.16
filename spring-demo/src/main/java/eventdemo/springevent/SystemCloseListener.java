package eventdemo.springevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author wenxiangmin
 * @ClassName SystemCloseListener.java
 * @Description TODO
 * @createTime 2024年05月12日 12:01:00
 */
public class SystemCloseListener implements ApplicationListener<SystemCloseEvent> {

	@Override
	public void onApplicationEvent(SystemCloseEvent event) {
		System.out.println("数据采集收集开始...event=" + event);
	}
}
