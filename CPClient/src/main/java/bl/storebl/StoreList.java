package bl.storebl;

import VO.listVO.ListRM;
import bl.listbl.Approvable;
import bl.listbl.InfoList;
import bl.listbl.InfoList_Impl;

public class StoreList implements Approvable {
    /*
 * 库存类单据，是所有能够进行审批、导出操作的库存单据的父类
 * 要注意：不包括库存报警单。
 * 包括库存赠送单、库存报溢单、库存报损单。赠送单比较特殊，只有手动生成的赠送单可以审批和导出，自动生成的赠送单相当于自动审批通过
 * 这个类是继承树的根节点，其他有单据的包希望也能够模仿这种模式来写。
 * 王瑞华 161250143 2017年12月1日
*/
	InfoList infoList =new InfoList_Impl();

	@Override
	public ListRM Approve(String id) {
		// TODO Auto-generated method stub
		return null;
	}



}
