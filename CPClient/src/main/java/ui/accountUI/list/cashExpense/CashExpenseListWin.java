package ui.accountUI.list.cashExpense;

import java.io.IOException;

import VO.accountVO.CashExpenseListVO;
import blservice.serviceFactory.AccountBLFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CashExpenseListWin extends Stage{
	@FXML
	AnchorPane root;
	public CashExpenseListWin(CashExpenseListWinController controller) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/accountUI/CashExpenseList.fxml"));
		loader.setController(controller);
		controller.setService(AccountBLFactory.getCashExpenseListService());
		root = loader.load();
		controller.init();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/forms/Forms.css").toExternalForm());
		scene.setFill(Color.TRANSPARENT);
		this.setScene(scene);
		this.initStyle(StageStyle.DECORATED);
		this.show();
	}
	
	public CashExpenseListWin(String listId) throws IOException{
		this(new CashExpenseListWinApproveController((CashExpenseListVO)AccountBLFactory.getCashExpenseListService().getList(listId)));
	}
}
