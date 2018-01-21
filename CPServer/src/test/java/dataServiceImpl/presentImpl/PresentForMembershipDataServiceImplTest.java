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
import PO.PresentForMembershipPO;
import resultmessage.DataRM;
import util.PresentState;
import util.VIPGrade;

/**
 * Created by julia98 on 2017/12/29.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PresentForMembershipDataServiceImplTest {
    List<PresentForMembershipPO> list = new ArrayList<>();
    GoodsInSalePO gpo = new GoodsInSalePO("1","abc",100);
    List<GoodsInSalePO> gpolist = new ArrayList<>();
    @SuppressWarnings("deprecation")
	PresentForMembershipPO po = new PresentForMembershipPO(22, Date.from(Instant.EPOCH),new Date(217,6,15),1,gpolist, PresentState.SAVE,1, VIPGrade.GradeOne,1);


    @Test
    public void a_insert() throws Exception {
        PresentForMembershipDataServiceImpl service = new PresentForMembershipDataServiceImpl();
        int now = service.insert();
        assertEquals(now+1,service.insert());
    }

    @Test
    public void e_deletePresentForMembership() throws Exception {
        assertEquals(DataRM.SUCCESS,new PresentForMembershipDataServiceImpl().deletePresentForMembership(23));
    }

    @Test
    public void b_update() throws Exception {
    	gpolist.add(gpo);
        assertEquals(DataRM.SUCCESS,new PresentForMembershipDataServiceImpl().update(po));
    }

    @Test
    public void c_getPresentForMembership() throws Exception {
    	gpolist.add(gpo);
        list.add(po);
    	assertEquals(list,new PresentForMembershipDataServiceImpl().getPresentForMembership());
    }

    @Test
    public void d_getPresentForMembership1() throws Exception {
        gpolist.add(gpo);
        list.add(po);
        assertEquals(list,new PresentForMembershipDataServiceImpl().getPresentForMembership(VIPGrade.GradeOne,1));
    }

}