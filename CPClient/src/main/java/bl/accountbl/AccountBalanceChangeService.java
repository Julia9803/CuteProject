package bl.accountbl;

public interface AccountBalanceChangeService {
	public boolean reduce(String accountName, double amount);
	public boolean increase(String accountName, double amount);
	public boolean checkSufficiency(String accountName, double amount);	//检查余额是否充足
}
