package dataServiceImpl.VIPImpl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import PO.VIPPO;
import util.VIPUtil;

/**
 * Created by julia98 on 2017/12/27.
 */
public class VIPDataServiceImplTest {
	VIPPO po1 = new VIPPO("00000001"
            ,"供货商"
            ,"1"
            ,"姓名1"
            ,"18800000000"
            ,"123456789@qq.com"
            ,"地址1"
            ,"210046"
            ,100
            ,1000
            ,100
            ,"业务员1",VIPUtil.EXIST);
	
	VIPPO po2 = new VIPPO("00000002"
            ,"经销商"
            ,"2"
            ,"姓名2"
            ,"18800000002"
            ,"123456789@qq.com"
            ,"地址2"
            ,"210046"
            ,100
            ,1000
            ,100
            ,"业务员1",VIPUtil.EXIST);


    @Test
    public void newVIPID() throws Exception {
    	po2.setName("经销商" + 1);
       assertEquals("2",new VIPDataServiceImpl().newVIPID(po2));
    }

    @Test
    public void findVIP() throws Exception {
    	//assertEquals(po,new VIPDataServiceImpl().findVIP("", "name").get(0));
    }
//
//    @Test
//    public void getVIP() throws Exception {
//    	assertEquals(po,new VIPDataServiceImpl().getVIP("姓名2"));
//    }

    @Test
    public void deleteVIP() throws Exception {
    	//assertEquals(ResultMessage.SUCCESS,new VIPDataServiceImpl().deleteVIP("姓名2"));
    }

    @Test
    public void modifyVIP() throws Exception {
    	//VIPDataServiceImpl vipDataServiceImpl = new VIPDataServiceImpl();
    //VIPPO po = vipDataServiceImpl.getVIP("姓名1");
    //po.setClerk("业务员2");
    //assertEquals(ResultMessage.SUCCESS,new VIPDataServiceImpl().modifyVIP(po));
    }
}