package network.saleRemoteHelper;

import java.rmi.Remote;

import dataService.saleDataService.StockReturnListDataService;
import network.DataServiceHelper;

/**     
* @author 李安迪
* @date 2017年12月24日
* @description
*/
public class StockReturnListDataServiceHelper implements DataServiceHelper{
	private StockReturnListDataService StockReturnListDataService;
	private static final String serviceName = "StockReturnListDataService";
	private static StockReturnListDataServiceHelper StockReturnListRemoteHelper = new StockReturnListDataServiceHelper();
	public static StockReturnListDataServiceHelper getInstance(){
		return StockReturnListRemoteHelper;
	}
    private StockReturnListDataServiceHelper(){
    }
    
    public void setRemote(Remote remote){
    	StockReturnListDataService = (StockReturnListDataService)remote;
    }
    
    public StockReturnListDataService getStockReturnListDataService(){
    	return StockReturnListDataService;
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
