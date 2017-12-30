package network.saleRemoteHelper;

import java.rmi.Remote;

import dataService.saleDataService.SaleListDataService;
import dataService.saleDataService.SaleUniDataService;
import network.DataServiceHelper;


/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleListDataServiceHelper implements DataServiceHelper{
	private SaleListDataService SaleListDataService;
	private static final String serviceName = "SaleListDataService";
	private static SaleListDataServiceHelper SaleListRemoteHelper = new SaleListDataServiceHelper();
	public static SaleListDataServiceHelper getInstance(){
		return SaleListRemoteHelper;
	}
    private SaleListDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	SaleListDataService = (SaleListDataService)remote;
    }
    
    public SaleListDataService getSaleListDataService(){
    	return SaleListDataService;
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
