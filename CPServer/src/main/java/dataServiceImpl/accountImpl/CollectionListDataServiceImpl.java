package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.ListPO;
import PO.account.CollectionListPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateOrderClauseGenerator;
import dataHelper.HibernateUtil;
import dataHelper.OrderClause;
import dataHelper.OrderClauseGenerator;
import dataService.accountDataService.CollectionListDataService;
import resultmessage.DataRM;
import util.State;

public class CollectionListDataServiceImpl extends UnicastRemoteObject implements CollectionListDataService {

	
	BasicUtil<CollectionListPO> basicUtil;
	CriterionClauseGenerator criterionClauseGenerator;
	OrderClauseGenerator orderClauseGenerator;
	
	public CollectionListDataServiceImpl() throws RemoteException{

		basicUtil = new HibernateUtil<CollectionListPO>(CollectionListPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		orderClauseGenerator = new HibernateOrderClauseGenerator();
	}
	
	@Override
	public String getNewListId()  throws RemoteException{
		return basicUtil.getNewListId("SKD", new CollectionListPO());
		
	}
	
	public static void main(String [] args){
		CollectionListPO po = new CollectionListPO();
		po.setId("SKD-20171227-00001");
		po.setVIPID("monk");
		CollectionListDataServiceImpl impl;
		try {
			impl = new CollectionListDataServiceImpl();
			System.out.println(impl.delete("SKD-20171227-00001"));
			System.out.println(impl.insert(po));
			
//			System.out.println((impl.getNewListId()));
//			System.out.println((impl.getNewListId()));
//			System.out.println((impl.getNewListId()));

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataRM insert(ListPO po) throws RemoteException{
		String id = basicUtil.insert((CollectionListPO)po);
		if(id == null)
			return DataRM.EXIST;
		if(id.equals(""))
			return DataRM.FAILED;
		else
			return DataRM.SUCCESS;
	}

	@Override
	public DataRM delete(String id) throws RemoteException {
		return basicUtil.delete(id);
	}

	@Override
	public DataRM update(ListPO po) throws RemoteException {
		return basicUtil.update(po);
	}

	@Override
	public List<CollectionListPO> getList(State state) throws RemoteException {
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state", state);
		OrderClause o = orderClauseGenerator.generateDescOrder("day");
		return basicUtil.Query(l, o);	
	}

}
