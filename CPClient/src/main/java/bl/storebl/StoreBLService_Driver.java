/*package bl.storebl;

import java.util.Map;
import java.util.Set;

import VO.StoreVO;
import VO.StoreViewVO;
import VO.goodsVO.GoodsVO;
import blservice.storeblservice.StoreBLService;
import util.ListType;
import util.ResultMessage;

public class StoreBLService_Driver {
	public void drive(StoreBLService storeBLService){
		
		
		
		
		String s = storeBLService.createList(null);
		if(s == "0001") {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}	
		
		Map<ListType,String> m1= storeBLService.openDraftList();
		if(m1 != null){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
		
		Map<String,String> m2 = storeBLService.findGoods(null, null);
		if(m2 != null){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
		
		StoreListVO storelist = storeBLService.openList(null, null);
		if(storelist != null){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
		
		ResultMessage m = storeBLService.commitList(null, null);
		if(m == ResultMessage.SUCCESS){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
		
		m = storeBLService.saveList(null,null);
		if(m == ResultMessage.SUCCESS){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
		
		m = storeBLService.setAlert(null);
		if(m == ResultMessage.SUCCESS){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
		
		GoodsVO goods= storeBLService.getGoods(null);
		if(goods != null){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
		
		if(storeBLService.getLossNumber(0) == 0){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
		
		if(storeBLService.getOverflowNumber(0) == 0){
			System.out.println("Success!");
			}else {
				System.out.println("Fail!");
		}
	
	
	if(storeBLService.getStoreNumber("") == 0){
		System.out.println("Success!");
		}else {
			System.out.println("Fail!");
	}
	
	StoreViewVO sv = storeBLService.view(null,null,null);
	if(sv != null){
		System.out.println("Success!");
		}else {
			System.out.println("Fail!");
	}
	
	Set<StoreVO> vo = storeBLService.check();
	if(vo != null){
		System.out.println("Success!");
		}else {
			System.out.println("Fail!");
	}
	}
	
	
}*/
