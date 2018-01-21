package ui.commonUI.listUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.salesmanUI.stockReturnListUI.StockReturnWriteoffListController;

/**     
* @author 李安迪
* @date 2018年1月1日
* @description 红冲时新打开进货退货单的窗口
* 红冲未实现
*/
public class WriteoffStockReturnListWin extends Stage{

		@FXML AnchorPane root;
		
		public WriteoffStockReturnListWin(String id) throws IOException{
	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/salesmanUI/StockTypeList.fxml"));
			loader.setController(new StockReturnWriteoffListController(null,null,id));
			root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/managerUI/Manager.css").toExternalForm());
			scene.setFill(Color.TRANSPARENT);
		
			this.setScene(scene);
			this.initStyle(StageStyle.DECORATED);
			
			this.setFullScreen(true);
			this.show();
		} 

}
