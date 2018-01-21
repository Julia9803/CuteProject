package dataServiceImpl.presentImpl;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.GoodsInSalePO;
import PO.PresentForSpecialPackagePO;
import dataService.presentDataService.PresentForSpecialPackageDataService;
import resultmessage.DataRM;
import util.PresentState;

/**
 * Created by julia98 on 2017/12/29.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PresentForSpecialPackageDataServiceImplTest {
    List<GoodsInSalePO> gpolist = new ArrayList<>();
    @SuppressWarnings("deprecation")
    PresentForSpecialPackagePO po = new PresentForSpecialPackagePO(2, Date.from(Instant.EPOCH), new Date(117,11,29),gpolist, PresentState.SAVE,1);
    GoodsInSalePO gpo = new GoodsInSalePO("1","abc",100);


    List<PresentForSpecialPackagePO> ppo = new ArrayList<>();
    int id = 0;
	
  
    @Test
    public void a_insert() throws Exception {
    	PresentForSpecialPackageDataService service = new PresentForSpecialPackageDataServiceImpl();
       int now = service.insert();
    	assertEquals(now+1,service.insert());
    }
//

    @Test
    public void e_deletePresentForSpecialPackage() throws Exception {
        assertEquals(DataRM.SUCCESS,new PresentForSpecialPackageDataServiceImpl().deletePresentForSpecialPackage(po.getId()));
    }

    @Test
    public void b_update() throws Exception {
    	gpolist.add(gpo);
    	System.out.println(po.getId()+"+"+po);
        assertEquals(DataRM.SUCCESS,new PresentForSpecialPackageDataServiceImpl().update(po));
    }

    @Test
    public void c_getPresentForSpecialPackage() throws Exception {
    	gpolist.add(gpo);
    	ppo.add(po);
    	assertEquals(ppo,new PresentForSpecialPackageDataServiceImpl().getPresentForSpecialPackage());
    }

    @Ignore
    @Test
    public void d_getPresentForSpecialPackage1() throws Exception {
        assertEquals(ppo,new PresentForSpecialPackageDataServiceImpl().getPresentForSpecialPackage(gpolist));
    }

}