package ui.salesmanUI.vip;

import VO.VIPVO.VIPVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**     
* @author 李安迪
* @date 2017年12月27日
* @description
*/
public class VIPSearchResultCellController {
	VIPVO vo;

	@FXML public Label id;
	@FXML public Label name;
	@FXML public Label grade;
	@FXML public RadioButton checkBox;
	
	private VIPSearchResultController controller;
	
	@FXML
	void initialize(){
		id.setText(vo.getId()+"");
		name.setText(vo.getName()+"");
		grade.setText(vo.getGrade()+"");
	}
	/**
	 * @param vo
	 * @param vipSearchResultController 
	 */
	public VIPSearchResultCellController(VIPVO vo, VIPSearchResultController vipSearchResultController) {
		// TODO Auto-generated constructor stub
		this.vo = vo;
		this.controller = vipSearchResultController;
	}

	@FXML
	public void onSelected(){
		for(VIPSearchResultCellController controller: this.controller.cellList){
			if(controller.checkBox.isSelected() && (!controller.checkBox.equals(this.checkBox))){
				//TODO 检查这个checkbox是不是能由equals识别
				controller.checkBox.setSelected(false);
			}
		}


	}
}
