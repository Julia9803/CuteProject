package bl.accountbl;

import java.rmi.RemoteException;

import PO.account.AccountPO;
import dataService.accountDataService.AccountDataService;
import network.accountRemoteHelper.AccountDataServiceHelper;

public class AccountBalanceChangeServiceImpl implements AccountBalanceChangeService{

	AccountDataService dataService = AccountDataServiceHelper.getInstance().getDataService();
	
	@Override
	public boolean reduce(String accountName, double amount) {
		try {
			AccountPO po = dataService.get(accountName);
			if(po.getBalance() < amount)
				return false;
			po.setBalance(po.getBalance() - amount);
			dataService.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean increase(String accountName, double amount) {
		try {
			AccountPO po = dataService.get(accountName);
			po.setBalance(po.getBalance() + amount);
			dataService.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean checkSufficiency(String accountName, double amount) {
		try {
			AccountPO po = dataService.get(accountName);
			if(po.getBalance() < amount)
				return false;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
