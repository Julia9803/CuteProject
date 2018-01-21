
package blservice.VIPforAccountService;

public interface VIPReceivableChangeService {
	public boolean collect(String VIPName, double amount);	//向客户收款amount，减少其应收，返回是否成功
	public boolean pay(String VIPName, double amount);		//向客户付款amount，减少其应付，返回是否成功
}
