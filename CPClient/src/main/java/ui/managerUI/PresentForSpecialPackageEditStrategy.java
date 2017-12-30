package ui.managerUI;

import java.util.Date;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSpecialPackageVO;
import VO.presentVO.PresentVO;
import javafx.scene.control.TextField;
import resultmessage.DataRM;
import util.DateUtil;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public class PresentForSpecialPackageEditStrategy implements Strategy{

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#initData(ui.managerUI.SinglePresentController)
	 */
	@Override
	public void initData(SinglePresentController controller,PresentVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("init data");
		
		PresentForSpecialPackageController SpecialPackageController = (PresentForSpecialPackageController)controller;
		PresentForSpecialPackageVO SpecialPackageVO = (PresentForSpecialPackageVO)vo;
		
		System.out.println(SpecialPackageVO.getId());
		//解析vo
		SpecialPackageController.setId(SpecialPackageVO.getId());
		Date startTime = SpecialPackageVO.getStartTime();
		Date finishTime = SpecialPackageVO.getFinishTime();
		double rebate = SpecialPackageVO.getPriceReduction();
		List<GoodsInSaleVO> presentList = SpecialPackageVO.getPresentList();
		
		//显示数据
	    SpecialPackageController.startYearField.setText(DateUtil.getYear(startTime)+"");
	    SpecialPackageController.startMonthField.setText(DateUtil.getMonth(startTime)+"");
	    SpecialPackageController.startDayField.setText(DateUtil.getDay(startTime)+"");
	    SpecialPackageController.finishYearField.setText(DateUtil.getYear(finishTime)+"");
	    SpecialPackageController.finishMonthField.setText(DateUtil.getMonth(finishTime)+"");
	    SpecialPackageController.finishDayField.setText(DateUtil.getDay(finishTime)+"");
	    SpecialPackageController.rebateField.setText(rebate+"");
	    
	    for(TextField f:SpecialPackageController.textFieldList){
	    	f.setStyle("-fx-background-color: #FFECEC");
	    }
        
        //显示赠品列表
	    controller.setPresentList(presentList);
	}

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#cancel(ui.managerUI.SinglePresentController)
	 */
	@Override
	public DataRM cancel(SinglePresentEditableController controller) {
		// TODO Auto-generated method stub
		return DataRM.SUCCESS;
	}

}
