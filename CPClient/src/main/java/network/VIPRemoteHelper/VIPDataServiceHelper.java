package network.VIPRemoteHelper;

import java.rmi.Remote;

import dataService.VIPDataService.VIPDataService;
import network.DataServiceHelper;

/**
 * Created by julia98 on 2017/12/13.
 */
public class VIPDataServiceHelper implements DataServiceHelper {
    private VIPDataService vipDataService;
    private static final String serviceName = "VIPDataService";

    private static VIPDataServiceHelper vipRemoteHelper = new VIPDataServiceHelper();
    public static VIPDataServiceHelper getInstance(){
        return vipRemoteHelper;
    }
    private VIPDataServiceHelper(){
    }

    @Override
	public String getServiceName(){
        return serviceName;
    }

    @Override
	public void setRemote(Remote remote){
        vipDataService = (VIPDataService)remote;
    }

    public VIPDataService getVIPDataService(){
        return vipDataService;
    }
}
