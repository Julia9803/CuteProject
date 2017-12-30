package bl.accountbl;

import java.util.stream.Collectors;

import PO.account.CollectionListPO;
import PO.account.FinanceListPO;
import PO.account.TransferItemPO;
import VO.accountVO.CollectionListVO;
import VO.accountVO.FinanceListVO;
import VO.accountVO.TransferItemVO;
import dataService.accountDataService.FinanceListDataService;

public class CollectionListImpl extends FinanceListImpl{

	public CollectionListImpl(FinanceListDataService dataService) {
		super(dataService);
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
									cvo.getState());
		
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

}
