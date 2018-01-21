package dataServiceImpl.userImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.user.UserPO;
import dataHelper.service.BasicUtil;
import dataHelper.service.CriterionClauseGenerator;
import dataHelper.serviceImpl.CriterionClause;
import dataHelper.serviceImpl.HibernateCriterionClauseGenerator;
import dataHelper.serviceImpl.HibernateUtil;
import dataService.userDataService.UserDataService;
import resultmessage.DataRM;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService{

	
	private static final long serialVersionUID = 5801522716518730770L;
	BasicUtil<UserPO> basicUtil;
	CriterionClauseGenerator criterionClauseGenerator;

	public UserDataServiceImpl() throws RemoteException {
		basicUtil = new HibernateUtil<UserPO>(UserPO.class);
		criterionClauseGenerator = new HibernateCriterionClauseGenerator();
	}

	@Override
	public DataRM insert(UserPO po) throws RemoteException {
		String name = basicUtil.insert(po);
		if(name == null)
			return DataRM.EXIST;
		if(name.equals(""))
			return DataRM.FAILED;
		
		return DataRM.SUCCESS;
	}

	@Override
	public DataRM delete(String name) throws RemoteException {
		return basicUtil.delete(name);
	}

	@Override
	public DataRM update(UserPO po) throws RemoteException {
		return basicUtil.update(po);
	}

	@Override
	public UserPO getUser(String name) throws RemoteException {
		return basicUtil.get(name);
	}

	@Override
	public List<UserPO> getAllUser() throws RemoteException {
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateFuzzyCriterion(l,"name","");
		return basicUtil.Query(l);
	}

}
