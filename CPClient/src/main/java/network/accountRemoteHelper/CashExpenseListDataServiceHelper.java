package network.accountRemoteHelper;

import java.rmi.Remote;

import dataService.accountDataService.CashExpenseListDataService;
import network.DataServiceHelper;

public class CashExpenseListDataServiceHelper implements DataServiceHelper{
	private CashExpenseListDataService cashExpenseListDataService ;
	private static final String serviceName = "CashExpenseListDataService";
	
	private static CashExpenseListDataServiceHelper cashExpenseListRemoteHelper = new CashExpenseListDataServiceHelper();
	public static CashExpenseListDataServiceHelper getInstance(){
		return cashExpenseListRemoteHelper;
	}
	
	private CashExpenseListDataServiceHelper(){
	}
	
	@Override
	public String getServiceName(){
		return serviceName;
	}
	
	@Override
	public void setRemote(Remote remote){
		cashExpenseListDataService = (CashExpenseListDataService)remote;
	}
	
	public CashExpenseListDataService getDataService(){
		return cashExpenseListDataService;
	}
	
}
