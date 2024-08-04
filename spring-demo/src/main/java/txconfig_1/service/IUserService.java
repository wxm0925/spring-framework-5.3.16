package txconfig_1.service;

import txconfig_1.User;

import java.util.List;

/**
 * @author wenxiangmin
 * @ClassName IUserService.java
 * @Description TODO
 * @createTime 2024年08月04日 17:40:00
 */
public interface IUserService {
	public void createUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public User getUserById(int id);

	public List<User> getAllUsers();

	public List<User> getUsersByName(String name);
}
