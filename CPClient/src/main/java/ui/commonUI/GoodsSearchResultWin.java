package ui.commonUI;

import java.io.IOException;
import java.util.List;

import VO.GoodsInSaleVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.managerUI.PresentForSumController;
import ui.managerUI.SinglePresentEditableController;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description 
*/
public class GoodsSearchResultWin extends Stage{
	@FXML AnchorPane root;
	
	public GoodsSearchResultWin(List<GoodsInSaleVO> goodsList,SinglePresentEditableController presentForSumController) throws IOException{
		
		try {
	   		 GoodsSearchResultController controller = 
	   				    new GoodsSearchResultController(goodsList,presentForSumController);
	   		 System.out.println(controller);
	   		 FXMLLoader loader = new FXMLLoader(
	   				    getClass().getResource(
	   				        "/fxml/commonUI/SearchResult.fxml"));
	   		 System.out.println(loader);
	   				loader.setController(controller);
	   				root = loader.load();
	   				assert(root != null);
	   				if(root == null)
	   				System.out.println("root is null");
			} catch (Exception e) {
				e.printStackTrace();
			}

		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
	
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		
		//设置总是在上和不可改变大小
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.show();
	}
}
