package tx01.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import tx01.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDao {
    private final JdbcTemplate jdbcTemplate;

    public AccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> findAll() {
        return jdbcTemplate.query("SELECT * FROM t_account", new AccountRowMapper());
    }

    public Account findById(int accountId) {
        return jdbcTemplate.queryForObject("SELECT * FROM t_account WHERE account_id = ?", new Object[]{accountId}, new AccountRowMapper());
    }

    public int save(Account account) {
        return jdbcTemplate.update("INSERT INTO t_account (user_id, account_balance) VALUES (?, ?)",
                account.getUserId(), account.getAccountBalance());
    }

    public int update(Account account) {
        return jdbcTemplate.update("UPDATE t_account SET user_id = ?, account_balance = ? WHERE account_id = ?",
                account.getUserId(), account.getAccountBalance(), account.getAccountId());
    }

    public int delete(int accountId) {
        return jdbcTemplate.update("DELETE FROM t_account WHERE account_id = ?", accountId);
    }

    private static class AccountRowMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setAccountId(rs.getInt("account_id"));
            account.setUserId(rs.getInt("user_id"));
            account.setAccountBalance(rs.getBigDecimal("account_balance"));
            return account;
        }
    }
}
