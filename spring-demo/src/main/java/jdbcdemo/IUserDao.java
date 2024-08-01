package jdbcdemo;

import jdbcdemo.entity.User;

import java.util.List;

/**
 * @author wenxiangmin
 * @ClassName IUserDao.java
 * @Description TODO
 * @createTime 2024年05月26日 21:19:00
 */
public interface IUserDao {
	List<User> getAllUser();
	List<User> getSlaveAllUser();
}
