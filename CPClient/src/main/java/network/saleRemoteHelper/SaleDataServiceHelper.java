package network.saleRemoteHelper;

import java.rmi.Remote;

import dataService.saleDataService.SaleDataService;

public class SaleDataServiceHelper {

	private SaleDataService saleDataService;
	
	private static SaleDataServiceHelper saleRemoteHelper = new SaleDataServiceHelper();
	public static SaleDataServiceHelper getInstance(){
		return saleRemoteHelper;
	}
    private SaleDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	saleDataService = (SaleDataService)remote;
    }
    
    public SaleDataService getSaleDataService(){
    	return saleDataService;
    }
}
