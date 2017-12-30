package blservice.accountblservice;

import java.util.List;

import VO.accountVO.AccountVO;
import VO.accountVO.FinanceListVO;
import resultmessage.CommitListRM;
import resultmessage.DeleteListRM;
import resultmessage.SaveListRM;

public interface FinanceListService {

	public String newList();
	public DeleteListRM delete(String id);
	public SaveListRM save(FinanceListVO vo);
	public CommitListRM commit(FinanceListVO vo);
	public List<? extends FinanceListVO> openDraft();
	public List<? extends FinanceListVO> openCommitted();
	
	public List<AccountVO> findAccount();


	
}
