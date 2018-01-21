package blservice.serviceFactory;

import bl.accountbl.AccountManagementServiceImpl;
import bl.accountbl.CashExpenseListImpl;
import bl.accountbl.CollectionListImpl;
import bl.accountbl.PaymentListImpl;
import blservice.accountblservice.AccountManagementService;
import blservice.accountblservice.FinanceListService;
import network.accountRemoteHelper.CashExpenseListDataServiceHelper;
import network.accountRemoteHelper.CollectionListDataServiceHelper;
import network.accountRemoteHelper.PaymentListDataServiceHelper;

public class AccountBLFactory {
	
	public static FinanceListService getCollectionListService(){
		return new CollectionListImpl(CollectionListDataServiceHelper.getInstance().getDataService());
	}
	
	public static FinanceListService getPaymentListService(){
		return new PaymentListImpl(PaymentListDataServiceHelper.getInstance().getDataService());
	}
	
	public static FinanceListService getCashExpenseListService(){
		return new CashExpenseListImpl(CashExpenseListDataServiceHelper.getInstance().getDataService());
	}
	
	public static AccountManagementService getAccountManagementService(){
		return new AccountManagementServiceImpl();
	}
}
