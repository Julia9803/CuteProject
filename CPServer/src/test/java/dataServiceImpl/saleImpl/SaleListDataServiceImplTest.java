package dataServiceImpl.saleImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.GoodsInSalePO;
import PO.PresentResultPO;
import PO.SaleListPO;
import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import dataService.saleDataService.SaleListDataService;
import resultmessage.DataRM;
import util.State;
import util.UserGrade;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2018年1月4日
* @description 销售单测试
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleListDataServiceImplTest {
	static SaleListDataService service;
	static String id = null; 
	static List<SalesmanItemPO> list = new ArrayList<>();
	static SaleListPO po;
	static PresentResultPO present;
	static List<Integer> presentId;
	static List<GoodsInSalePO> presentList;
	@BeforeClass
	public static void init() throws RemoteException{ 
		service = new SaleListDataServiceImpl();
		list.add(new SalesmanItemPO("161","钛合金灯","中型",998,1,998,"无话可说"));
		presentId = new ArrayList<Integer>();
		presentId.add(250);
		presentList = new ArrayList<>();
		presentList.add(new GoodsInSalePO("520","驱蚊灯",5));
		present = new PresentResultPO(presentId,100,presentList,998);
//		String hql="DELETE FROM SaleListPO";
//		Session s = new Configuration().configure().buildSessionFactory().openSession();
//		Transaction t = s.beginTransaction();
//		Query query = s.createQuery(hql);
//		query.executeUpdate();	
//		t.commit();
	}
	
	@Test
	public void a_insert() throws RemoteException {
		id = service.insert();
		assertNotNull(id);
		
	}
	
	
	@Test
	public void z_delete() throws RemoteException{
		assertEquals(DataRM.SUCCESS,service.delete(id));
	}

	
	@Test
	public void b_save() throws RemoteException{
		po = new SaleListPO(id, State.IsDraft, null, null, null, null, null, null, null, null, null, null, null, 0,0,0,0, null);
		assertEquals(DataRM.SUCCESS,service.save(po));
		assertEquals(DataRM.SUCCESS,service.save(new SaleListPO(id,State.IsDraft,new Date(),UserGrade.General,"001","老王",VIPGrade.GradeThree,"老张","002",null,"默认仓库","我是备注",list,998,1001,2,1,present)));		

	}
	
	@Test
	public void c_openDraft() throws RemoteException{
		assertNotNull(service.openAllDraft());
		boolean contains = false;
		if(!service.openAllDraft().isEmpty())
		for(SalesmanListPO po :service.openAllDraft()){
			SaleListPO spo = (SaleListPO)po;
			if(spo.equals(po))
				contains = true;
		}
		assertTrue(contains);
	}
	@Test
	public void d_commit() throws RemoteException{
		assertEquals(DataRM.SUCCESS,service.save(new SaleListPO(id,State.IsCommitted,new Date(),UserGrade.General,"001","老王",VIPGrade.GradeThree,"老张","002",null,"默认仓库","我是备注",list,998,1001,2,1,present)));		

	}
	
	@Test
	public void e_approve() throws RemoteException{
		assertEquals(DataRM.SUCCESS,service.approve(new SaleListPO(id,State.IsApproved,new Date(),UserGrade.General,"001","老王",VIPGrade.GradeThree,"老张","002",null,"默认仓库","我是备注",list,998,1001,2,1,present)));		
		
	}
	
	@Test
	public void f_reject() throws RemoteException{
		assertEquals(DataRM.SUCCESS,service.refuse(new SaleListPO(id,State.IsRefused,new Date(),UserGrade.General,"001","老王",VIPGrade.GradeThree,"老张","002",null,"默认仓库","我是备注",list,998,1001,2,1,present)));		
		
	}
}
