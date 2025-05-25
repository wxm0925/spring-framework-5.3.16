package ioc;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Objects;

/**
 * @author wenxiangmin
 * @ClassName BeanfactoryTest.java
 * @createTime 2025年05月24日 18:40:00
 */
public class BeanfactoryTest {

	private DefaultListableBeanFactory dlb = new DefaultListableBeanFactory();

	/**
	 * 简单的bean创建，跟着这个debug，创建bean其实很简单
	 */
	@Test
	public void testSimpleBean() {
		//元数据
		RootBeanDefinition rbd = new RootBeanDefinition();
		rbd.setBeanClass(TestBeanA.class);
		//注册元数据
		dlb.registerBeanDefinition("testBean", rbd);

		TestBeanA testBean = dlb.getBean("testBean", TestBeanA.class);
		Assertions.assertTrue("hello".equals(testBean.value));
	}

	/**
	 * 测试自动注入，下面这种方式相当于xml的自动注入，
	 * 自动注入的入口在AbstractAutowireCapableBeanFactory#populateBean方法，获取resolvedAutowireMode的时候
	 * 底层会调用DefaultListableBeanfactory#resolveDependency
	 * @see AbstractAutowireCapableBeanFactory#populateBean
	 * @see DefaultListableBeanFactory#resolveDependency
	 */
	@Test
	public void testAutowired_byXml() {
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
		rootBeanDefinition.setBeanClass(TestBeanB.class);
		rootBeanDefinition.setAutowireMode(2);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.add("value","989");
		rootBeanDefinition.setPropertyValues(propertyValues);
		dlb.registerBeanDefinition("testBeanB", rootBeanDefinition);

		RootBeanDefinition beanDefinition2 = new RootBeanDefinition();
		beanDefinition2.setBeanClass(TestBeanA.class);
		dlb.registerBeanDefinition("testBeanA", beanDefinition2);

		TestBeanB testBeanB = dlb.getBean("testBeanB", TestBeanB.class);
		Assertions.assertTrue("989".equals(testBeanB.value));
		Assertions.assertTrue(Objects.nonNull(testBeanB.testBeanA));
	}

	/**
	 * 通过注解的方式注入依赖
	 * 需要注册一个手动AutowiredAnnotationBeanPostProcessor的bean处理器
	 * 入口也是在AbstractAutowireCapableBeanFactory#populateBean方法
	 * 核心：InstantiationAwareBeanPostProcessor接口的postProcessProperties方法
	 * 底层也会调用DefaultListableBeanfactory#resolveDependency
	 * <code>
	 *      		for (InstantiationAwareBeanPostProcessor bp : getBeanPostProcessorCache().instantiationAware) {
	 * 				 //@Autowired自动注入的地方
	 * 				PropertyValues pvsToUse = bp.postProcessProperties(pvs, bw.getWrappedInstance(), beanName);
	 * 				if (pvsToUse == null) {
	 * 					if (filteredPds == null) {
	 * 						filteredPds = filterPropertyDescriptorsForDependencyCheck(bw, mbd.allowCaching);
	 *                                        }
	 * 					pvsToUse = bp.postProcessPropertyValues(pvs, filteredPds, bw.getWrappedInstance(), beanName);
	 * 					if (pvsToUse == null) {
	 * 						return;
	 *                    }* 				}
	 * 				pvs = pvsToUse;
	 * 			}
	 * </code>
	 * 	@see AbstractAutowireCapableBeanFactory#populateBean
	 * 	@see DefaultListableBeanFactory#resolveDependency
	 */
	@Test
	public void testAutowired_byAnnotation() {
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
		rootBeanDefinition.setBeanClass(TestBeanC.class);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.add("value","989");
		rootBeanDefinition.setPropertyValues(propertyValues);
		dlb.registerBeanDefinition("testBeanB", rootBeanDefinition);

		RootBeanDefinition beanDefinition2 = new RootBeanDefinition();
		beanDefinition2.setBeanClass(TestBeanA.class);
		dlb.registerBeanDefinition("testBeanA", beanDefinition2);

		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor =
				new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(dlb);
		dlb.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

		TestBeanC testBeanC = dlb.getBean("testBeanB", TestBeanC.class);
		Assertions.assertTrue("989".equals(testBeanC.value));
		Assertions.assertTrue(Objects.nonNull(testBeanC.testBeanA));
	}

	/**
	 * pojo
	 */
	public static class TestBeanA{
		public TestBeanA(){}
		public String value = "hello";
	}

	/**
	 * pojo
	 */
	public static class TestBeanB{
		public TestBeanB(){}
		public String value = "hello TestBeanB";
		public TestBeanA testBeanA;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public TestBeanA getTestBeanA() {
			return testBeanA;
		}

		public void setTestBeanA(TestBeanA testBeanA) {
			this.testBeanA = testBeanA;
		}
	}

	public static class TestBeanC{
		public TestBeanC(){}
		public String value = "hello TestBeanB";
		@Autowired
		public TestBeanA testBeanA;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public TestBeanA getTestBeanA() {
			return testBeanA;
		}

		public void setTestBeanA(TestBeanA testBeanA) {
			this.testBeanA = testBeanA;
		}
	}
}
