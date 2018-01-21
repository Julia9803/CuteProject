package dataHelper.serviceImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import dataHelper.service.CriterionClauseGenerator;

/**     
* @author 李安迪
* @date 2017年12月20日
* @description 使用hibernate框架的查询条件生成器
*/
public class HibernateCriterionClauseGenerator implements CriterionClauseGenerator{

	
	private static final long serialVersionUID = 8928699476005065760L;
	private static final String childPrefix = "child.";
	
	@Override
	public List<CriterionClause> generateGeCriterion(List<CriterionClause> l,String field, Object value) throws RemoteException {
		if(l == null)
			l = new ArrayList<CriterionClause>();
		l.add(new CriterionClause(Restrictions.ge(field,value)));
		return l;
	}
	
	
	@Override
	public List<CriterionClause> generateLeCriterion(List<CriterionClause> l,String field, Object value) throws RemoteException {
		if(l == null)
			l = new ArrayList<CriterionClause>();
		l.add(new CriterionClause(Restrictions.le(field,value)));
		return l;
	}

	
	@Override
	public List<CriterionClause> generateExactCriterion(List<CriterionClause> l,String field, Object value) throws RemoteException{
		if(l == null)
			l = new ArrayList<CriterionClause>();
		 l.add(new CriterionClause(Restrictions.eq(field,value)));
		return l;
	}

	
	@Override
	public List<CriterionClause> generateFuzzyCriterion(List<CriterionClause> l,String field, Object value) throws RemoteException{
		if(l == null)
			l = new ArrayList<CriterionClause>();
		 l.add(new CriterionClause(Restrictions.like(field,"%"+value+"%")));
		return l;
	}

	
	@Override
	public List<CriterionClause> generateCurrentTimeInRangeCriterion(List<CriterionClause> l) throws RemoteException{
		if(l == null)
			l = new ArrayList<CriterionClause>();
		Date date = new Date();
		l.add(new CriterionClause(Restrictions.le("startTime", date)));
		l.add(new CriterionClause(Restrictions.ge("finishTime", date)));
		return l;
	}



	
	@Override
	public List<CriterionClause> generateExactCriterion(List<CriterionClause> l, String field, @SuppressWarnings("rawtypes") List values) throws RemoteException{
		if(l == null)
			l = new ArrayList<CriterionClause>();
		Disjunction dis = Restrictions.disjunction();
		for (int i = 0; i < values.size(); i++) {
		         dis.add(Restrictions.eq(field,values.get(i)));
		 }
		l.add(new CriterionClause(dis));
		return l;
	}

	
	@Override
	public List<CriterionClause> generateExactAsChildCriterion(List<CriterionClause> l, String field, @SuppressWarnings("rawtypes") List values) throws RemoteException{
		return generateExactCriterion(l, childPrefix+field, values);
	}
	
	
}
