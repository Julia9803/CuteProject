package dataServiceImpl.saleImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.SalesmanListPO;
import PO.StockReturnListPO;
import dataHelper.service.BasicUtil;
import dataHelper.service.CriterionClauseGenerator;
import dataHelper.serviceImpl.CriterionClause;
import dataHelper.serviceImpl.HibernateCriterionClauseGenerator;
import dataHelper.serviceImpl.HibernateUtil;
import dataService.saleDataService.StockReturnListDataService;
import resultmessage.DataRM;
import util.State;

/**     
* @author 李安迪
* @date 2017年12月25日
* @description
*/
public class StockReturnListDataServiceImpl extends UnicastRemoteObject implements StockReturnListDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8475631038135970631L;
	BasicUtil<StockReturnListPO> util;
	//	BasicUtil<StockReturnListPO> util;
	CriterionClauseGenerator criterionClauseGenerator;
	/**
	 * @throws RemoteException
	 */
	public StockReturnListDataServiceImpl() throws RemoteException {
		super();
		util = new HibernateUtil<StockReturnListPO>(StockReturnListPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#insert()
	 */
	@Override
	public String insert() throws RemoteException {
		// TODO Auto-generated method stub
		return util.getNewListId("JHTHD", new StockReturnListPO());	}

	/* (non-Javadoc)
	 * @see dataService.saleDataService.SaleUniDataService#delete(java.lang.String)
	 */
	@Override
	public DataRM delete(String id) throws RemoteException {
		return util.delete(id);
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
		// TODO Auto-generated method stub
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
