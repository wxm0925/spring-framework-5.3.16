package myaop;

import org.springframework.stereotype.Service;

/**
 * @author wenxiangmin
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2024年05月24日 22:23:00
 */
@Service
public class UserServiceImpl implements IUserService{
	@Override
	public void saveUser() {
		System.out.println("save user ......");
	}
}
