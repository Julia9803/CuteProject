package ui.loadingUI;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by julia98 on 2017/12/28.
 */
public class Loading extends Application {
    private Scene scene;

    @Override
    public void start(Stage stage) {
        // create the scene
        stage.setTitle("Cute Project");
        scene = new Scene(new Browser(),800,600, Color.web("rgba(0,0,0,0.5)"));
       scene.setFill(null);
      // Stage stageOwner = null;
	//stage.initOwner(stageOwner);
        stage.setScene(scene);
        stage.setResizable(false);
       
      
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
/*
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
                if(stage.isShowing()) {
                    Platform.runLater(() -> {
                        try {
                            stage.close();

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
        thread.start();*/
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
        String url = getClass().getResource("/html/colorfulPulse.html").toExternalForm();
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
        return 800;
    }

    @Override protected double computePrefHeight(double width) {
        return 600;
    }
}
