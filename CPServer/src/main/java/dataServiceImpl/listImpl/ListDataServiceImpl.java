package dataServiceImpl.listImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.InfoListPO;
import dataHelper.serviceImpl.HibernateUtil_Green;
import dataService.listDataService.ListDataService;
import util.State;

public class ListDataServiceImpl extends UnicastRemoteObject implements ListDataService {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5917640852758106407L;
	HibernateUtil_Green<InfoListPO> util=new HibernateUtil_Green<InfoListPO>(InfoListPO.class);
    
   
    
    public ListDataServiceImpl () throws RemoteException{
    	//super();
    }
    
    @Override
    public void addInfoList(InfoListPO po) throws RemoteException {
        util.insert(po);
    }

    @Override
    public void removeInfoList(String id) throws RemoteException{
      util.delete(id);
    }

    @Override
    public void changeToApproved(String id) throws RemoteException{
         InfoListPO po=util.get(id);
         if(po!=null){
         po.state=State.IsApproved;
         util.update(po);
         }else{
        	 System.out.println("PO为空");
         }
    }

    @Override
    public ArrayList<InfoListPO> openInfoList() throws RemoteException{
        ArrayList<InfoListPO> list1=(ArrayList<InfoListPO>)util.getList();
        ArrayList<InfoListPO> list2=new ArrayList<InfoListPO>();
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).state.equals(State.IsCommitted)){
                list2.add(list1.get(i));
            }
        }

        
        return list2;
    }

    @Override
    public ArrayList<InfoListPO> openApproved() throws RemoteException{
        ArrayList<InfoListPO> list1=(ArrayList<InfoListPO>)util.getList();
        ArrayList<InfoListPO> list2=new ArrayList<InfoListPO>();
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).state.equals(State.IsApproved)){
                list2.add(list1.get(i));
            }
        }
        return list2;
    }
}
