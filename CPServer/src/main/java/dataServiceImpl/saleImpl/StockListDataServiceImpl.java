package dataServiceImpl.saleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.SalesmanListPO;
import PO.StockListPO;
import dataHelper.service.BasicUtil;
import dataHelper.service.CriterionClauseGenerator;
import dataHelper.serviceImpl.CriterionClause;
import dataHelper.serviceImpl.HibernateCriterionClauseGenerator;
import dataHelper.serviceImpl.HibernateUtil;
import dataService.saleDataService.StockListDataService;
import resultmessage.DataRM;
import util.State;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description
*/
public class StockListDataServiceImpl extends UnicastRemoteObject implements StockListDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912987570951492322L;
	BasicUtil<StockListPO> util;
	//	BasicUtil<StockListPO> util;
	CriterionClauseGenerator criterionClauseGenerator;
	/**
	 * @throws RemoteException
	 */
	public StockListDataServiceImpl() throws RemoteException {
		super();
		util = new HibernateUtil<StockListPO>(StockListPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#insert()
	 */
	@Override
	public String insert() throws RemoteException {
		 
		return util.getNewListId("JHD", new StockListPO());	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#delete(java.lang.String)
	 */
	@Override
	public DataRM delete(String id) throws RemoteException {
		 
		StockListPO po = (util.get(id));
//		po.setState(State.IsDeleted);
		System.out.println(util);
		System.out.println(po);
		return util.delete(id);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#save(PO.SalesmanListPO)
	 */
	@Override
	public DataRM save(SalesmanListPO po) throws RemoteException {
		 
		return util.update(po);
	}


	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#commit(PO.SalesmanListPO)
	 */
	@Override
	public DataRM commit(SalesmanListPO po) throws RemoteException {
		 
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#approve(PO.SalesmanListPO)
	 */
	@Override
	public DataRM approve(SalesmanListPO po) throws RemoteException {
		 
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#refuse(PO.SalesmanListPO)
	 */
	@Override
	public DataRM refuse(SalesmanListPO po) throws RemoteException {
		 
		return util.update(po);
	}
	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#openAllDraft()
	 */
	@Override
	public List<SalesmanListPO> openAllDraft() throws RemoteException {
		 
		
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state",State.IsDraft);
		System.out.println(l);
		System.out.println("before query");
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<SalesmanListPO> list = (List)util.Query(l);
		System.out.println("before return");
		System.out.println(list);
		return list;
	}

	
	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#get(java.lang.String)
	 */
	@Override
	public SalesmanListPO get(String id) throws RemoteException {
		 
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"id",id);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<SalesmanListPO> list = (List)util.Query(l);
		if(list.size() == 1){
			return list.get(0);
		}else
			
		return null;
	}
}
