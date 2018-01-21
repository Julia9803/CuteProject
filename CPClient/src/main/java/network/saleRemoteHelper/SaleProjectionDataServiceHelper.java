package network.saleRemoteHelper;

import java.rmi.Remote;

import dataService.saleDataService.SaleProjectionDataService;
import network.DataServiceHelper;


/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleProjectionDataServiceHelper implements DataServiceHelper{
	private SaleProjectionDataService saleProjectionDataService;
	private static final String serviceName = "SaleProjectionDataService";
	private static SaleProjectionDataServiceHelper SaleProjectionRemoteHelper = new SaleProjectionDataServiceHelper();
	public static SaleProjectionDataServiceHelper getInstance(){
		return SaleProjectionRemoteHelper;
	}
    private SaleProjectionDataServiceHelper(){
    }
    
    @Override
	public void setRemote(Remote remote){
    	saleProjectionDataService = (SaleProjectionDataService)remote;
    }
    
    public SaleProjectionDataService getSaleProjectionDataService(){
    	return saleProjectionDataService;
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
