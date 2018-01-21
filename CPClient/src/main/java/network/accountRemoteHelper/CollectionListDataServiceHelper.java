package network.accountRemoteHelper;

import java.rmi.Remote;

import dataService.accountDataService.CollectionListDataService;
import network.DataServiceHelper;

public class CollectionListDataServiceHelper implements DataServiceHelper{
	private CollectionListDataService collectionListDataService ;
	private static final String serviceName = "CollectionListDataService";
	
	private static CollectionListDataServiceHelper collectionListRemoteHelper = new CollectionListDataServiceHelper();
	public static CollectionListDataServiceHelper getInstance(){
		return collectionListRemoteHelper;
	}
	
	private CollectionListDataServiceHelper(){
	}
	
	@Override
	public String getServiceName(){
		return serviceName;
	}
	
	@Override
	public void setRemote(Remote remote){
		collectionListDataService = (CollectionListDataService)remote;
	}
	
	public CollectionListDataService getDataService(){
		return collectionListDataService;
	}
	
}
