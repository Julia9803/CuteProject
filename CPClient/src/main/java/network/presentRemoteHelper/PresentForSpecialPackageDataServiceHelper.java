package network.presentRemoteHelper;

import java.rmi.Remote;

import dataService.presentDataService.PresentForSpecialPackageDataService;
import network.DataServiceHelper;

public class PresentForSpecialPackageDataServiceHelper implements DataServiceHelper{

	private PresentForSpecialPackageDataService presentForSpecialPackageDataService;
	private static final String serviceName = "PresentForSpecialPackageDataService";
	
	private static PresentForSpecialPackageDataServiceHelper presentForSpecialPackageRemoteHelper = new PresentForSpecialPackageDataServiceHelper();
	public static PresentForSpecialPackageDataServiceHelper getInstance(){
		return presentForSpecialPackageRemoteHelper;
	}
    private PresentForSpecialPackageDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	presentForSpecialPackageDataService = (PresentForSpecialPackageDataService)remote;
    }
    
    public PresentForSpecialPackageDataService getPresentForSpecialPackageDataService(){
    	return presentForSpecialPackageDataService;
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
