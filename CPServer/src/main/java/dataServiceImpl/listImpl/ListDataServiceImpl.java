package dataServiceImpl.listImpl;

import PO.InfoListPO;
import dataHelper.HibernateUtil_Green;
import dataService.listDataService.ListDataService;
import util.State;
import java.util.ArrayList;

public class ListDataServiceImpl implements ListDataService {
    HibernateUtil_Green<InfoListPO> util=new HibernateUtil_Green<InfoListPO>(InfoListPO.class);
    @Override
    public void addInfoList(InfoListPO po) {
        util.insert(po);
    }

    @Override
    public void removeInfoList(String id) {
      util.delete(id);
    }

    @Override
    public void changeToApproved(String id) {
         InfoListPO po=util.get(id);
         po.state=State.IsApproved;
         util.update(po);
    }

    @Override
    public ArrayList<InfoListPO> openInfoList() {
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
    public ArrayList<InfoListPO> openApproved() {
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
