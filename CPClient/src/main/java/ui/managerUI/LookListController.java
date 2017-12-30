package ui.managerUI;

import java.io.IOException;
import java.util.ArrayList;

import VO.listVO.InfoListVO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import util.GreatListType;

public class LookListController {
    @FXML public Button filter;
    @FXML public Button approve;
    @FXML public ScrollPane scrollpane;
    @FXML public ComboBox<String> combobox;
    @FXML public VBox infoList_VBox;
    
    public  ArrayList<InfoListVO> al=new  ArrayList<InfoListVO>();
    
    @FXML public void onApprove(){
    	
    }
    @FXML public void onFilter(){
    	
    }
    
    @FXML private void initialize(){
    	al.add(new InfoListVO("kkkk", GreatListType.OVERFLOW, "KKK", "kkk"));
    	al.add(new InfoListVO("mmmm", GreatListType.OVERFLOW, "mmm", "MMM"));
    	//al.add(new InfoListVO("mmmm", GreatListType.OVERFLOW, "mmm", "MMM"));
    	al.add(new InfoListVO("mmmm", GreatListType.OVERFLOW, "mmm", "MMM"));
    	al.add(new InfoListVO("mmmm", GreatListType.OVERFLOW, "mmm", "MMM"));
    	al.add(new InfoListVO("mmmm", GreatListType.OVERFLOW, "mmm", "MMM"));
    	scrollpane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
    	for(int i=0;i<al.size();i++){
    		try {
				AnchorPane goodsroot = FXMLLoader.load(getClass().getResource("/fxml/managerUI/ListInfoItem.fxml"));
				infoList_VBox.getChildren().add(goodsroot);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    }
}
