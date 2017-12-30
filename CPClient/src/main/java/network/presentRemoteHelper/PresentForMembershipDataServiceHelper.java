package network.presentRemoteHelper;

import java.rmi.Remote;

import dataService.presentDataService.PresentForMembershipDataService;
import network.DataServiceHelper;


public class PresentForMembershipDataServiceHelper implements DataServiceHelper{

	private PresentForMembershipDataService presentForMembershipDataService;
	private static final String serviceName = "PresentForMembershipDataService";
	private static PresentForMembershipDataServiceHelper presentForMembershipRemoteHelper = new PresentForMembershipDataServiceHelper();
	public static PresentForMembershipDataServiceHelper getInstance(){
		return presentForMembershipRemoteHelper;
	}
    private PresentForMembershipDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	presentForMembershipDataService = (PresentForMembershipDataService)remote;
    }
    
    public PresentForMembershipDataService getPresentForMembershipDataService(){
    	return presentForMembershipDataService;
    }
	/* (non-Javadoc)
	 * @see network.DataServiceHelper#getServiceName()
	 */
	@Override
	public String getServiceName() {
		// TODO Auto-generated method stub
		return serviceName;
	}
}
