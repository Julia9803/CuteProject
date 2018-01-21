package blservice.VIPforAccountService;

import java.rmi.RemoteException;

import bl.VIPbl.VIPCollectionModifyImpl;
import blservice.VIPblservice.VIPCollectionModify;

public class VIPReceivableChangeServiceImpl implements VIPReceivableChangeService{		

	VIPCollectionModify vipService = new  VIPCollectionModifyImpl();
	@Override
	public boolean collect(String VIPName, double amount) {
		try {
			double vipCollection = vipService.getVIPCollection(VIPName);
			if(amount > vipCollection)
				return false;
			vipService.setVIPCollection(VIPName, vipCollection - amount);
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean pay(String VIPName, double amount) {
		try {
			double vipPayment = vipService.getVIPPayment(VIPName);
			if(amount > vipPayment)
				return false;
			vipService.setVIPPayment(VIPName, vipPayment-amount);
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
