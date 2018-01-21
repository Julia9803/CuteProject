package blservice.accountblservice;

import java.util.List;

import VO.accountVO.AccountVO;
import VO.accountVO.FinanceListVO;
import resultmessage.ApproveRM;
import resultmessage.CommitListRM;
import resultmessage.DeleteListRM;
import resultmessage.SaveListRM;

public interface FinanceListService {

	public String newList();
	public void endService();		//结束服务。现在的功能是，将新建后未保存且未提交的单据删掉
	public DeleteListRM delete(String id);
	public SaveListRM save(FinanceListVO vo);
	public CommitListRM commit(FinanceListVO vo);
	public List<? extends FinanceListVO> openDraft();
	public List<? extends FinanceListVO> openCommitted();
	public FinanceListVO getList(String id);
	
	public ApproveRM approve(FinanceListVO vo);
	public void reject(FinanceListVO vo);
	
	public List<AccountVO> findAccount();


	
}
