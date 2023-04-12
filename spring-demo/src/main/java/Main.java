import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author xmwenk
 * @Description 一句话描述
 */
public class Main {
    public static void main(String[] args) {
        propertyInject();
    }

    /**
     * setter方法注入
     */
    private static void propertyInject() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition rootBeanDefinition = new RootBeanDefinition(XxxService.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name","bbbbbbbbb"));
        rootBeanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("xxxService",rootBeanDefinition);
        XxxService xxxService = (XxxService)beanFactory.getBean("xxxService");
        System.out.println(xxxService.getName());
    }

    /**
     * 构造器注入
     */
    private static void constructorInject() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition rootBeanDefinition = new RootBeanDefinition(XxxService.class);
        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0,"aaaaaaaaaa");
        rootBeanDefinition.setConstructorArgumentValues(constructorArgumentValues);

        beanFactory.registerBeanDefinition("xxxService",rootBeanDefinition);
        XxxService xxxService = (XxxService)beanFactory.getBean("xxxService");
        System.out.println(xxxService.getName());
    }
}
