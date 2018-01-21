package ui.mainUI.message;

import java.io.IOException;
import java.util.List;

import VO.userVO.MessageVO;
import blservice.serviceFactory.MessageServiceFactory;
import blservice.userblservice.CheckMessageService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ui.mainUI.loginUI.User;

public class MessageWinController {
	
	@FXML AnchorPane root;
	
	@FXML VBox vBox;
	@FXML Button closeBtn;
	
	CheckMessageService service = MessageServiceFactory.getCheckMessageService();
	
	@FXML 
	public void initialize(){
		List<MessageVO> messageList = service.checkMessage(User.getInstance().getUserType());
		for(MessageVO vo : messageList){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainUI/MessagePane.fxml"));
			MessagePaneController controller = new MessagePaneController(vo);
			loader.setController(controller);
			try {
				Pane messageRoot = loader.load();
				vBox.getChildren().add(messageRoot);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		vBox.setSpacing(20);
	}
	
	@FXML public void onCloseBtnClicked() {
		Platform.runLater(()-> {
            try {
                root.getScene().getWindow().hide();
            } catch (Exception e) {
                e.printStackTrace();
            }
    });
	}
	
}
