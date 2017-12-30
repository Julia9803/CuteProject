package network.accountRemoteHelper;

import java.rmi.Remote;

import dataService.accountDataService.AccountDataService;

public class AccountDataServiceHelper {
	private AccountDataService accountDataService ;
	
	private static AccountDataServiceHelper accountRemoteHelper = new AccountDataServiceHelper();
	public static AccountDataServiceHelper getInstance(){
		return accountRemoteHelper;
	}
	
	private AccountDataServiceHelper(){
	}
	
	public void setRemote(Remote remote){
		accountDataService = (AccountDataService)remote;
	}
	
	public AccountDataService getAccountDataService(){
		return accountDataService;
	}
	
}
