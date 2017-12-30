package ui.commonUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public abstract class ListWinController implements SonController{
	protected ParentController parentController;
	

	@FXML protected Label listID;
	@FXML protected Label operator;
	

	public void setParentController(ParentController controller){
		parentController = controller;
	};
	
	public void setListID(String id){
		listID.setText(id);
	}
	
	public void setOperator(String name){
		operator.setText(name);
	}
	
	//不用fxml注入的initialize方法，因为那个会在加载fxml时就调用
	public abstract void init();
}
