package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;

import PO.account.CollectionListPO;
import dataHelper.serviceFactory.BasicUtilServiceFactory;
import dataService.accountDataService.CollectionListDataService;

public class CollectionListDataServiceImpl extends FinanceListDataServiceImpl implements CollectionListDataService{

	private static final long serialVersionUID = 2025751205261887468L;

	public CollectionListDataServiceImpl() throws RemoteException{
		super();
		basicUtil = BasicUtilServiceFactory.getService(CollectionListPO.class);
		
	}
	
	@Override
	public String getNewListId()  throws RemoteException{
		return basicUtil.getNewListId("SKD", new CollectionListPO());
		
	}
	

}
