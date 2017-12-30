package bl.listbl;

import VO.listVO.ListRM;

public interface Approvable {
    //每个可审批的单据需要实现的接口。
	public ListRM Approve(String id);
	/*
	 * 每一种可审批的单据对上面这个方法都要实现一下。
	 * 在单个单据审批时，自己的单据在界面层与逻辑层间有一个审批方法，审批方法调用这个方法的实现来完成。
	 * 在批量审批的时候，我通过这个接口找到你们对应的实现，并完成审批。
	 */
	
	/*
	 * 提交单据的时候要调用InfoList 的Register 方法
	 * 审批成功通过或被拒绝需要调用Modify方法，库存不足的时候不用调用
	 * 检查一组商品库存的方法写在Store_Interface接口里
	 */
}
