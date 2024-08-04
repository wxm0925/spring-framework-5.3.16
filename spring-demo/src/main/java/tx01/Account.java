package tx01;

import java.math.BigDecimal;

public class Account {
    private int accountId;
    private int userId;
    private BigDecimal accountBalance;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountId=" + accountId +
				", userId=" + userId +
				", accountBalance=" + accountBalance +
				'}';
	}
}
