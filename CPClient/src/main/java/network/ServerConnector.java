package network;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import PO.account.CollectionListPO;
import network.VIPRemoteHelper.VIPDataServiceHelper;
import network.accountRemoteHelper.CollectionListDataServiceHelper;
import network.goodsRemoteHelper.GoodsDataServiceHelper;
import network.presentRemoteHelper.PresentForMembershipDataServiceHelper;
import network.presentRemoteHelper.PresentForSpecialPackageDataServiceHelper;
import network.presentRemoteHelper.PresentForSumDataServiceHelper;

import network.saleRemoteHelper.SaleListDataServiceHelper;
import network.saleRemoteHelper.SaleProjectionDataServiceHelper;
import network.saleRemoteHelper.SaleReturnListDataServiceHelper;
import network.saleRemoteHelper.StockListDataServiceHelper;
import network.saleRemoteHelper.StockReturnListDataServiceHelper;

import util.State;

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
//		dataServiceHelpers.add(StoreDataServiceHelper.getInstance());
//		dataServiceHelpers.add(PaymentListDataServiceHelper.getInstance());
		
		
		dataServiceHelpers.add(CollectionListDataServiceHelper.getInstance());
//		dataServiceHelpers.add(PaymentListDataServiceHelper.getInstance());
//		dataServiceHelpers.add(CashExpenseListDataServiceHelper.getInstance());
		
		
		dataServiceHelpers.add(PresentForMembershipDataServiceHelper.getInstance());
		dataServiceHelpers.add(PresentForSpecialPackageDataServiceHelper.getInstance());
		dataServiceHelpers.add(PresentForSumDataServiceHelper.getInstance());
		
		
		dataServiceHelpers.add(GoodsDataServiceHelper.getInstance());
		dataServiceHelpers.add(VIPDataServiceHelper.getInstance());
//		dataServiceHelpers.add(StockReturnListDataServiceHelper.getInstance());
//		dataServiceHelpers.add(StockListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleListDataServiceHelper.getInstance());
//		dataServiceHelpers.add(SaleReturnListDataServiceHelper.getInstance());
		dataServiceHelpers.add(SaleProjectionDataServiceHelper.getInstance());

		
		//哈哈，巧妙的设计了一番，每个helper只需在这里add一下就行了
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
		
//		System.setSecurityManager(new SecurityManager()); 		//TODO 这句有什么用吗？我这里没有这句是正常的 re： debug时加的，没用就删了吧
		
	}
	
	public static void main(String [] args){
		new ServerConnector();
//		testCollectionService();
	}
	
	
	//TODO delete it when bl finish!
	public static void testCollectionService(){
		CollectionListPO po = new CollectionListPO();
		po.setId("SKD-20171229-00002");
		po.setState(State.IsCommitted);
		po.setTotalAmount(20);
		try {
//			System.out.println(CollectionListDataServiceHelper.getInstance().getDataService().getNewListId());
			System.out.println(CollectionListDataServiceHelper.getInstance().getDataService().insert(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
