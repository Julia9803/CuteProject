package ui.commonUI;

import java.io.IOException;
import java.util.List;

import VO.VIPVO.VIPVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**     
* VIP查询结果的窗口
*/
public class VIPSearchResultWin extends Stage{
	@FXML AnchorPane root;
	
	public VIPSearchResultWin(List<VIPVO> vipList,VIPSearcher vipSearcher) throws IOException{
		
		try {
	   	    VIPSearchResultController controller = new VIPSearchResultController(vipList,vipSearcher);
	   		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/commonUI/SearchResult.fxml"));
	   		loader.setController(controller);
	   		root = loader.load();
	   		
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
