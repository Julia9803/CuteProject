package bl.accountbl;

import PO.account.FinanceListPO;
import VO.accountVO.FinanceListVO;
import dataService.accountDataService.FinanceListDataService;

public class PaymentListImpl extends FinanceListImpl{

	public PaymentListImpl(FinanceListDataService dataService) {
		super(dataService);
	}

	@Override
	protected FinanceListPO voTopo(FinanceListVO vo) {
		
		return null;
	}

	@Override
	protected FinanceListVO poTovo(FinanceListPO po) {
		// TODO Auto-generated method stub
		return null;
	}


}
