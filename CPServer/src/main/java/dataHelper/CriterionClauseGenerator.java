package dataHelper;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**     
* @author 李安迪
* @date 2017年12月19日
* @description 添加查询条件的接口
*/
public interface CriterionClauseGenerator extends Remote,Serializable{
	//添加查询条件为大于等于单值
	public List<CriterionClause> generateGeCriterion(List<CriterionClause> l, String field,Object value) throws RemoteException;
	//添加查询条件为小于等于单值
	public List<CriterionClause> generateLeCriterion(List<CriterionClause> l, String field,Object value) throws RemoteException;
	//添加查询条件为精确查找单值
	public List<CriterionClause> generateExactCriterion(List<CriterionClause> l,String field,Object value) throws RemoteException;
	//添加查询条件为模糊查找单值
	public List<CriterionClause> generateFuzzyCriterion(List<CriterionClause> l,String field,Object value)throws RemoteException;
	//添加查询条件为当前时间在时间区间内
	public List<CriterionClause> generateCurrentTimeInRangeCriterion(List<CriterionClause> l)throws RemoteException;
	//添加查询条件为精确查找，单域多值，取并集
	public List<CriterionClause> generateExactCriterion(List<CriterionClause> l,String field,List values)throws RemoteException;
	//添加查询条件为级联精确查找，单域多值，取并集
	public List<CriterionClause> generateExactAsChildCriterion(List<CriterionClause> l,String field,List values)throws RemoteException;
//	//添加查询条件为模糊查找多值，需要时再添加
//	public List<CriterionClause> generateFuzzyCriterion(List<CriterionClause> l,String field,Object value);

	
}
