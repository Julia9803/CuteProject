package ui.loadingUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Created by julia98 on 2017/12/29.
 */
public class LoadingFXController {
	@FXML public AnchorPane root;
    @FXML public Label loadingTxt;
    public String message;
    public boolean isClosed = false;
    
    public void close() {
    	isClosed = true;
    }

    @FXML public void initialize() {
    	   // loadingTxt.setText(message);
    	    init();
    }
    public void setLoadingTxt(String message) {
        this.message = message;
        loadingTxt.setText(message);
    }
    
    public void init() {
    Thread thread = new Thread(() -> {
    	try {
    		Thread.sleep(1000);
    		while(root.getScene().getWindow().isShowing()) {
    			if(isClosed == true)
    				root.getScene().getWindow().hide();
    		}
    //		root.getScene().getWindow().hide();
    	} catch(Exception e) {
    		e.printStackTrace();
    	    }
   });
    thread.setDaemon(true);
    thread.start();
    }
}
