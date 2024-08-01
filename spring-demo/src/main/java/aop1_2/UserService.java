package aop1_2;

import aop1_2.entity.User;

/**
 * @author wenxiangmin
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2024年05月18日 18:47:00
 */
public interface UserService {
	User createUser(String name);

	public User getUser();
}
