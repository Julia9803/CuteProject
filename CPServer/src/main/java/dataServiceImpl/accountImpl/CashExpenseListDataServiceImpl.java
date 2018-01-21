package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;

import PO.account.CashExpenseListPO;
import dataHelper.serviceFactory.BasicUtilServiceFactory;
import dataService.accountDataService.CashExpenseListDataService;

public class CashExpenseListDataServiceImpl extends FinanceListDataServiceImpl implements CashExpenseListDataService{

	
	
	private static final long serialVersionUID = -1881629376042242701L;

	public CashExpenseListDataServiceImpl() throws RemoteException{
		super();
		basicUtil = BasicUtilServiceFactory.getService(CashExpenseListPO.class);
		
	}
	
	@Override
	public String getNewListId()  throws RemoteException{
		return basicUtil.getNewListId("XJFYD", new CashExpenseListPO());
		
	}
	
	
	

}
