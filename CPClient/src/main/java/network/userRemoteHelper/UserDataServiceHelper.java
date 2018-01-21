package network.userRemoteHelper;

import java.rmi.Remote;

import dataService.userDataService.UserDataService;
import network.DataServiceHelper;

public class UserDataServiceHelper implements DataServiceHelper{
	private UserDataService userDataService ;
	private static final String serviceName = "UserDataService";
	
	private static UserDataServiceHelper userRemoteHelper = new UserDataServiceHelper();
	public static UserDataServiceHelper getInstance(){
		return userRemoteHelper;
	}
	
	private UserDataServiceHelper(){
	}
	
	@Override
	public String getServiceName(){
		return serviceName;
	}
	
	@Override
	public void setRemote(Remote remote){
		userDataService = (UserDataService)remote;
	}
	
	public UserDataService getDataService(){
		return userDataService;
	}
	
}
