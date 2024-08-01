package org.springframework.beans;

import org.junit.Test;

/**
 * @author wenxiangmin
 * @ClassName BeanWrapperTest.java
 * @Description TODO
 * @createTime 2024年04月21日 20:48:00
 */
public class BeanWrapperTest {

	public class User {
		private String name;
		private String email;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "User{" +
					"name='" + name + '\'' +
					", email='" + email + '\'' +
					'}';
		}
	}

	@Test
	public void testBasic() {
		User user = new User();
		BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);
		beanWrapper.setPropertyValue("name","zhangsan");
		beanWrapper.setPropertyValue("email","xmwen1100@gmail.com");
		System.out.println(user);
	}
}
