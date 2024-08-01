package eventdemo.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author wenxiangmin
 * @ClassName DataCollectionEvent.java
 * @Description TODO
 * @createTime 2024年05月12日 11:59:00
 */
public class SystemCloseEvent extends ApplicationEvent {
	private String describe;

	/**
	 * 事件源
	 * @param source
	 */
	public SystemCloseEvent(Object source) {
		super(source);
	}

	public SystemCloseEvent(Object source, String describe) {
		super(source);
		this.describe = describe;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "SystemCloseEvent{" +
				"describe='" + describe + '\'' +
				'}';
	}
}
