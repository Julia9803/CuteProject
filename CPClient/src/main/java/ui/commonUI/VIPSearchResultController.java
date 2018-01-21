package ui.commonUI;

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

/**     
*
*/
public class VIPSearchResultController {
	@FXML public AnchorPane root;
	@FXML public VBox vBox;
	@FXML public Label noticeLabel;
	@FXML public Button cancelBtn;
	@FXML public Button sureBtn;
	

	private List<VIPVO> list;
	List<VIPSearchResultCellController> cellList;

	private VIPSearcher vipSearcher;

	
	public VIPSearchResultController(List<VIPVO> VIPList,
			VIPSearcher vipSearcher) {

		this.list = VIPList;
		this.vipSearcher = vipSearcher;
		this.cellList = new ArrayList<>();
	}
	
	@FXML void initialize(){
		for(int i = 0 ; i < list.size() ; i++){
			VIPVO vo = list.get(i);
	   		VIPSearchResultCellController controller = new VIPSearchResultCellController(vo,this);
	   		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/commonUI/VIPSearchResultCell.fxml"));
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
				vipSearcher.VIPSelected(controller.vo);
				break;
			}
		}

		root.getScene().getWindow().hide();
	}
}
