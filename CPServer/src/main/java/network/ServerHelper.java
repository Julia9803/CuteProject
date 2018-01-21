package network;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import PO.StoreListID;
import dataHelper.serviceImpl.HibernateUtil_Green;
import dataService.VIPDataService.VIPDataService;
import dataService.accountDataService.AccountDataService;
import dataService.accountDataService.CashExpenseListDataService;
import dataService.accountDataService.CollectionListDataService;
import dataService.accountDataService.PaymentListDataService;
import dataService.goodsDataService.GoodsDataService;
import dataService.listDataService.ListDataService;
import dataService.presentDataService.PresentForMembershipDataService;
import dataService.presentDataService.PresentForSpecialPackageDataService;
import dataService.presentDataService.PresentForSumDataService;
import dataService.saleDataService.SaleListDataService;
import dataService.saleDataService.SaleProjectionDataService;
//import dataService.saleDataService.SaleProjectionDataService;
import dataService.saleDataService.SaleReturnListDataService;
import dataService.saleDataService.StockListDataService;
import dataService.saleDataService.StockReturnListDataService;
import dataService.storeDataService.StoreDataService;
import dataService.userDataService.MessageDataService;
import dataService.userDataService.UserDataService;
import dataServiceImpl.VIPImpl.VIPDataServiceImpl;
import dataServiceImpl.accountImpl.AccountDataServiceImpl;
import dataServiceImpl.accountImpl.CashExpenseListDataServiceImpl;
import dataServiceImpl.accountImpl.CollectionListDataServiceImpl;
import dataServiceImpl.accountImpl.PaymentListDataServiceImpl;
import dataServiceImpl.goodsImpl.GoodsDataServiceImpl;
import dataServiceImpl.listImpl.ListDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForMembershipDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForSpecialPackageDataServiceImpl;
import dataServiceImpl.presentImpl.PresentForSumDataServiceImpl;
import dataServiceImpl.saleImpl.SaleListDataServiceImpl;
import dataServiceImpl.saleImpl.SaleProjectionDataServiceImpl;
//import dataServiceImpl.saleImpl.SaleProjectionDataServiceImpl;
import dataServiceImpl.saleImpl.SaleReturnListDataServiceImpl;
import dataServiceImpl.saleImpl.StockListDataServiceImpl;
import dataServiceImpl.saleImpl.StockReturnListDataServiceImpl;
import dataServiceImpl.storeImpl.StoreDataServiceImpl;
import dataServiceImpl.userImpl.MessageDataServiceImpl;
import dataServiceImpl.userImpl.UserDataServiceImpl;
import util.StoreListType;


public class ServerHelper {
	public int port = 1099;
	
	public ServerHelper(){
		initServer();
		//initListID();
	}
	
	private void initServer(){
		try {
			LocateRegistry.createRegistry(port);
			System.out.println("successful connection");
			

			StoreDataService storeDataService=new StoreDataServiceImpl();
			Naming.bind("StoreDataService", storeDataService);
			System.out.println("库存类数据库绑定成功！");

			ListDataService listDataService=new ListDataServiceImpl();
			Naming.bind("ListDataService",listDataService);
			System.out.println("表单类数据库绑定成功！");
			
			AccountDataService accountDataService = new AccountDataServiceImpl();
			Naming.bind("AccountDataService", accountDataService);
			System.out.println("AccountDataService bind Succeed");
			
			CollectionListDataService collectionListDataService = new CollectionListDataServiceImpl();
			Naming.bind("CollectionListDataService", collectionListDataService);
			System.out.println("CollectionListDataService bind Succeed");
			
			PaymentListDataService paymentListDataService = new PaymentListDataServiceImpl();
			Naming.bind("PaymentListDataService", paymentListDataService);
			System.out.println("PaymentListDataService bind Succeed");

			CashExpenseListDataService cashExpenseListDataService = new CashExpenseListDataServiceImpl();
			Naming.bind("CashExpenseListDataService", cashExpenseListDataService);
			System.out.println("CashExpenseListDataService bind Succeed");
			
			
			UserDataService userDataService = new UserDataServiceImpl();
			Naming.bind("UserDataService", userDataService);
			System.out.println("UserDataService bind Succeed");
			
			MessageDataService messageDataService = new MessageDataServiceImpl();
			Naming.bind("MessageDataService", messageDataService);
			System.out.println("MessageDataService bind Succeed");
			
//			PresentDataService presentDataService=new PresentDataServiceImpl();
//			Naming.bind("PresentDataService", presentDataService);
//			System.out.println("bind succeeded!");
//			
			PresentForSumDataService presentForSumDataService = new PresentForSumDataServiceImpl();
			Naming.bind("PresentForSumDataService", presentForSumDataService);
//	
			PresentForMembershipDataService presentForMembershipDataService = new PresentForMembershipDataServiceImpl();
			Naming.bind("PresentForMembershipDataService", presentForMembershipDataService);
			
			PresentForSpecialPackageDataService presentForSpecialPackageDataService = new PresentForSpecialPackageDataServiceImpl();
			Naming.bind("PresentForSpecialPackageDataService", presentForSpecialPackageDataService);

			SaleListDataService saleListDataService = new SaleListDataServiceImpl();
			Naming.bind("SaleListDataService", saleListDataService);
			
			SaleReturnListDataService saleReturnListDataService = new SaleReturnListDataServiceImpl();
			Naming.bind("SaleReturnListDataService", saleReturnListDataService);
			
			StockListDataService stockListDataService = new StockListDataServiceImpl();
			Naming.bind("StockListDataService", stockListDataService);
			
			StockReturnListDataService stockReturnListDataService  = new StockReturnListDataServiceImpl();
			Naming.bind("StockReturnListDataService", stockReturnListDataService);
//
			SaleProjectionDataService saleProjectionDataService = new SaleProjectionDataServiceImpl();
			Naming.bind("SaleProjectionDataService", saleProjectionDataService);
			//			SaleDataService saleDataService=new SaleDataServiceImpl();
//			Naming.bind("SaleDataService", saleDataService);
//			System.out.println("bind succeeded!");
//
			GoodsDataService goodsDataService=new GoodsDataServiceImpl();
			Naming.bind("GoodsDataService",goodsDataService);
			System.out.println("bind succeeded!");
//
			VIPDataService vipDataService=new VIPDataServiceImpl();
			Naming.bind("VIPDataService",vipDataService);
			System.out.println("bind succeeded!");
			
			
			System.out.println("All Service bind finish!");
			//所有的service都要在这里绑定一下
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void initListID(){
		//初始化一下，因为你们现在数据库里还没有。等你们都有了就可以删了。

		HibernateUtil_Green<StoreListID> hug=new HibernateUtil_Green<StoreListID>(StoreListID.class);
		StoreListID po1 = new StoreListID(StoreListType.ALARM.toString(),"KCBJD");
		StoreListID po2 =new StoreListID(StoreListType.LOSS.toString(),"KCBSD");
		StoreListID po3 =new StoreListID(StoreListType.OVERFLOW.toString(),"KCBYD");
		StoreListID po4=new StoreListID(StoreListType.PRESENT.toString(),"KCZSD");
	    hug.insert(po4);
	    hug.insert(po3);
	    hug.insert(po1);
	    hug.insert(po2);
		
		
	}
	
	public static void main(String []args){
		new ServerHelper();
	}
	
}
