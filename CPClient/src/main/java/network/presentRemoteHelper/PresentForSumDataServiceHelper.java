package network.presentRemoteHelper;

import java.rmi.Remote;

import dataService.presentDataService.PresentForSumDataService;
import network.DataServiceHelper;

public class PresentForSumDataServiceHelper implements DataServiceHelper{

	private PresentForSumDataService presentForSumDataService;
	private static final String serviceName = "PresentForSumDataService";
	private static PresentForSumDataServiceHelper presentForSumRemoteHelper = new PresentForSumDataServiceHelper();
	public static PresentForSumDataServiceHelper getInstance(){
		return presentForSumRemoteHelper;
	}
    private PresentForSumDataServiceHelper(){
    }
    
    @Override
	public void setRemote(Remote remote){
    	presentForSumDataService = (PresentForSumDataService)remote;
    }
    
    public PresentForSumDataService getPresentForSumDataService(){
    //	presentForSumDataService = new PresentForSumDataServiceImpl();
    	return presentForSumDataService;
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
