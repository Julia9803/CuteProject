package ui.managerUI;

import java.util.Date;
import java.util.List;

import VO.GoodsInSaleVO;
import VO.presentVO.PresentForMembershipVO;
import VO.presentVO.PresentVO;
import javafx.scene.control.TextField;
import resultmessage.DataRM;
import util.DateUtil;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public class PresentForMembershipCellStrategy implements Strategy{

	/* (non-Javadoc)
	 * @see ui.managerUI.Strategy#initData(ui.managerUI.SinglePresentController)
	 */
	@Override
	public void initData(SinglePresentController controller,PresentVO vo) {
		// TODO Auto-generated method stub
		
		System.out.println("init data in present for Membership cell");
		
		PresentForMembershipCellController MembershipController = (PresentForMembershipCellController)controller;
		PresentForMembershipVO MembershipVO = (PresentForMembershipVO)vo;
		//解析vo
		MembershipController.setId(MembershipVO.getId());
		Date startTime = MembershipVO.getStartTime();
		Date finishTime = MembershipVO.getFinishTime();
		double total = MembershipVO.getSum();
		double voucher = MembershipVO.getVoucher();
		double rebate = MembershipVO.getRebateInPresentForMembership();
		List<GoodsInSaleVO> presentList = MembershipVO.getPresentList();
		
		//显示数据
	    MembershipController.startYearField.setText(DateUtil.getYear(startTime)+"");
	    MembershipController.startMonthField.setText(DateUtil.getMonth(startTime)+"");
	    MembershipController.startDayField.setText(DateUtil.getDay(startTime)+"");
	    MembershipController.finishYearField.setText(DateUtil.getYear(finishTime)+"");
	    MembershipController.finishMonthField.setText(DateUtil.getMonth(finishTime)+"");
	    MembershipController.finishDayField.setText(DateUtil.getDay(finishTime)+"");
	    MembershipController.totalField.setText(total+"");
	    MembershipController.voucherField.setText(voucher+"");
	    MembershipController.rebateField.setText(rebate+"");
	    
	    MembershipController.gradeChoiceBox.setValue(MembershipVO.getGrade().getGrade()+"");
	    for(TextField f:MembershipController.textFieldList){
	    	f.setStyle("-fx-background-color: #FFECEC");
	    	System.out.println(f.getText());
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
