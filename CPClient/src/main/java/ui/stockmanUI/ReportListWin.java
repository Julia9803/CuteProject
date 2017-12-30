package ui.stockmanUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ReportListWin  extends Stage{
	@FXML
    AnchorPane root;
	ReportListController controller;
	 public ReportListWin() throws IOException {
	    	FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/stockmanUI/ReportList.fxml"));
	        root =loader.load();
	        this.controller=loader.getController();
	        Scene scene = new Scene(root);
//	        scene.getStylesheets().add(getClass().getResource("/css/stockmanUI/Stock.css").toExternalForm());
//	        scene.setFill(Color.TRANSPARENT);
	    
	        this.setScene(scene);
//	        this.initStyle(StageStyle.UNDECORATED);
	        
	        this.show();
	    }
}
