package txconfig_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import txconfig_1.Account;
import txconfig_1.dao.AccountDao;

import java.util.List;

@Service
public class AccountService {
	@Autowired
    private AccountDao accountDao;
	@Autowired
	private PlatformTransactionManager transactionManager;

    public List<Account> findAllAccounts() {
        return accountDao.findAll();
    }

    public Account findAccountById(int accountId) {
        return accountDao.findById(accountId);
    }

    public void saveAccount(Account account) {
		accountDao.save(account);
		if (true) {
			throw new RuntimeException("发生了异常");
		}
	}

    @TransactionalEventListener
    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    @Transactional
    public void deleteAccount(int accountId) {
        accountDao.delete(accountId);
    }
}
