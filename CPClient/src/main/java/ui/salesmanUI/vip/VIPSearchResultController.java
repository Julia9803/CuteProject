package ui.salesmanUI.vip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.VIPVO.VIPVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ui.salesmanUI.SalesmanListWinController;

/**     
* @author 李安迪
* @date 2017年12月27日
* @description
*/
public class VIPSearchResultController {
	@FXML public AnchorPane root;
	@FXML public VBox vBox;
	@FXML public Label noticeLabel;
	@FXML public Button cancelBtn;
	@FXML public Button sureBtn;
	

	private List<VIPVO> list;
	List<VIPSearchResultCellController> cellList;

	private SalesmanListWinController parentController;

	
	public VIPSearchResultController(List<VIPVO> VIPList,
			SalesmanListWinController parentController) {

		this.list = VIPList;
		this.parentController = parentController;
		this.cellList = new ArrayList<>();
	}
	
	@FXML void initialize(){
		for(int i = 0 ; i < list.size() ; i++){
			VIPVO vo = list.get(i);
	   		 VIPSearchResultCellController controller = 
	   				    new VIPSearchResultCellController(vo,this);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        "/fxml/salesmanUI/VIPSearchResultCell.fxml"));
	   				loader.setController(controller);
	   				HBox cell = null;
					try {
						cell = loader.load();
					} catch (IOException e) {
						e.printStackTrace();
					}
	   		cellList.add(controller);		
			vBox.getChildren().add(cell);
		}
		
	}
	
	@FXML public void onCancelBtnClicked(){
		root.getScene().getWindow().hide();
	}
	
	@FXML public void onSureBtnClicked(){
		for(VIPSearchResultCellController controller: cellList){
			if(controller.checkBox.isSelected()){
				parentController.setVIP(controller.vo);
				break;
			}
		}

		root.getScene().getWindow().hide();
	}
}
