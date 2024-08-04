package txconfig_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import txconfig_1.Account;
import txconfig_1.User;
import txconfig_1.dao.UserDao;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserDao userDao;


	@Autowired
	private AccountService accountService;

	@Override
    public void createUser(User user) {
		userDao.save(user);
		Account account = new Account();
		account.setUserId(user.getId());
		account.setAccountBalance(BigDecimal.TEN);
		try {

		} catch (Exception e) {
			accountService.saveAccount(account);
		}

		user.setName(user.getName()+"保存账户之后更新");
		userDao.update(user);
    }
	@Override
    public void updateUser(User user) {
        userDao.update(user);
    }
	@Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }
	@Override
    public User getUserById(int id) {
        return userDao.findById(id);
    }
	@Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
	@Override
    public List<User> getUsersByName(String name) {
        return userDao.findByName(name);
    }
}
