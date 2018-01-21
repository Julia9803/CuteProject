package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import network.ServerConnector;
import ui.mainUI.loginUI.LoginWin;


public class Welcome extends Application {
    private Scene scene;
    
    @Override 
    public void start(Stage stage) {
        // create the scene
        stage.setTitle("Cute Project");
        scene = new Scene(new Browser(),600,400, Color.web("#666970"));
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        //scene.getStylesheets().add("webviewsample/BrowserToolbar.css");        
        stage.show();
        
       Thread thread = new Thread(() -> {
        	try {
        		Thread.sleep(7000);
        		if(stage.isShowing()) {
        			Platform.runLater(new Runnable() {
        				@Override
						public void run() {
        					try {
        						stage.close();
        						new ServerConnector();
        						new LoginWin();

        						//new LoadingFXWin();
        					
        					} catch (Exception ex) {
        						ex.printStackTrace();
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

    public static void main(String[] args){
        launch(args);
    }
}

class Browser extends Region {

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public Browser() {
        //apply the styles
        getStyleClass().add("browser");
        // load the web page
        String url = getClass().getResource("/html/Try.html").toExternalForm();
        webEngine.load(url);
        //add the web view to the scene
        getChildren().add(browser);

    }
    
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }

    @Override protected double computePrefWidth(double height) {
        return 600;
    }

    @Override protected double computePrefHeight(double width) {
        return 400;
    }
}
