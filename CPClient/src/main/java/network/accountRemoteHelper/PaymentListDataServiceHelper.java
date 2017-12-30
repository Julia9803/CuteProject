package network.accountRemoteHelper;

import java.rmi.Remote;

import dataService.accountDataService.PaymentListDataService;
import network.DataServiceHelper;

public class PaymentListDataServiceHelper implements DataServiceHelper{
	private PaymentListDataService paymentListDataService ;
	private static final String serviceName = "PaymentListDataService";
	
	private static PaymentListDataServiceHelper paymentListRemoteHelper = new PaymentListDataServiceHelper();
	public static PaymentListDataServiceHelper getInstance(){
		return paymentListRemoteHelper;
	}
	
	private PaymentListDataServiceHelper(){
	}
	
	public String getServiceName(){
		return serviceName;
	}
	
	public void setRemote(Remote remote){
		paymentListDataService = (PaymentListDataService)remote;
	}
	
	public PaymentListDataService getDataService(){
		return paymentListDataService;
	}
	
}
