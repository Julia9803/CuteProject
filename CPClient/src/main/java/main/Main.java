package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import network.ServerConnector;
import ui.mainUI.loginUI.LoginWin;


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
					new ServerConnector();
					new LoginWin();
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}
}
