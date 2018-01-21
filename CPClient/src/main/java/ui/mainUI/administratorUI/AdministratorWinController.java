package ui.mainUI.administratorUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.AdministratorUI.NewUserWinController;
import ui.AdministratorUI.UserTreeTable;
import ui.commonUI.ParentController;

public class AdministratorWinController implements ParentController{

	@FXML AnchorPane root;
	@FXML BorderPane centerPane;
	
	private static final String USER_INFOMATION_FXML = "/fxml/administratorUI/userInformation.fxml";

	@FXML public void onNewUserBtnClicked() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(USER_INFOMATION_FXML));
			
			NewUserWinController controller = new NewUserWinController();
			loader.setController(controller);
			AnchorPane ListRoot = loader.load();
			controller.setParentController(this);
			
			
			this.CloseSonWin();
			centerPane.setCenter(ListRoot);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@FXML public void onManageUserBtnClicked() {
		
		UserTreeTable table =new UserTreeTable();
		Stage stage=new Stage();
		table.start(stage);
	}

	
	@Override
	public void CloseSonWin() {
		centerPane.setCenter(null);
		
	}

}
