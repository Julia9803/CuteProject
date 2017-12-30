package dataServiceImpl.saleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.SaleListPO;
import PO.SalesmanListPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateUtil;
import dataService.saleDataService.SaleListDataService;
import dataService.saleDataService.SaleUniDataService;
import resultmessage.DataRM;
import util.PresentState;
import util.State;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description 销售单的基础数据库操作
* TODO 单据在表单包的注册，审批，以及通知等功能
*/
public class SaleListDataServiceImpl extends UnicastRemoteObject implements SaleListDataService{

	BasicUtil<SaleListPO> util;
	//	BasicUtil<SaleListPO> util;
	CriterionClauseGenerator criterionClauseGenerator;
	/**
	 * @throws RemoteException
	 */
	public SaleListDataServiceImpl() throws RemoteException {
		super();
		util = new HibernateUtil<SaleListPO>(SaleListPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#insert()
	 */
	@Override
	public String insert() throws RemoteException {
		// TODO Auto-generated method stub
		return util.getNewListId("XSD", new SaleListPO());
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#delete(java.lang.String)
	 */
	@Override
	public DataRM delete(String id) throws RemoteException {
		// TODO Auto-generated method stub
		SaleListPO po = (SaleListPO)(util.get(id));
		po.setState(State.IsDeleted);
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#save(PO.SalesmanListPO)
	 */
	@Override
	public DataRM save(SalesmanListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}


	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#commit(PO.SalesmanListPO)
	 */
	@Override
	public DataRM commit(SalesmanListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#approve(PO.SalesmanListPO)
	 */
	@Override
	public DataRM approve(SalesmanListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#refuse(PO.SalesmanListPO)
	 */
	@Override
	public DataRM refuse(SalesmanListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}
	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#openAllDraft()
	 */
	@Override
	public List<SalesmanListPO> openAllDraft() throws RemoteException {
		// TODO Auto-generated method stub
		
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state",State.IsDraft);
		System.out.println(l);
		System.out.println("before query");
		List<SalesmanListPO> list = (List)util.Query(l);
		System.out.println("before return");
		System.out.println(list);
		return list;
	}
}