package aop1X;

import java.util.Random;

/**
 * Demo class
 *
 * @author xmwenk
 * @date 2024/8/2
 */
public class UserServiceImpl implements UserService{
	@Override
	public String getUsers() {
		return "user" + new Random().nextInt();
	}
}
