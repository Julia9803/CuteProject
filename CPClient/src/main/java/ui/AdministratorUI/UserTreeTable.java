package ui.AdministratorUI;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import VO.userVO.UserVO;
import bl.userbl.AdministratorServiceImpl;
import blservice.userblservice.AdministratorService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class UserTreeTable {
	ObservableList<T> Obs= FXCollections.observableArrayList();
	ArrayList<String> S0=new ArrayList<String>();
	
	AdministratorService service=new AdministratorServiceImpl();
	

		
	private void btnAction1(String s0){
		try {
			service.delete(s0);
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
		System.out.println("删除成功");
	}

	 private final class T extends RecursiveTreeObject<T>{
		  StringProperty p1;
		  StringProperty p2;

		  
		  public T (String p1,String p2){
			  this.p1=new SimpleStringProperty (p1);
			  this.p2=new SimpleStringProperty (p2);

			  
		  }
		  
	}

	public void start(Stage primaryStage) {
		S0.add("用户名");
	    S0.add("用户密码");
	    
	       ArrayList<T> userInfo=new ArrayList<T>();
	       
	       ArrayList <UserVO> voArr=(ArrayList<UserVO>) service.getAllUser();
	       for(UserVO vo:voArr){
	    	   userInfo.add(new T(vo.getName(),vo.getPassword()));
	       }
		    Obs.addAll(userInfo);

		ArrayList<JFXTreeTableColumn<T,String>> A0=new ArrayList<JFXTreeTableColumn<T,String>>();
		for(int i=0;i<S0.size();i++){
			A0.add(new JFXTreeTableColumn<>(S0.get(i)));
			}
		for(int i=0;i<A0.size();i++){
			A0.get(i).setPrefWidth(150);


			A0.get(i).setCellFactory((TreeTableColumn<T, String> param)-> new GenericEditableTreeTableCell<>(
		            new TextFieldEditorBuilder()));;
		}
		
		A0.get(0).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p1;});
		A0.get(1).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p2;});

		
        final TreeItem<T> root=new RecursiveTreeItem<>(Obs, RecursiveTreeObject::getChildren); ;

        JFXTreeTableView<T> treeView = new JFXTreeTableView<T>(root);
        treeView.setShowRoot(false);
        treeView.setEditable(true);
       
        treeView.getColumns().setAll(A0);
    		FlowPane main = new FlowPane();
            main.setPadding(new Insets(10));
            main.getChildren().add(treeView);

    		
    		JFXTextField textfield=new JFXTextField();
    		main.getChildren().add(textfield);
    		treeView.getSelectionModel().selectedIndexProperty().addListener(
    				(action)->textfield.setText(voArr.get(treeView.getSelectionModel().getSelectedIndex()).getName()));
    		
    		JFXButton okbtn = new JFXButton("删除用户");
    		okbtn.setOnAction((action)->btnAction1(textfield.getText()));
    		main.getChildren().add(okbtn);
    		
    		
    		


	    
	
		
		Scene scene = new Scene(main, 425, 500);
		
        primaryStage.setScene(scene);
        primaryStage.setTitle("用户管理");
        primaryStage.show();
		
	}
	

}
 


	
