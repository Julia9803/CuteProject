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

import PO.SalesmanItemPO;
import PO.SalesmanListPO;
import PO.StockListPO;
import dataService.saleDataService.StockListDataService;
import resultmessage.DataRM;
import util.State;
import util.UserGrade;

/**     
* @author 李安迪
* @date 2018年1月4日
* @description 进货单测试
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockListDataServiceImplTest {
	static StockListDataService service;
	static String id = null; 
	static List<SalesmanItemPO> list = new ArrayList<>();
	static StockListPO po;
	@BeforeClass
	public static void init() throws RemoteException{ 
		service = new StockListDataServiceImpl();
		list.add(new SalesmanItemPO("161","钛合金灯","中型",998,1,998,"无话可说"));
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
		po = new StockListPO(id, State.IsDraft, null, null, null, null, null, null, null, null, null, null, 0);
		assertEquals(DataRM.SUCCESS,service.save(po));
	}
	
	@Test
	public void c_openDraft() throws RemoteException{
		assertNotNull(service.openAllDraft());
		boolean contains = false;
		for(SalesmanListPO po :service.openAllDraft()){
			StockListPO spo = (StockListPO)po;
			if(spo.equals(po))
				contains = true;
		}
		assertTrue(contains);
	}
	@Test
	public void d_commit() throws RemoteException{
		assertEquals(DataRM.SUCCESS,service.save(new StockListPO(id,State.IsCommitted,new Date(),UserGrade.General,"001","老王","老张","002",null,"默认仓库","我是备注",list,998)));		
	}
	
	@Test
	public void e_approve() throws RemoteException{
		assertEquals(DataRM.SUCCESS,service.approve(new StockListPO(id,State.IsApproved,new Date(),UserGrade.General,"001","老王","老张","002",null,"默认仓库","我是备注",list,998)));		
		
	}
	
	@Test
	public void f_reject() throws RemoteException{
		assertEquals(DataRM.SUCCESS,service.refuse(new StockListPO(id,State.IsRefused,new Date(),UserGrade.General,"001","老王","老张","002",null,"默认仓库","我是备注",list,998)));		
		
	}
}
