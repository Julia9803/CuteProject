package ui.commonUI;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * 一个简易的提示窗
 * 只需创建一个对象就行
 * 参数为提示的内容
 * {displayTime}milliseconds之后会自动消失
 * 
 * @author zxy
 *
 */
public class PromptWin extends Stage{
	AnchorPane root;
	
	private static final long displayTime = 2000;
	
	public PromptWin(String promptText) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/commonUI/PromptWin.fxml"));
		PromptWinController controller = new PromptWinController();
		loader.setController(controller);
		root = loader.load();
		controller.setPromptText(promptText);
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
		closeLater();
	}
	
	private void closeLater(){
		new Timer().schedule(new TimerTask(){
			public void run(){
				Platform.runLater(new Runnable() {
			        @Override
			        public void run() {
			        	root.getScene().getWindow().hide();
			        }
			   });
				
			}
		}, displayTime);
	}
}
