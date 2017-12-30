package dataServiceImpl.presentImpl;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import PO.GoodsInSalePO;
import PO.PresentForSumPO;
import resultmessage.DataRM;
import util.PresentState;

/**
 * Created by julia98 on 2017/12/29.
 * passed on 2017/12/29.
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PresentForSumDataServiceImplTest {
    GoodsInSalePO gpo = new GoodsInSalePO("1","abc",100);
    List<GoodsInSalePO> gpolist = new ArrayList<>();
    PresentForSumPO po = new PresentForSumPO(1,Date.from(Instant.EPOCH), new Date(217,11,29),1, gpolist,PresentState.SAVE,1);
    List<PresentForSumPO> ppo = new ArrayList<>();
    @Test
    public void a_insert() throws Exception {
          PresentForSumDataServiceImpl service = new PresentForSumDataServiceImpl();
          int now = service.insert();
          po.setId(now);
          assertEquals(now+1,service.insert());
    }

    @Test
    public void e_deletePresentForSum() throws Exception {
        PresentForSumDataServiceImpl service = new PresentForSumDataServiceImpl();
       
        assertEquals(DataRM.SUCCESS,new PresentForSumDataServiceImpl().deletePresentForSum(1));
    }
//
    @Test
    public void b_update() throws Exception {
        gpolist.add(gpo);
        System.out.println(po.getId()+" "+po);
        assertEquals(DataRM.SUCCESS,new PresentForSumDataServiceImpl().update(po));
    }
//
    @Test
    public void c_getPresentForSum() throws Exception {
    	gpolist.add(gpo);
        ppo.add(po);
        assertEquals(ppo,new PresentForSumDataServiceImpl().getPresentForSum());
    }
//
    @Test
    public void d_getPresentForSum1() throws Exception {
    	gpolist.add(gpo);
        ppo.add(po);
    	assertEquals(ppo,new PresentForSumDataServiceImpl().getPresentForSum(1));
    }
}