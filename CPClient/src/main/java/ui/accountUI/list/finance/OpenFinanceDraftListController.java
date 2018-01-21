package ui.accountUI.list.finance;

import ui.mainUI.accountantUI.AccountantWinController;

/**
 * 未来可以重构一下，将三种子类的共有逻辑抽象到这里（不过首先要将briefcontroller那边重构一下，不然这边也不行）
 * @author zxy
 *
 */

public abstract class OpenFinanceDraftListController extends OpenFinanceListController{
	protected AccountantWinController accountantWinController;

	
}
