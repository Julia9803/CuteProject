package dataHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**     
* @author 李安迪
* @date 2017年12月20日
* @description 使用hibernate框架的查询条件生成器
*/
public class HibernateCriterionClauseGenerator implements CriterionClauseGenerator{

	private static final String childPrefix = "child.";
	/* (non-Javadoc)
	 * @see dataHelper.CriterionClause#generateGeCriterion(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<CriterionClause> generateGeCriterion(List<CriterionClause> l,String field, Object value) throws RemoteException {
		// TODO Auto-generated method stub
		if(l == null)
			l = new ArrayList<CriterionClause>();
		l.add(new CriterionClause(Restrictions.ge(field,value)));
		return l;
	}
	
	/* (non-Javadoc)
	 * @see dataHelper.CriterionClause#generateLeCriterion(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<CriterionClause> generateLeCriterion(List<CriterionClause> l,String field, Object value) throws RemoteException {
		// TODO Auto-generated method stub
		if(l == null)
			l = new ArrayList<CriterionClause>();
		l.add(new CriterionClause(Restrictions.le(field,value)));
		return l;
	}

	/* (non-Javadoc)
	 * @see dataHelper.CriterionClause#generateExactCriterion(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<CriterionClause> generateExactCriterion(List<CriterionClause> l,String field, Object value) throws RemoteException{
		// TODO Auto-generated method stub
		if(l == null)
			l = new ArrayList<CriterionClause>();
		 l.add(new CriterionClause(Restrictions.eq(field,value)));
		return l;
	}

	/* (non-Javadoc)
	 * @see dataHelper.CriterionClause#generateFuzzyCriterion(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<CriterionClause> generateFuzzyCriterion(List<CriterionClause> l,String field, Object value) throws RemoteException{
		// TODO Auto-generated method stub
		if(l == null)
			l = new ArrayList<CriterionClause>();
		 l.add(new CriterionClause(Restrictions.like(field,"%"+value+"%")));
		return l;
	}

	/* (non-Javadoc)
	 * @see dataHelper.CriterionClauseGenerator#generateCurrentTimeInRangeCriterion(java.util.List, java.lang.String, java.lang.Object)
	 */
	@Override
	public List<CriterionClause> generateCurrentTimeInRangeCriterion(List<CriterionClause> l) throws RemoteException{
		// TODO Auto-generated method stub
		if(l == null)
			l = new ArrayList<CriterionClause>();
		Date date = new Date();
		l.add(new CriterionClause(Restrictions.le("startTime", date)));
		l.add(new CriterionClause(Restrictions.ge("finishTime", date)));
		return l;
	}



	/* (non-Javadoc)
	 * @see dataHelper.CriterionClauseGenerator#generateExactCriterion(java.util.List, java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<CriterionClause> generateExactCriterion(List<CriterionClause> l, String field, List values) throws RemoteException{
		// TODO Auto-generated method stub
		if(l == null)
			l = new ArrayList<CriterionClause>();
		Disjunction dis = Restrictions.disjunction();
		for (int i = 0; i < values.size(); i++) {
		         dis.add(Restrictions.eq(field,values.get(i)));
		 }
		l.add(new CriterionClause(dis));
		return l;
	}

	/* (non-Javadoc)
	 * @see dataHelper.CriterionClauseGenerator#generateExactAsChildCriterion(java.util.List, java.lang.String, java.util.List)
	 */
	@Override
	public List<CriterionClause> generateExactAsChildCriterion(List<CriterionClause> l, String field, List values) throws RemoteException{
		// TODO Auto-generated method stub
		return generateExactCriterion(l, childPrefix+field, values);
	}
	
	
}
