package network.accountRemoteHelper;

import java.rmi.Remote;

import dataService.accountDataService.AccountDataService;
import network.DataServiceHelper;

public class AccountDataServiceHelper implements DataServiceHelper{
	private AccountDataService accountDataService ;
	private static final String serviceName = "AccountDataService";
	
	private static AccountDataServiceHelper accountRemoteHelper = new AccountDataServiceHelper();
	public static AccountDataServiceHelper getInstance(){
		return accountRemoteHelper;
	}
	
	private AccountDataServiceHelper(){
	}
	
	@Override
	public void setRemote(Remote remote){
		accountDataService = (AccountDataService)remote;
	}
	
	public AccountDataService getDataService(){
		return accountDataService;
	}

	@Override
	public String getServiceName() {
		return serviceName;
	}
	
}
