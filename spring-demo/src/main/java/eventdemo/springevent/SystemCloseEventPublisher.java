package eventdemo.springevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.EventObject;

/**
 * @author wenxiangmin
 * @ClassName SystemCloseEventPublisher.java
 * @Description TODO
 * @createTime 2024年05月12日 12:03:00
 */
public class SystemCloseEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher eventPublisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}

	public void publishEvent(EventObject enent) {
		this.eventPublisher.publishEvent(enent);
	}
}
