package bl.storebl;

import java.util.LinkedList;

import VO.storeVO.AlarmListVO;

public class StoreTest {
DataGetter getter=new DataGetter();
DataSetter setter=new DataSetter();
StoreblController controller=new StoreblController();
	public static void main(String[] args) {
		// 控制台测试类->以后我会改成JUnit 单元测试，先测试一下这一千多行的正确性。
		StoreTest test=new StoreTest();
		LinkedList<AlarmListVO> lrr=new  LinkedList<AlarmListVO>();
		lrr=test.getter.getAllAlarmList();
		for(int i=0;i<lrr.size();i++){
		System.out.println(lrr.get(i).listID);
		System.out.println(lrr.get(i).goodsID);
		System.out.println(lrr.get(i).goodsName);
		System.out.println("----------");
		}
		/*
		 * 简单测了几个，应该都是对的。
		 * 想分支覆盖的话还得靠单元测试
		 */

	}

}
