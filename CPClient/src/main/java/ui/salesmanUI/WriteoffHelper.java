package ui.salesmanUI;

import java.util.ArrayList;
import java.util.List;

import VO.saleVO.SalesmanItemVO;

/**     
* @author 李安迪
* @date 2018年1月7日
* @description
*/
public class WriteoffHelper {

	/**
	 * @param chosenList
	 * @return
	 */
	public static List<SalesmanItemVO> getMinus(List<SalesmanItemVO> chosenList) {
		
		List<SalesmanItemVO> returnList = new ArrayList<SalesmanItemVO>();
		
		if(chosenList == null)
			return null;
		
		for(SalesmanItemVO i : chosenList){
			returnList.add(new SalesmanItemVO(i.getId(),i.getName(),i.getType(),i.getPrice(),-i.getAmount(),-i.getSum(),i.getNotes()));
		}
		return returnList;
	}

}
