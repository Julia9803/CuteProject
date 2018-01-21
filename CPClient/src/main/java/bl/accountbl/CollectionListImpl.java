package bl.accountbl;

import java.util.Date;
import java.util.stream.Collectors;

import PO.account.CollectionListPO;
import PO.account.FinanceListPO;
import PO.account.TransferItemPO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.TransferItemVO;
import VO.userVO.MessageVO;
import blservice.VIPforAccountService.VIPReceivableChangeService;
import blservice.serviceFactory.VIPReceivableChangeFactory;
import dataService.accountDataService.FinanceListDataService;
import resultmessage.ApproveRM;
import util.DateUtil;
import util.GreatListType;

public class CollectionListImpl extends FinanceListImpl{

	public CollectionListImpl(FinanceListDataService dataService) {
		super(dataService);
	}
	
	@Override
	public ApproveRM approve(FinanceListVO vo) {
		CollectionListVO cvo = (CollectionListVO)vo; 
		
		//修改vip应收
		String VIPName = cvo.getVIPName();
		VIPReceivableChangeService vipService = VIPReceivableChangeFactory.getVIPReceivableChangeService();
		boolean vipReceivableChanged = vipService.collect(VIPName, cvo.getTotalAmount());
		if(!vipReceivableChanged)
			return ApproveRM.VIP_EXCEPTION;
		
		for(TransferItemVO item : cvo.getTransferItem()){
			accountBalanceChangeService.increase(item.getAccount(), item.getAmount());
		}
		
		//检查成功
		return super.approve(vo);
	}

	@Override
	protected FinanceListPO voTopo(FinanceListVO vo) {
		CollectionListVO cvo = (CollectionListVO)vo;
		return new CollectionListPO(cvo.getId(),
									cvo.getVIPID(),
									cvo.getVIPName(),
									cvo.getOperator(),
									cvo.getOperatorId(),
									cvo.getTransferItem().stream().map(e -> transferItemVoToPo(e)).collect(Collectors.toList()),
									cvo.getTotalAmount(),
									cvo.getState(),
									DateUtil.getDateFromListID(cvo.getId())
									);
		
	}

	@Override
	protected FinanceListVO poTovo(FinanceListPO po) {
		CollectionListPO cpo = (CollectionListPO)po;
		return new CollectionListVO(cpo.getId(),
				cpo.getVIPID(),
				cpo.getVIPName(),
				cpo.getOperator(),
				cpo.getOperatorId(),
				cpo.getTransferItem().stream().map(e -> transferItemPoToVo(e)).collect(Collectors.toList()),
				cpo.getTotalAmount(),
				cpo.getState());
	}
	
	private TransferItemPO transferItemVoToPo(TransferItemVO vo){
		return new TransferItemPO(vo.getAccount(),vo.getAmount(),vo.getNote());
	}
	
	private TransferItemVO transferItemPoToVo(TransferItemPO po){
		return new TransferItemVO(po.getAccount(),po.getAmount(),po.getNote());
	}

	@Override
	protected GreatListType getGreatListType() {
		return GreatListType.COLLECTMONEY;
	}

	@Override
	protected String getKeyInfo(FinanceListVO vo) {
		CollectionListVO cvo = (CollectionListVO)vo;
		return "向 "+cvo.getVIPName() + " 收款 " + cvo.getTotalAmount() + " 元";
	}

	@Override
	protected MessageVO getMessageVO(FinanceListVO vo) {
		CollectionListVO cvo = (CollectionListVO)vo;
		String content = "";
		for(TransferItemVO item : cvo.getTransferItem()){
			content += "账户 " + item.getAccount() + " 收款 " + item.getAmount() + "元" + System.lineSeparator(); 
		}
		return new MessageVO("收款",content,new Date());
	}

	

}
