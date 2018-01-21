package bl.accountbl;

import java.util.Date;
import java.util.stream.Collectors;

import PO.account.CashExpenseListPO;
import PO.account.EntryItemPO;
import PO.account.FinanceListPO;
import VO.accountVO.CashExpenseListVO;
import VO.accountVO.EntryItemVO;
import VO.accountVO.FinanceListVO;
import VO.userVO.MessageVO;
import dataService.accountDataService.FinanceListDataService;
import resultmessage.ApproveRM;
import util.DateUtil;
import util.GreatListType;

public class CashExpenseListImpl extends FinanceListImpl{
	public CashExpenseListImpl(FinanceListDataService dataService) {
		super(dataService);
	}

	@Override
	public ApproveRM approve(FinanceListVO vo) {
		CashExpenseListVO cvo = (CashExpenseListVO)vo;
		String accountName = cvo.getAccount();
		if(!accountBalanceChangeService.checkSufficiency(accountName, cvo.getTotalAmount()))
			return ApproveRM.INSUFFICIENT_ACCOUNT_BALANCE;
		accountBalanceChangeService.reduce(accountName, cvo.getTotalAmount());
		
		//检查成功
		return super.approve(cvo);
	}
	
	@Override
	protected FinanceListPO voTopo(FinanceListVO vo) {
		CashExpenseListVO cvo = (CashExpenseListVO)vo;
		return new CashExpenseListPO(cvo.getId(),
									cvo.getOperator(),
									cvo.getOperatorId(),
									cvo.getState(),
									cvo.getAccount(),
									cvo.getEntryItem().stream().map(e -> entryItemVoToPo(e)).collect(Collectors.toList()),
									cvo.getTotalAmount(),
									DateUtil.getDateFromListID(cvo.getId())
									);
		
	}

	@Override
	protected FinanceListVO poTovo(FinanceListPO po) {
		CashExpenseListPO cpo = (CashExpenseListPO)po;
		return new CashExpenseListVO(cpo.getId(),
									cpo.getOperator(),
									cpo.getOperatorId(),
									cpo.getState(),
									cpo.getAccount(),
									cpo.getEntryItem().stream().map(e -> entryItemPoToVo(e)).collect(Collectors.toList()),
									cpo.getTotalAmount()
									);
	}
	
	private EntryItemPO entryItemVoToPo(EntryItemVO vo){
		return new EntryItemPO(vo.getEntryName(),vo.getAmount(),vo.getNote());
	}
	
	private EntryItemVO entryItemPoToVo(EntryItemPO po){
		return new EntryItemVO(po.getEntryName(),po.getAmount(),po.getNote());
	}

	@Override
	protected GreatListType getGreatListType() {
		return GreatListType.CASHEXPENSE;
	}

	@Override
	protected String getKeyInfo(FinanceListVO vo) {
		CashExpenseListVO cvo = (CashExpenseListVO)vo;
		return "账户 " + cvo.getAccount() + " 支出现金费用 " + cvo.getTotalAmount() + " 元";
	}
	
	@Override
	protected MessageVO getMessageVO(FinanceListVO vo) {
		CashExpenseListVO cvo = (CashExpenseListVO)vo;
		String content = cvo.getAccount() + "支出现金费用" + cvo.getTotalAmount() + " 元" + System.lineSeparator();
		for(EntryItemVO item : cvo.getEntryItem()){
			content +=  item.getEntryName() + " "+ item.getAmount() + " 元" + System.lineSeparator(); 
		}
		return new MessageVO("支出现金费用",content,new Date());
	}

	
}
