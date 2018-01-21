package blservice.serviceFactory;

import bl.accountbl.CashExpenseListImpl;
import bl.accountbl.CollectionListImpl;
import bl.accountbl.PaymentListImpl;
import bl.listbl.Approvable;
import network.accountRemoteHelper.CashExpenseListDataServiceHelper;
import network.accountRemoteHelper.CollectionListDataServiceHelper;
import network.accountRemoteHelper.PaymentListDataServiceHelper;

public class FinanceListApproveFactory {
	public static Approvable getCollectionApprovableService(){
		return new CollectionListImpl(CollectionListDataServiceHelper.getInstance().getDataService());
	}
	
	public static Approvable getPaymentApprovableService(){
		return new PaymentListImpl(PaymentListDataServiceHelper.getInstance().getDataService());
	}
	
	public static Approvable getCashExpenseApprovableService(){
		return new CashExpenseListImpl(CashExpenseListDataServiceHelper.getInstance().getDataService());
	}
}
