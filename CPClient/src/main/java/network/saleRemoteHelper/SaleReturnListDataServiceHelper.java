package network.saleRemoteHelper;

import java.rmi.Remote;

import dataService.saleDataService.SaleReturnListDataService;
import network.DataServiceHelper;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class SaleReturnListDataServiceHelper implements DataServiceHelper{
	private SaleReturnListDataService SaleReturnListDataService;
	private static final String serviceName = "SaleReturnListDataService";
	private static SaleReturnListDataServiceHelper SaleReturnListRemoteHelper = new SaleReturnListDataServiceHelper();
	public static SaleReturnListDataServiceHelper getInstance(){
		return SaleReturnListRemoteHelper;
	}
    private SaleReturnListDataServiceHelper(){
    }
    
    @Override
	public void setRemote(Remote remote){
    	SaleReturnListDataService = (SaleReturnListDataService)remote;
    }
    
    public SaleReturnListDataService getSaleReturnListDataService(){
    	return SaleReturnListDataService;
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
