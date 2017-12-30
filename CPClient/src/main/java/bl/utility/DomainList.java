package bl.utility;

import java.rmi.Remote;

/**
 * 这个类是所有逻辑层单据类的父类，把所有单据共同的操作放在这里
 * 这样搞应该就可以了，动态的配置一下dataService，其他操作均相同
 * @author zxy
 *
 */
public abstract class DomainList {
	
	Remote dataService;
	
	public void deployDataService(){		//关键一步
		dataService = getDataService();
	}
	
	public String newList(){
		//TODO
		return null;
	}
	
	public abstract Remote getDataService();		
	
}
