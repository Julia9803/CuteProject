package ui.commonUI.listUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.salesmanUI.saleListUI.SaleWriteoffListController;

/**     
* @author 李安迪
* @date 2018年1月1日
* @description 红冲时新打开销售单的窗口
*/
public class WriteoffSaleListWin extends Stage{

		@FXML AnchorPane root;
		
		public WriteoffSaleListWin(String id) throws IOException{
	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/salesmanUI/SaleTypeList.fxml"));
			loader.setController(new SaleWriteoffListController(null,null,id));
			root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/managerUI/Manager.css").toExternalForm());
			scene.setFill(Color.TRANSPARENT);
		
			this.setScene(scene);
			this.initStyle(StageStyle.DECORATED);
			
	//		this.setFullScreen(true);
			this.show();
		} 

}