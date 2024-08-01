package jdbcdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wenxiangmin
 * @ClassName DefaultRoutingDataSource.java
 * @Description TODO
 * @createTime 2024年05月26日 21:41:00
 */
@Component
public class DefaultRoutingDataSource extends AbstractRoutingDataSource implements InitializingBean {
	@Autowired
	@Qualifier("masterDataSource")
	private DataSource master;
	@Autowired
	@Qualifier("slaveDataSource")
	private DataSource slave;




	@Override
	protected Object determineCurrentLookupKey() {
		String s = LookupKeyHolder.get();
		return s;
	}

	@Override
	public void afterPropertiesSet() {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("master", master);
		targetDataSources.put("slave", slave);
		setTargetDataSources(targetDataSources);
		setDefaultTargetDataSource(master); // 设置默认数据源
		super.afterPropertiesSet();
	}
}
