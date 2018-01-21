package ui.commonUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VO.GoodsInSaleVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ui.managerUI.SinglePresentEditableController;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description
*/
public class GoodsSearchResultController {
	@FXML public AnchorPane root;
	@FXML public VBox vBox;
	@FXML public Label noticeLabel;
	@FXML public Button cancelBtn;
	@FXML public Button sureBtn;
	
	private List<GoodsInSaleVO> list;
	private List<GoodsSearchResultCellController> cellList;
//	private List<GoodsInSaleVO> returnList;
	private SinglePresentEditableController singlePresentEditableController;
	
	public GoodsSearchResultController(List<GoodsInSaleVO> list,SinglePresentEditableController controller){
		this.list = list;
		this.singlePresentEditableController = controller;
		this.cellList = new ArrayList<GoodsSearchResultCellController>();
	}
	@FXML void initialize(){
		for(GoodsInSaleVO i : list){
			
	   		 GoodsSearchResultCellController controller = 
	   				    new GoodsSearchResultCellController(i);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        "/fxml/commonUI/GoodsSearchResultCell.fxml"));
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
		for(GoodsSearchResultCellController controller: cellList){
			if(controller.checkBox.isSelected()){
				String id = controller.id.getText();
				String name = controller.name.getText();
				int amount = 1;
				try{
					amount = Integer.parseInt(controller.amountTextField.getText());
				}catch(Exception e){
					try {
						new PromptWin("数字格式错误");
						System.out.println("错误哦");
					} catch (IOException e1) {
						// TODO promptwin是否可用？	re:1、这个异常不知道什么时候会出现 2、递归抛异常恐怕用不了了
						e1.printStackTrace();
					}
				}
				singlePresentEditableController.addToPresentList(new GoodsInSaleVO(id,name,amount));
			}
		}

		root.getScene().getWindow().hide();
	}
}
