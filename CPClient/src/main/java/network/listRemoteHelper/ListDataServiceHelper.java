package network.listRemoteHelper;
import java.rmi.Remote;

import dataService.listDataService.ListDataService;
import network.DataServiceHelper;

public class ListDataServiceHelper  implements DataServiceHelper{

	private ListDataService listDataService;
	private static final String serviceName = "ListDataService";
	private static ListDataServiceHelper listRemoteHelper = new ListDataServiceHelper();
	@Override
	public String getServiceName() {
		
		return serviceName;
	}

	@Override
	public void setRemote(Remote remote) {
		listDataService = (ListDataService)remote;
		
	}
	
	
	public static ListDataServiceHelper getInstance(){
	
		return listRemoteHelper;
	}
    private ListDataServiceHelper(){
    }
    
    public ListDataService getListDataService(){
    	return listDataService;
    }
    
	

}
