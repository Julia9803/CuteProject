package ui.loadingUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import network.ServerConnector;

import java.io.IOException;

/**
 * Created by julia98 on 2017/12/29.
 */
public class LoadingFXWin extends Stage {
    @FXML
    AnchorPane root;


    public LoadingFXWin() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/loadingFXUI/LoadingFX.fxml"));
        Scene scene = new Scene(root,1200,800);
        //scene.getStylesheets().add(getClass().getResource("/css/mainUI/Login.css").toExternalForm());
        scene.setFill(null);
        this.setScene(scene);
        this.initStyle(StageStyle.UNDECORATED);
        this.initStyle(StageStyle.TRANSPARENT);
        this.initModality(Modality.APPLICATION_MODAL);
        //this.initOwner(owner);
        this.show();
        Thread thread = new Thread(() -> {
        	try {
        		Thread.sleep(3000);
        		if(this.isShowing()) {
        			Platform.runLater(new Runnable() {
        				public void run() {
        					try {
        					    root.getScene().getWindow().hide();        						
        						//ServerConnector s = new ServerConnector();
        						//new ui.salesmanUI.VIPWin();
        						new ui.stockmanUI.StockmanWin();
        						
        					} catch (Exception e) {
        						e.printStackTrace();
        					}
        				}
        			});
        		}
        	} catch(Exception e) {
        		e.printStackTrace();
        	    }
        });
        thread.setDaemon(true);
        thread.start();   
    }
}

