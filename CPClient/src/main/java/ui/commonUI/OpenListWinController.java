package ui.commonUI;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * 
 * 打开单据列表的通用界面{fxml/commonUI/OpenListOfForms.fxml}
 * 此类为通用的controller，各个子界面的controller继承此界面，再加载BriefList（含有list简要信息的一个pane）的fxml就行了
 * 需要注意的是，加载通用界面时需要自行设置controller（不是这个类，是各个单据的子类的controller）
 * @author zxy
 *
 */
public abstract class OpenListWinController implements SonController{
	ParentController ParentController;
	
	@FXML protected VBox vBox;
	@FXML protected AnchorPane root;
	@FXML protected Label title;
	@FXML protected TextField searchTextField;
	@FXML protected Button searchBtn;
	
	@Override
	public void setParentController(ParentController controller) {
		ParentController = controller;
	}
	
	public void setTitle(String title){
		this.title.setText(title);
	}
	
	@FXML
	public abstract void onSearchBtnClicked();
	
	public abstract void init();
	
}
