package ui.loadingUI;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by julia98 on 2017/12/29.
 */
public class LoadingFXWin extends Stage {
    @FXML
    AnchorPane root;


    public LoadingFXWin() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/fxml/loadingFXUI/LoadingFX.fxml"));
        Scene scene = new Scene(root,1200,800);
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
        			Platform.runLater(() -> {
                        try {
                            root.getScene().getWindow().hide();
                        } catch (Exception e) {
                            e.printStackTrace();
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

