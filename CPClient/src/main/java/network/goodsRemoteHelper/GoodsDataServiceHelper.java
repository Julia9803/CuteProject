package network.goodsRemoteHelper;

import dataService.goodsDataService.GoodsDataService;
import network.DataServiceHelper;

import java.rmi.Remote;

/**
 * Created by julia98 on 2017/12/13.
 */
public class GoodsDataServiceHelper implements DataServiceHelper{
    private GoodsDataService goodsDataService;
    private static final String serviceName = "GoodsDataService";

    private static GoodsDataServiceHelper goodsRemoteHelper = new GoodsDataServiceHelper();
    public static GoodsDataServiceHelper getInstance(){
        return goodsRemoteHelper;
    }
    private GoodsDataServiceHelper(){
    }

    public String getServiceName(){
        return serviceName;
    }

    public void setRemote(Remote remote){
        goodsDataService = (GoodsDataService)remote;
    }

    public GoodsDataService getGoodsDataService(){
        return goodsDataService;
    }
}
