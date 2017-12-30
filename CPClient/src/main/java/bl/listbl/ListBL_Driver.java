/*package bl.listbl;

import java.util.ArrayList;
import java.util.Date;

import VO.ListVO;
import VO.listVO.BusinessProcessConditionVO;
import VO.saleVO.BusinessCircumVO;
import VO.saleVO.SaleDetailConditionVO;
import javafx.beans.property.SimpleObjectProperty;
import util.ListType;

public class ListBL_Driver {
	ArrayList list = new ArrayList();
	
	SaleDetailConditionVO saleDataConditionVO = new SaleDetailConditionVO();
	BusinessCircumVO businessCircumVO = new BusinessCircumVO();
	BusinessProcessConditionVO businessProcessConditionVO = new BusinessProcessConditionVO();
	
	ListVO listVO = new ListVO();
//	final ThreadLocal<SimpleObjectProperty<ListType>> type = ThreadLocal.withInitial(() -> new SimpleObjectProperty<>(this, "type", new ListType()));
	
	Date beginTime = new Date();
	Date endTime = new Date();
	String id = "000001";
	boolean a = false;
	
	ListBL_Stub listBL_Stub = new ListBL_Stub();
	
	public void dirve() {
		//1
		list = listBL_Stub.checkList();
		if(list != null) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		//2
		list = listBL_Stub.checkSaleDetailForm(saleDataConditionVO);
		if(list != null) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		//3
//		listVO = listBL_Stub.getSpecificList(type.get().get(), id);
		if(listVO != null) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		//4
//		a = listBL_Stub.hongchong(type.get().get(), id);
		if(a) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		//5
//		String tmp = listBL_Stub.hongchongAndCopy(type.get().get(), id);
		if(tmp != null) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		//6
		businessCircumVO = listBL_Stub.checkBusinessCircumForm(beginTime, endTime);
		if(businessCircumVO != null) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		//7
		a = listBL_Stub.approvalList(type.get().get(), id, listVO);
		if(a) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		//8
		list = listBL_Stub.checkBusinessProcessForm(businessProcessConditionVO);
		if(list != null) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}		
	}
}*/
