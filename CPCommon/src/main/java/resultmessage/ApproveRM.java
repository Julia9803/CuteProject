package resultmessage;

public enum ApproveRM {
	OK("审批成功"),
	INSUFFICIENT_ACCOUNT_BALANCE("账户余额不足"),
	INSUFFICIENT_STOCK_GOODS("库存数量不足"),
	OVER_VIP_COLLECTION_LIMIT("超出客户应收额度"),
	VIP_EXCEPTION("客户数据异常"),
	NETWORK_ERROR("网络异常"),
	SERVER_ERROR("服务器异常"),
	WRONG("未知错误");
	
	private final String name;
	ApproveRM (String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
}
