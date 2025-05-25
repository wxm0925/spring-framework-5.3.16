package org.springframework.beans.factory.support;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

/**
 * @author wenxiangmin
 * @ClassName MyDefaultListableBeanFactory.java
 * @Description TODO
 * @createTime 2025年05月23日 22:40:00
 */
public class MyDefaultListableBeanFactory extends DefaultListableBeanFactory{
	public static void main(String[] args) {
		MyDefaultListableBeanFactory dlb = new MyDefaultListableBeanFactory();
//		TestBean bean = dlb.createBean(TestBean.class);
//		System.out.println(bean.value);

		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
		rootBeanDefinition.setBeanClass(TestBean.class);
		//rootBeanDefinition.setAutowireMode(2);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.add("value","989");
		rootBeanDefinition.setPropertyValues(propertyValues);
		dlb.registerBeanDefinition("test", rootBeanDefinition);

		RootBeanDefinition beanDefinition2 = new RootBeanDefinition();
		beanDefinition2.setBeanClass(TestBean2.class);
		dlb.registerBeanDefinition("testBean2", beanDefinition2);

		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor =
				new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(dlb);
		dlb.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);

		TestBean test = dlb.getBean("test", TestBean.class);
		System.out.println(test.value);
		System.out.println(test.testBean2);

	}

	public static class TestBean{
		public String value = "123";
		@Autowired
		public TestBean2 testBean2;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public TestBean2 getTestBean2() {
			return testBean2;
		}

		public void setTestBean2(TestBean2 testBean2) {
			this.testBean2 = testBean2;
		}
	}

	public static class TestBean2{
		public String value2 = "456";

		public String getValue2() {
			return value2;
		}

		public void setValue2(String value2) {
			this.value2 = value2;
		}
	}

//	@Override
//	protected Object doCreateBean(String beanName, RootBeanDefinition mbd, Object[] args) throws BeanCreationException {
//		TestBean testBean = new TestBean();
//		testBean.value = "32133";
//		return testBean;
//	}



}
