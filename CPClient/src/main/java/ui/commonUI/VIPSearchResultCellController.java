package ui.commonUI;

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
	
	private VIPSearchResultController parentController;
	
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
		this.vo = vo;
		this.parentController = vipSearchResultController;
	}

	@FXML
	public void onSelected(){
		for(VIPSearchResultCellController cellController: this.parentController.cellList){
			if(cellController.checkBox.isSelected() && (!cellController.checkBox.equals(this.checkBox))){
				cellController.checkBox.setSelected(false);
			}
		}


	}
}
