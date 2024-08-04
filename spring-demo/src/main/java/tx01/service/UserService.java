package tx01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import tx01.Account;
import tx01.User;
import tx01.dao.UserDao;

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

    public void createUser(User user) {
		TransactionDefinition def = new DefaultTransactionAttribute();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			userDao.save(user);
			Account account = new Account();
			account.setUserId(user.getId());
			account.setAccountBalance(BigDecimal.TEN);
			accountService.saveAccount(account);
			user.setName(user.getName()+"保存账户之后更新");
			userDao.update(user);
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
		}
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
