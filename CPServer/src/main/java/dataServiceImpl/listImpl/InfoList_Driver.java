package dataServiceImpl.listImpl;

import java.rmi.RemoteException;

import PO.InfoListPO;
import util.GreatListType;
import util.State;

public class InfoList_Driver {
   //驱动类，测试一下数据库好不好用。
    ListDataServiceImpl impl;

    public static void  main(String [] args){
        InfoList_Driver driver=new InfoList_Driver();
        InfoListPO po=new InfoListPO("008", GreatListType.LOSS,"高毓斌","再试一下");
        po.state= State.IsCommitted;
        try {
			driver.impl.removeInfoList("008");
		} catch (RemoteException e) {
			
			e.printStackTrace();
		};
    }
}
