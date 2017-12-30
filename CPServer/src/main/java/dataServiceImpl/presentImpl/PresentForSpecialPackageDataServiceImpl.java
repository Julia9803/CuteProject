package dataServiceImpl.presentImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.GoodsInSalePO;
import PO.PresentForSpecialPackagePO;
import PO.PresentForSumPO;
import dataHelper.BasicUtil;
import dataHelper.CriterionClause;
import dataHelper.CriterionClauseGenerator;
import dataHelper.HibernateCriterionClauseGenerator;
import dataHelper.HibernateUtil;
import dataService.presentDataService.PresentForSpecialPackageDataService;
import resultmessage.DataRM;
import util.PresentState;

/**     
* @author 李安迪
* @date 2017年12月20日
* @description
*/
public class PresentForSpecialPackageDataServiceImpl extends UnicastRemoteObject implements PresentForSpecialPackageDataService{
	BasicUtil<PresentForSpecialPackagePO> util;
	CriterionClauseGenerator criterionClauseGenerator;
	
	public PresentForSpecialPackageDataServiceImpl() throws RemoteException{

		util = new HibernateUtil<PresentForSpecialPackagePO>(PresentForSpecialPackagePO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
	}
	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#insert()
	 */
	@Override
	public int insert() throws RemoteException{
		// TODO Auto-generated method stub
		return util.insertForAuto(new PresentForSpecialPackagePO());
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#deletePresentForSum(int)
	 */
	@Override
	public DataRM deletePresentForSpecialPackage(int id) throws RemoteException {
		// TODO Auto-generated method stub
		PresentForSpecialPackagePO po = (PresentForSpecialPackagePO)(util.get(id));
		//惰性删除
		po.setState(PresentState.DELETE);
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#update(PO.PresentForSumPO)
	 */
	@Override
	public DataRM update(PresentForSpecialPackagePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return util.update(po);
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum()
	 */
	@Override
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage() throws RemoteException {
		// TODO Auto-generated method stub		
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateExactCriterion(l,"state", PresentState.SAVE);
		return util.Query(l);
	}
	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSpecialPackageDataService#getPresentForSpecialPackage(java.util.List)
	 */
	@Override
	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<GoodsInSalePO> goodsList)
			throws RemoteException {
		// TODO Auto-generated method stub
		String id;
		List<String> idList = new ArrayList<String>();
		for(GoodsInSalePO po : goodsList){
			idList.add(po.getId());
		}
		List<CriterionClause> criterionChildList = new ArrayList<CriterionClause>();
		criterionChildList = criterionClauseGenerator.generateExactAsChildCriterion(criterionChildList,"id",(List)idList);
		List<CriterionClause> criterionParentList = new ArrayList<CriterionClause>();
		criterionParentList = criterionClauseGenerator.generateExactCriterion(criterionParentList,"state", PresentState.SAVE);
		criterionParentList = criterionClauseGenerator.generateCurrentTimeInRangeCriterion(criterionParentList);
		return util.CascadeQuery(criterionParentList, criterionChildList,"presentList");
	}

	/* (non-Javadoc)
	 * @see dataService.presentDataService.PresentForSumDataService#getPresentForSum(int)
	 */
//	@Override
//	public List<PresentForSpecialPackagePO> getPresentForSpecialPackage(List<String> GoodsID) throws RemoteException {
//		// TODO Auto-generated method stub
//		List<CriterionClause> criterionChildList = new ArrayList<CriterionClause>();
//		criterionChildList = criterionClauseGenerator.generateExactAsChildCriterion(criterionChildList,"id",(List)GoodsID);
//		List<CriterionClause> criterionParentList = new ArrayList<CriterionClause>();
//		criterionParentList = criterionClauseGenerator.generateExactCriterion(criterionParentList,"state", PresentState.SAVE);
//		criterionParentList = criterionClauseGenerator.generateCurrentTimeInRangeCriterion(criterionParentList);
//		return util.CascadeQuery(criterionParentList, criterionChildList,"presentList");
//	}

}
