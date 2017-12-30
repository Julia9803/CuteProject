package bl.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import PO.account.FinanceListPO;
import VO.accountVO.AccountVO;
import VO.accountVO.FinanceListVO;
import blservice.accountblservice.FinanceListService;
import dataService.accountDataService.FinanceListDataService;
import resultmessage.CommitListRM;
import resultmessage.DataRM;
import resultmessage.DeleteListRM;
import resultmessage.SaveListRM;
import util.State;

public abstract class FinanceListImpl implements FinanceListService{

	FinanceListDataService financeListDataService;
	
	public FinanceListImpl(FinanceListDataService dataService){
		financeListDataService = dataService;
	}
	
	@Override
	public String newList() {
		try {
			String newId = financeListDataService.getNewListId();
			if(newId == null || newId == "")
				return null;
			return newId;
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public DeleteListRM delete(String id) {
		try {
			 DataRM datarm = financeListDataService.delete(id);
			 switch(datarm){
			 case SUCCESS:
				 return DeleteListRM.SUCCESS;
			 case NOT_EXIST:
				 return DeleteListRM.NOT_EXIST;
			case FAILED:
				return DeleteListRM.SERVER_ERROR;
			default:
				break;
			 }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return DeleteListRM.NETWORK_ERROR;

	}

	@Override
	public SaveListRM save(FinanceListVO vo) {
		FinanceListPO po = voTopo(vo);
		try {
			DataRM datarm = financeListDataService.update(po);
			switch(datarm){
			case SUCCESS:
				return SaveListRM.SUCCESS;
			case NOT_EXIST:
					DataRM insertRm = financeListDataService.insert(po);		//还是有这种情况的。。
					switch(insertRm){
					case FAILED:
						return SaveListRM.SERVER_ERROR;
					case SUCCESS:
						return SaveListRM.SUCCESS;
					default:
						break;
					}
					break;
			case FAILED:
				return SaveListRM.SERVER_ERROR;
			default:
				break;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return SaveListRM.NETWORK_ERROR;
	}

	@Override
	public CommitListRM commit(FinanceListVO vo) {
		vo.setState(State.IsCommitted);
		SaveListRM saverm = save(vo);
		switch(saverm){
		case NETWORK_ERROR:
			return CommitListRM.NETWORK_ERROR;
		case SERVER_ERROR:
			return CommitListRM.SERVER_ERROR;
		case SUCCESS:
			return CommitListRM.SUCCESS;
		default:
			break;
		}
		return CommitListRM.SERVER_ERROR;		
	}

	@Override
	public List<? extends FinanceListVO> openDraft() {
		try {
			@SuppressWarnings("unchecked")
			List<? extends FinanceListPO> listpo = (List<? extends FinanceListPO>) financeListDataService.getList(State.IsDraft);
			return listpo.stream().map(e -> poTovo(e)).collect(Collectors.toList());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<? extends FinanceListVO> openCommitted() {
		try {
			@SuppressWarnings("unchecked")
			List<? extends FinanceListPO> listpo = (List<? extends FinanceListPO>) financeListDataService.getList(State.IsCommitted);
			return listpo.stream().map(e -> poTovo(e)).collect(Collectors.toList());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountVO> findAccount() {
		//TODO Stub
		 AccountVO accountvo = new AccountVO("老张",10000);
		List<AccountVO> list = new ArrayList<AccountVO>();
		list.add(accountvo);
		return list;
	}

	protected abstract FinanceListPO voTopo(FinanceListVO vo);
	
	protected abstract FinanceListVO poTovo(FinanceListPO po);
}
