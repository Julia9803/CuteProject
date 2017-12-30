package dataServiceImpl.presentImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.PresentForSumPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateOrderClauseGenerator;
import dataHelper.HibernateUtil;
import dataHelper.OrderClause;
import dataHelper.OrderClauseGenerator;
import dataService.presentDataService.PresentForSumDataService;
import resultmessage.DataRM;
import util.PresentState;

/**     
* @author 李安迪
* @date 2017年12月15日
* @description
*/
public class PresentForSumDataServiceImpl extends UnicastRemoteObject implements PresentForSumDataService{

	
	BasicUtil<PresentForSumPO> util;
	CriterionClauseGenerator criterionClauseGenerator;
	OrderClauseGenerator orderClauseGenerator;		//TODO 记得初始化
	
	public PresentForSumDataServiceImpl() throws RemoteException{

		util = new HibernateUtil<PresentForSumPO>(PresentForSumPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		orderClauseGenerator = new HibernateOrderClauseGenerator();
	}
	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#insert()
	 */
	@Override
	public int insert() throws RemoteException{
		// TODO Auto-generated method stub
		return util.insertForAuto(new PresentForSumPO());
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#deletePresentForSum(int)
	 */
	@Override
	public DataRM deletePresentForSum(int id) throws RemoteException {
		// TODO Auto-generated method stub
		PresentForSumPO po = (PresentForSumPO)(util.get(id));
		//惰性删除
		po.setState(PresentState.DELETE);
		return util.update(po);
	}
//
	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#update(PO.PresentForSumPO)
	 */
	@Override
	public DataRM update(PresentForSumPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum()
	 */
	@Override
	public List<PresentForSumPO> getPresentForSum() throws RemoteException {
		// TODO Auto-generated method stub		
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state", PresentState.SAVE);
		System.out.println(l);
		System.out.println("before query");
		List<PresentForSumPO> list =  util.Query(l);
		System.out.println("before return");
		System.out.println(list);
		return list;
//		return new ArrayList<PresentForSumPO>();
		
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum(int)
	 * 
	 */
	@Override
	public List<PresentForSumPO> getPresentForSum(double sum) throws RemoteException {
		// TODO Auto-generated method stub
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateLeCriterion(l,"sum", sum);
//		l = criterionClauseGenerator.generateExactCriterion(l,"sum", sum);
		l = criterionClauseGenerator.generateExactCriterion(l,"state", PresentState.SAVE);
		l = criterionClauseGenerator.generateCurrentTimeInRangeCriterion(l);
		
		OrderClause o = orderClauseGenerator.generateDescOrder("sum");
		
		return util.Query(l,o);
	}
	

}
