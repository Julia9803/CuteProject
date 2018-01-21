package network.storeRemoteHelper;

import java.rmi.Remote;

import dataService.storeDataService.StoreDataService;
import network.DataServiceHelper;

public class StoreDataServiceHelper implements DataServiceHelper{

	private StoreDataService storeDataService;
	private static final String serviceName = "StoreDataService";
	
	private static StoreDataServiceHelper storeRemoteHelper = new StoreDataServiceHelper();
	public static StoreDataServiceHelper getInstance(){
		return storeRemoteHelper;
	}
    private StoreDataServiceHelper(){
    }
    
    @Override
	public String getServiceName() {
		return serviceName;
	}
    
    @Override
	public void setRemote(Remote remote){
    	storeDataService = (StoreDataService)remote;
    }
    
    public StoreDataService getStoreDataService(){
    	return storeDataService;
    }
	
	
}
