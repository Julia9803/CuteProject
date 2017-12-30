package dataService.listDataService;

import java.util.ArrayList;

import PO.InfoListPO;
import util.GreatListType;

public class ListDataService_Stub implements ListDataService {

	@Override
	public void addInfoList(InfoListPO po) {
		System.out.println("调用成功！");
		
	}

	@Override
	public void removeInfoList(String id) {
		System.out.println("调用成功！");
		
	}

	@Override
	public void changeToApproved(String id) {
		System.out.println("调用成功！");
		
	}

	@Override
	public ArrayList<InfoListPO> openInfoList() {
		InfoListPO po1=new InfoListPO("G000001", GreatListType.LOSS, "小华", "小熊维尼 报损7个");
		InfoListPO po2=new InfoListPO("P000001", GreatListType.PRESENT, "小华", "赠送给尊贵的VIP李安迪  小狗道吉4个  小猪佩奇6个");
		InfoListPO po3=new InfoListPO("G000001", GreatListType.SALE, "小张", "卖给:小华 小猪佩奇4个 总价500元 折让325元");
		ArrayList<InfoListPO> arr =new ArrayList<InfoListPO>();
		arr.add(po1);
		arr.add(po2);
		arr.add(po3);
		return arr;
	}

	@Override
	public ArrayList<InfoListPO> openApproved() {
		InfoListPO po1=new InfoListPO("G000001", GreatListType.LOSS, "小华", "小熊维尼 报损7个");
		InfoListPO po2=new InfoListPO("P000001", GreatListType.PRESENT, "小华", "赠送给尊贵的VIP李安迪  小狗道吉4个  小猪佩奇6个");
		InfoListPO po3=new InfoListPO("G000001", GreatListType.SALE, "小张", "卖给->小华 小猪佩奇4个 总价500元 折让325元");
		ArrayList<InfoListPO> arr =new ArrayList<InfoListPO>();
		arr.add(po1);
		arr.add(po2);
		arr.add(po3);
		return arr;
	}

}
