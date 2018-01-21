package dataServiceImpl.accountImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import PO.account.AccountPO;
import dataHelper.service.BasicUtil;
import dataHelper.service.CriterionClauseGenerator;
import dataHelper.serviceFactory.BasicUtilServiceFactory;
import dataHelper.serviceFactory.CriterionClauseGeneratorServiceFactory;
import dataHelper.serviceImpl.CriterionClause;
import dataService.accountDataService.AccountDataService;
import resultmessage.DataRM;

public class AccountDataServiceImpl extends UnicastRemoteObject implements AccountDataService{

	
	private static final long serialVersionUID = 3905445225330293809L;
	BasicUtil<AccountPO> basicUtil;
	CriterionClauseGenerator criterionClauseGenerator;
	
	public AccountDataServiceImpl() throws RemoteException {
		basicUtil = BasicUtilServiceFactory.getService(AccountPO.class);
		criterionClauseGenerator = CriterionClauseGeneratorServiceFactory.getService();
	}

	@Override
	public List<AccountPO> getAllAccount() throws RemoteException {
		List<CriterionClause> l = new ArrayList<CriterionClause>();
		l = criterionClauseGenerator.generateFuzzyCriterion(l,"accountName","");
		return basicUtil.Query(l);
	}

	@Override
	public DataRM deleteAllAccount() throws RemoteException {
		List<AccountPO> poList = getAllAccount();
		for(AccountPO po : poList){
			basicUtil.delete(po.getAccountName());
		}
		return DataRM.SUCCESS;
	}

	@Override
	public DataRM insert(AccountPO po) throws RemoteException {
		String id = basicUtil.insert(po);
		if(id == null)
			return DataRM.EXIST;
		if(id.equals(""))
			return DataRM.FAILED;
		return DataRM.SUCCESS;
	}

	@Override
	public AccountPO get(String accountName) throws RemoteException {
		return basicUtil.get(accountName);
		
	}

	@Override
	public DataRM update(AccountPO po) throws RemoteException {
		return basicUtil.update(po);
	}

}
