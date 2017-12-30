package ui.salesmanUI;

import java.io.IOException;
import java.util.List;

import VO.saleVO.SalesmanItemVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**     
* @author 李安迪
* @date 2017年12月26日
* @description
*/
public class GoodsSearchResultForSalesmanController {
	
	@FXML public AnchorPane root;
	@FXML public VBox vBox;
	@FXML public Label noticeLabel;
	@FXML public Button cancelBtn;
	@FXML public Button sureBtn;
	
	//存了一个SalesmanItemVO，但是展示的是goodsinsalevo
	private List<SalesmanItemVO> list;
	private List<GoodsSearchResultCellForSalesmanController> cellList;
//	private List<GoodsInSaleVO> returnList;
	private SalesmanListWinController parentController;
	/**
	 * @param goodsList
	 * @param parentController
	 */
	public GoodsSearchResultForSalesmanController(List<SalesmanItemVO> goodsList,
			SalesmanListWinController parentController) {
		// TODO Auto-generated constructor stub
		this.list = goodsList;
		this.parentController = parentController;
	}
	
	@FXML void initialize(){
		for(int i = 0 ; i < list.size() ; i++){
			SalesmanItemVO vo = list.get(i);
	   		 GoodsSearchResultCellForSalesmanController controller = 
	   				    new GoodsSearchResultCellForSalesmanController(vo);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        "/fxml/commonUI/GoodsSearchResultCell.fxml"));
	   				loader.setController(controller);
	   				HBox cell = null;
					try {
						cell = loader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
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
		for(GoodsSearchResultCellForSalesmanController controller: cellList){
			if(controller.checkBox.isSelected())
				parentController.addToList(controller.vo);
		}

		root.getScene().getWindow().hide();
	}

}
