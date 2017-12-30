package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import network.ServerConnector;


public class Main extends Application {

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{

		Platform.runLater(()-> {
				try {
					ServerConnector s = new ServerConnector();
//					new Welcome();
					//new LoginWin();
//					new ui.salesmanUI.SalesmanWin();
					//new ui.stockmanUI.StockmanWin();
//					new ui.managerUI.LookListWin();
					new ui.mainUI.accountantUI.AccountantWin();
					//new ui.stockmanUI.StockmanWin();
//					new ui.managerUI.ManagerWin();
					//new ui.stockmanUI.GoodsWin();
//					new ui.salesmanUI.VIPWin();


				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}
}
