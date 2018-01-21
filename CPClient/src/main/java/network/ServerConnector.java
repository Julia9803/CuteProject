package network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import network.VIPRemoteHelper.VIPDataServiceHelper;
import network.accountRemoteHelper.AccountDataServiceHelper;
import network.accountRemoteHelper.CashExpenseListDataServiceHelper;
import network.accountRemoteHelper.CollectionListDataServiceHelper;
import network.accountRemoteHelper.PaymentListDataServiceHelper;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import network.listRemoteHelper.ListDataServiceHelper;
import network.presentRemoteHelper.PresentForMembershipDataServiceHelper;
import network.presentRemoteHelper.PresentForSpecialPackageDataServiceHelper;
import network.presentRemoteHelper.PresentForSumDataServiceHelper;
import network.saleRemoteHelper.SaleListDataServiceHelper;
import network.saleRemoteHelper.SaleProjectionDataServiceHelper;
import network.saleRemoteHelper.SaleReturnListDataServiceHelper;
import network.saleRemoteHelper.StockListDataServiceHelper;
import network.saleRemoteHelper.StockReturnListDataServiceHelper;
import network.storeRemoteHelper.StoreDataServiceHelper;
import network.userRemoteHelper.MessageDataServiceHelper;
import network.userRemoteHelper.UserDataServiceHelper;

/**
 * 连接服务器的类，在这里将每个DataService与对应的RemoteHelper进行连接
 * 
 *
 */
public class ServerConnector {
	String url = "rmi://localhost:1099/";
	
	List<DataServiceHelper> dataServiceHelpers = new ArrayList<DataServiceHelper>();
	
	public ServerConnector(){
		addServices();
		connectDataService();
	}
	
	private void addServices(){
		dataServiceHelpers.add(StoreDataServiceHelper.getInstance());
		dataServiceHelpers.add(ListDataServiceHelper.getInstance());
		
		
		dataServiceHelpers.add(AccountDataServiceHelper.getInstance());
		dataServiceHelpers.add(CollectionListDataServiceHelper.getInstance());
		dataServiceHelpers.add(PaymentListDataServiceHelper.getInstance());
		dataServiceHelpers.add(CashExpenseListDataServiceHelper.getInstance());
		
		
		dataServiceHelpers.add(UserDataServiceHelper.getInstance());
		dataServiceHelpers.add(MessageDataServiceHelper.getInstance());
		
		
		dataServiceHelpers.add(PresentForMembershipDataServiceHelper.getInstance());
		dataServiceHelpers.add(PresentForSpecialPackageDataServiceHelper.getInstance());
		dataServiceHelpers.add(PresentForSumDataServiceHelper.getInstance());

		
		dataServiceHelpers.add(GoodsDataServiceHelper.getInstance());
		dataServiceHelpers.add(VIPDataServiceHelper.getInstance());
		
		
		dataServiceHelpers.add(StockReturnListDataServiceHelper.getInstance());
		dataServiceHelpers.add(StockListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleReturnListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleProjectionDataServiceHelper.getInstance());

		
	}
	
	 
	private void connectDataService(){
		
		for(DataServiceHelper helper : dataServiceHelpers){
			String serviceName = helper.getServiceName();
			
			try {
				helper.setRemote(Naming.lookup(url+serviceName));
				System.out.println(serviceName + " connected");
			} catch (MalformedURLException e) {
				System.out.println(serviceName + " connect Failed");
				e.printStackTrace();
			} catch (RemoteException e) {
				System.out.println(serviceName + " connect Failed");
				e.printStackTrace();
			} catch (NotBoundException e) {
				System.out.println(serviceName + " connect Failed");
				e.printStackTrace();
			}
			
		}
			
	}
	
	public static void main(String [] args){
		new ServerConnector();
	}
	
}
