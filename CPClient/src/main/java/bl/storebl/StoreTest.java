package bl.storebl;

import VO.storeVO.StoreVO;
import network.ServerConnector;

public class StoreTest {
DataGetter getter=new DataGetter();
DataSetter setter=new DataSetter();
StoreblController controller=new StoreblController();
	public static void main(String[] args) {
		ServerConnector sc=new ServerConnector();
		StoreTest test=new StoreTest();
            StoreVO vo=new StoreVO("测试_小狗道吉","G1",20,95);
            vo.averagePrice=45;
            test.setter.insertStoreVO(vo);
	}

}
