package aop1_2.impl;

import aop1_2.UserService;
import aop1_2.entity.User;

/**
 * @author wenxiangmin
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2024年05月18日 18:47:00
 */
public class UserServiceImpl implements UserService {
	private User user;

	@Override
	public User createUser(String name) {
		User user = new User();
		user.setName(name);
		this.user = user;
		return user;
	}

	@Override
	public User getUser() {
		return this.user;
	}


}
