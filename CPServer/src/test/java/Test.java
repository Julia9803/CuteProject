


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import PO.GoodsInSalePO;
import PO.PresentResultPO;
import PO.SaleListPO;
import PO.SalesmanItemPO;
import dataService.saleDataService.SaleListDataService;
import dataServiceImpl.saleImpl.SaleListDataServiceImpl;
import util.State;
import util.UserGrade;
import util.VIPGrade;

//package dataHelper;
//
//import PO.GoodsInSalePO;
//import PO.PresentForSumPO;
//import org.hibernate.Session;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**     
//* @author 李安迪
//* @date 2017年12月1日
//* @description
//*/
////
public class Test {
	static SaleListDataService service;
	static String id = null; 
	static List<SalesmanItemPO> list = new ArrayList<>();
	static SaleListPO po;
	static PresentResultPO present;
	static List<Integer> presentId;
	static List<GoodsInSalePO> presentList;

	 public static void main( String[] args )
	    {
		 
				try {
					service = new SaleListDataServiceImpl();
					id = service.insert();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(new SalesmanItemPO("161","钛合金灯","中型",998,1,998,"无话可说"));
				presentId = new ArrayList<Integer>();
				presentId.add(250);
				presentList = new ArrayList<>();
				presentList.add(new GoodsInSalePO("520","驱蚊灯",5));
				present = new PresentResultPO(presentId,100,presentList,998);
				po = new SaleListPO(id,State.IsDraft,new Date(),UserGrade.General,"001","老王",VIPGrade.GradeThree,"老张","002",null,"默认仓库","我是备注",list,998,1001,2,1,present);		
				System.out.println(po.getPresentResultPO());
				try {
					service.save(po);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					service = new SaleListDataServiceImpl();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					System.out.println(((SaleListPO)service.get(id)).getPresentResultPO());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	    }
}
//
//
//
//}
