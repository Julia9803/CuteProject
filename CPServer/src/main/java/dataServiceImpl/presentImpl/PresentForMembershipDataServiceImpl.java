package dataServiceImpl.presentImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.PresentForMembershipPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateOrderClauseGenerator;
import dataHelper.HibernateUtil;
import dataHelper.OrderClause;
import dataHelper.OrderClauseGenerator;
import dataService.presentDataService.PresentForMembershipDataService;
import resultmessage.DataRM;
import util.PresentState;
import util.VIPGrade;

/**     
* @author 李安迪
* @date 2017年12月20日
* @description
*/
public class PresentForMembershipDataServiceImpl extends UnicastRemoteObject implements PresentForMembershipDataService{

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForMembershipDataService#insert()
	 */
	BasicUtil<PresentForMembershipPO> util;
	CriterionClauseGenerator criterionClauseGenerator;
	OrderClauseGenerator orderClauseGenerator;
	
	public PresentForMembershipDataServiceImpl() throws RemoteException{

		util = new HibernateUtil<PresentForMembershipPO>(PresentForMembershipPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
		orderClauseGenerator = new HibernateOrderClauseGenerator();
	}
	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#insert()
	 */
	@Override
	public int insert() throws RemoteException{
		// TODO Auto-generated method stub
		return util.insertForAuto(new PresentForMembershipPO());
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#deletePresentForSum(int)
	 */
	@Override
	public DataRM deletePresentForMembership(int id) throws RemoteException {
		// TODO Auto-generated method stub
		PresentForMembershipPO po = (PresentForMembershipPO)(util.get(id));
		//惰性删除
		po.setState(PresentState.DELETE);
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#update(PO.PresentForSumPO)
	 */
	@Override
	public DataRM update(PresentForMembershipPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum()
	 */
	@Override
	public List<PresentForMembershipPO> getPresentForMembership() throws RemoteException {
		// TODO Auto-generated method stub		
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state", PresentState.SAVE);
		return util.Query(l);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum(int)
	 * 注意获取的是某一特定等级的促销策略，而不是这个等级及以上的
	 * 要求总额达到一定金额
	 */
	@Override
	public List<PresentForMembershipPO> getPresentForMembership(VIPGrade grade,double sum) throws RemoteException {
		// TODO Auto-generated method stub
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"grade", grade);
		l = criterionClauseGenerator.generateExactCriterion(l,"state", PresentState.SAVE);
		l = criterionClauseGenerator.generateLeCriterion(l,"sum", sum);
		l = criterionClauseGenerator.generateCurrentTimeInRangeCriterion(l);
		
		
		OrderClause o = orderClauseGenerator.generateDescOrder("voucher");
		
		return util.Query(l,o);
//		return util.Query(l);
	}


}
