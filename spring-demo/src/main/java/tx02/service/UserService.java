package tx02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import tx02.Account;
import tx02.User;
import tx02.dao.UserDao;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Autowired
	private AccountService accountService;

	@Transactional(rollbackFor = {Exception.class})
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

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(int id) {
        userDao.delete(id);
    }

    public User getUserById(int id) {
        return userDao.findById(id);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public List<User> getUsersByName(String name) {
        return userDao.findByName(name);
    }
}
