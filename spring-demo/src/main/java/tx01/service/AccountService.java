package tx01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import tx01.Account;
import tx01.dao.AccountDao;

import java.util.List;

@Service
public class AccountService {
	@Autowired
    private  AccountDao accountDao;
	@Autowired
	private PlatformTransactionManager transactionManager;

    public List<Account> findAllAccounts() {
        return accountDao.findAll();
    }

    public Account findAccountById(int accountId) {
        return accountDao.findById(accountId);
    }

    public void saveAccount(Account account) {

		TransactionDefinition def = new DefaultTransactionAttribute(3);
		TransactionStatus status = transactionManager.getTransaction(def);
		try{
			accountDao.save(account);
					if (true) {
			throw new RuntimeException("发生了异常");
		}
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
    }

    @Transactional
    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    @Transactional
    public void deleteAccount(int accountId) {
        accountDao.delete(accountId);
    }
}
