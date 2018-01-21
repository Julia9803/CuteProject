package ui.salesmanUI;



import java.io.IOException;
import java.util.List;

import VO.saleVO.SalesmanItemVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**     
* @author 李安迪
* @date 2017年12月14日
* @description 
*/
public class GoodsSearchResultForSalesmanWin extends Stage{
	@FXML AnchorPane root;
	
	public GoodsSearchResultForSalesmanWin(List<SalesmanItemVO> goodsList,SalesmanListWinController parentController) throws IOException{
		
		try {
	   		 GoodsSearchResultForSalesmanController controller = 
	   				    new GoodsSearchResultForSalesmanController(goodsList,parentController);
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
