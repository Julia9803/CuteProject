package dataHelper.serviceImpl;

import java.util.List;

import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaSpecification;

import PO.ListPO;
import dataHelper.service.BasicUtil;
import resultmessage.DataRM;
import util.DateUtil;
import util.State;

/**     
* @author 李安迪
* @date 2017年12月1日
* @description 数据库基础功能的hibernate实现
*/

@SuppressWarnings("deprecation")
public class HibernateUtil<T> implements BasicUtil<T>{

	private static final long serialVersionUID = -1120159929949882054L;
	private SessionFactory sessionFactory;
    private Session session = null;
    private Transaction transaction = null;

    private Class<T> type;
    
    public HibernateUtil(Class<T> type) {
    	this.type = type;
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    

	@Override
	public int insertForAuto(Object po) {
		session = sessionFactory.openSession();
		transaction = null;
		int id = -1;
        try {
        	transaction = session.beginTransaction();
            id = (Integer)session.save(type.getName(), po);
            transaction.commit();
        } catch (HibernateException e) {
        	if(transaction!=null){
        		transaction.rollback();
        	}
    		e.printStackTrace();
        }catch(PersistenceException e){		//数据库中已有此主键
        	if(transaction!=null){
        		transaction.rollback();
        	}
        	return -2;
        }finally{
           		session.close();
        }
        
        return id;
    }
	
	@Override
	public String insert(Object po) {
		session = sessionFactory.openSession();
		transaction = null;
		String id = "";
        try {
        	transaction = session.beginTransaction();
            id = (String)session.save(type.getName(), po);
            transaction.commit();
        }catch (HibernateException e) {		//不知道什么时候会出这个异常。
        	if(transaction!=null){
        		transaction.rollback();
        	}
    		e.printStackTrace();
    		return "";
        }catch(PersistenceException e){		//数据库中已有此主键
        	if(transaction!=null){
        		transaction.rollback();
        	}
        	return null;
        }finally{
           	session.close();
        }
   		return id;
	}
	
	@Override
	public DataRM delete(String id){
		session = sessionFactory.openSession();
		transaction = null;
		DataRM rm = DataRM.SUCCESS;
        try {
        	transaction = session.beginTransaction();
            session.delete(session.get(type.getName(),id));
            transaction.commit();

        }catch (IllegalArgumentException e){
        	if(transaction!=null){
        		transaction.rollback();
        	}
        	rm = DataRM.NOT_EXIST;
        }catch (OptimisticLockException e) {
        	if(transaction!=null){
        		transaction.rollback();
        	}
    		e.printStackTrace();
        	rm = DataRM.FAILED;
        }catch(HibernateException e){
        	if(transaction!=null){
        		transaction.rollback();
        	}
    		e.printStackTrace();
        	rm = DataRM.FAILED;
        }finally{
           	session.close();
        }
        return rm;
	}

	
	@Override
	public DataRM update(Object po) {
		session = sessionFactory.openSession();
		transaction = null;
		DataRM rm = DataRM.SUCCESS;
        try {
        	transaction = session.beginTransaction();
            session.update(type.getName(), po);
            transaction.commit();
        }catch (OptimisticLockException e) {
        	if(transaction!=null){
        		transaction.rollback();
        	}
        	rm = DataRM.NOT_EXIST;
        }catch(HibernateException e){
        	if(transaction!=null){
        		transaction.rollback();
        	}
    		e.printStackTrace();
    		rm = DataRM.FAILED;

        }finally{
           		session.close();
        }
        
        return rm;
	}
//	@Override
//	public List<T> fuzzyQuery(String field, String value){
//		Criterion s = null;
//		value = "%"+value+"%";
//		//如果查询域为空，整表查询
//		if(!field.isEmpty())
//		s = Restrictions.like(field,value);
//		return Query(s);
//	}
//
//	@Override
//	public List<T> exactQuery(String field, Object value){
//		Criterion s = null;
//		//如果查询域为空，整表查询
//		if(!field.isEmpty())
//		s = Restrictions.like(field,value);
//		return Query(s);
//	}
//	
//	@Override
//	public List<T> geQuery(String field, Object value){
//		Criterion s = null;
//		if(!field.isEmpty())
//		s = Restrictions.ge(field,value);
//		return Query(s);
//	}
//	
//	@Override
//	public List<T> exactQuery(String field, Object[] values){
//		Criterion s = null;
//		if(!field.isEmpty())
//		s = Restrictions.in(field, values);
//		return Query(s);
//	}
//	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> CascadeQuery(List<CriterionClause> criterionParentList,List<CriterionClause> criterionChildList, String string) {
		session = sessionFactory.openSession();
		transaction = null;
		List<T> list = null;
	try{	
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(type.getName(), "parent");
        for(CriterionClause s : criterionParentList)
       {if (s!=null)
        criteria.add(s.getCriterion());
       }
		criteria.createAlias("parent."+string, "child");
        for(CriterionClause s : criterionChildList)
       {if (s!=null)
        criteria.add(s.getCriterion());
       }
//		c.add(Restrictions.eq("child."+string2", "blue");
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		list = criteria.list();
		transaction.commit();
        session.close();
        return list;
    } catch (HibernateException e) {
    	if(transaction != null)
    	{
    		transaction.rollback();
    	}
    	e.printStackTrace();
    	return null;
    }finally{
    	session.close();
    }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> Query(List<CriterionClause> criterionList){
		session = sessionFactory.openSession();
		transaction = null;
		List<T> list = null;
	try{
		transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(type.getName());
        for(CriterionClause s : criterionList)
       {if (s!=null)
        criteria.add(s.getCriterion());
       }
        list = criteria.list();
        transaction.commit();
        session.close();
        return list;
    } catch (HibernateException e) {
    	if(transaction != null)
    	{
    		transaction.rollback();
    	}
    	System.out.println("hibernate Exception in query");
    	e.printStackTrace();
    	return null;
    }finally{
    	session.close();
    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> Query(List<CriterionClause> criterionList,OrderClause order){
		session = sessionFactory.openSession();
		transaction = null;
		List<T> list = null;
	try{
		transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(type.getName());
        for(CriterionClause s : criterionList)
       {if (s!=null)
        criteria.add(s.getCriterion());
       }
        criteria.addOrder(order.getOrder());
        list = criteria.list();
        transaction.commit();
        session.close();
        return list;
    } catch (HibernateException e) {
    	if(transaction != null)
    	{
    		transaction.rollback();
    	}
    	System.out.println("hibernate Exception in query");
    	e.printStackTrace();
    	return null;
    }finally{
    	session.close();
    }
	}
	
	
	@Override
	public Object get(int id) {
		session = sessionFactory.openSession();
		transaction = null;
		Object o = null;
        try {
        	transaction = session.beginTransaction();
            o = session.get(type.getName(), id);
            transaction.commit();
        } catch (HibernateException e) {
        	if(transaction!=null){
        		transaction.rollback();
        		e.printStackTrace();
        	}
        }finally{
           		session.close();
        	}
        
        return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(String id) {
		session = sessionFactory.openSession();
		transaction = null;
		T o = null;
        try {
        	transaction = session.beginTransaction();
            o = (T)session.get(type.getName(), id);
            transaction.commit();
        } catch (HibernateException e) {
        	if(transaction!=null){
        		transaction.rollback();
        		e.printStackTrace();
        	}
        }finally{
           		session.close();
        	}
        
        return o;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getLastRow(){
		session = sessionFactory.openSession();
		transaction = null;
		List<T> list = null;
	try{
		transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(type.getName());
        list = criteria.list();
        T po = null;
        if(list!=null&&(!list.isEmpty())){
        po = list.get(list.size()-1);
        }
        transaction.commit();
        session.close();
        return po;
    } catch (HibernateException e) {
    	if(transaction != null)
    	{
    		transaction.rollback();
    	}
    	System.out.println("hibernate Exception in query");
    	e.printStackTrace();
    	return null;
    }finally{
    	session.close();
    }
	}
	
	private static final int LIST_MAX_NUM = 99999;
	
	@Override
	public String getNewListId(String prefix, ListPO po){
		T lastpo = getLastRow();
		String currentDate = DateUtil.getCurrentDate();
		String newId = prefix +"-"+currentDate + "-";
//		System.out.println(lastpo);
		if(lastpo == null){		//表空
			newId +="00001";
		}else{
			String lastId = ((ListPO)lastpo).getId();
			String date = DateUtil.getDateFromListIDAsString(lastId);
			if(!currentDate.equals(date)){		//今天的第一张单子
				newId += "00001";
			}
			else{
				int num = Integer.parseInt(lastId.substring(lastId.lastIndexOf('-')+1));
				if(num == LIST_MAX_NUM)
					return global.ListGlobalVariables.LIST_FULL;
				num++;
				String post = String.valueOf(num);
				int postLength = String.valueOf(LIST_MAX_NUM).length();		//后缀长度
				for(int i = 1;i <= postLength-post.length();i++){
					newId += "0";
				}
				newId += post;
			}
		}
		System.out.println(newId);
		po.setId(newId);
		po.setState(State.IsEditting);
		insert(po);
		return newId;
		
	}

	@Override
	public double Projection(ProjectionClause l) {
		
		session = sessionFactory.openSession();
		transaction = null;
	try{
		transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(type.getName());
        
        criteria.setProjection(l.getProjection());
        double result = 0;
        result = ((Long)criteria.uniqueResult()).doubleValue();
        
        transaction.commit();
        session.close();
        return result;
    } catch (HibernateException e) {
    	if(transaction != null)
    	{
    		transaction.rollback();
    	}
    	System.out.println("hibernate Exception in projection");
    	e.printStackTrace();
    	return -1;
    }finally{
    	session.close();
    }
	}
}

