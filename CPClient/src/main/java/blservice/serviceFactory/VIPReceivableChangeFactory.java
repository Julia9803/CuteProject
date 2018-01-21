package blservice.serviceFactory;

import blservice.VIPforAccountService.VIPReceivableChangeService;
import blservice.VIPforAccountService.VIPReceivableChangeServiceImpl;

public class VIPReceivableChangeFactory {
	public static VIPReceivableChangeService getVIPReceivableChangeService(){
		return new VIPReceivableChangeServiceImpl();
	}
}

