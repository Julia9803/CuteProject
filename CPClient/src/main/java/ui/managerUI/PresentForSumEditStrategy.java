package ui.managerUI;

import java.util.Date;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForSumVO;
import VO.presentVO.PresentVO;
import javafx.scene.control.TextField;
import resultmessage.DataRM;
import util.DateUtil;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public class PresentForSumEditStrategy implements Strategy{

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#initData(ui.managerUI.SinglePresentController)
	 */
	@Override
	public void initData(SinglePresentController controller,PresentVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("init data");
		
		PresentForSumController sumController = (PresentForSumController)controller;
		PresentForSumVO sumVO = (PresentForSumVO)vo;
		
		System.out.println(sumVO.getId());
		//解析vo
		sumController.setId(sumVO.getId());
		Date startTime = sumVO.getStartTime();
		Date finishTime = sumVO.getFinishTime();
		double total = sumVO.getTotal();
		double voucher = sumVO.getVoucher();
		List<GoodsInSaleVO> presentList = sumVO.getPresentList();
		
		//显示数据
	    sumController.startYearField.setText(DateUtil.getYear(startTime)+"");
	    sumController.startMonthField.setText(DateUtil.getMonth(startTime)+"");
	    sumController.startDayField.setText(DateUtil.getDay(startTime)+"");
	    sumController.finishYearField.setText(DateUtil.getYear(finishTime)+"");
	    sumController.finishMonthField.setText(DateUtil.getMonth(finishTime)+"");
	    sumController.finishDayField.setText(DateUtil.getDay(finishTime)+"");
	    sumController.totalField.setText(total+"");
	    sumController.voucherField.setText(voucher+"");
	    
	    for(TextField f:sumController.textFieldList){
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
