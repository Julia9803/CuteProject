package bl.listbl;

import java.rmi.RemoteException;

import PO.InfoListPO;
import dataService.listDataService.ListDataService;
import network.ServerConnector;
import network.accountRemoteHelper.CollectionListDataServiceHelper;
import network.listRemoteHelper.ListDataServiceHelper;
import util.GreatListType;
import util.State;

//import static org.junit.Assert.*;

//import org.junit.Test;

public class ListblControllerTest {
	
	
  
	//试一下数据好不好用
     public  void insertInfoList(){
    	 InfoListPO po=new InfoListPO ();
    	 po.id="KKKKK-20170629-11222";
    	 po.operator="在试验";
    	 po.type=GreatListType.LOSS;
    	 po.note="试一下好不好用";
    	 po.state=State.IsCommitted;
    	 try {
    		 ListDataService listDataService=ListDataServiceHelper.getInstance().getListDataService();
    		 System.out.println(CollectionListDataServiceHelper.getInstance().getDataService()==null);
    		 System.out.println(listDataService==null);
			listDataService.addInfoList(po);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
     }
     
     public static void main(String [] args){
    	 ListblControllerTest lt=new ListblControllerTest();
    	 ServerConnector sc=new ServerConnector();
    	 for(int i=0;i<1000000;i++){
    		 ;
    	 }
    	 lt.insertInfoList();
    	 
     }
     
}
