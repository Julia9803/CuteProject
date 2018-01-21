package ui.commonUI;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import ui.mainUI.loginUI.User;

public class SalesDetailsTreeTable extends Application{
	ObservableList<T> Obs= FXCollections.observableArrayList();
	ArrayList<String> S0=new ArrayList<String>();
	Label label;
	@Override
	public void start(Stage primaryStage)  {
	    S0.add("时间");
	    S0.add("商品名称");
	    S0.add("型号");
	    S0.add("数量");
	    S0.add("单价");
	    S0.add("总额");
	    S0.add("客户");
	    S0.add("操作员");

	    Obs.add(new T("2017","灯","1","30","20.25","500","Andy","Tony"));
	    
	    //------
	    
	    
		FlowPane main=addColumn();

		Scene scene = new Scene(main, 1250, 500);
		
        primaryStage.setScene(scene);
        primaryStage.setTitle("销售明细表");
        primaryStage.show();

	}

	
	public  FlowPane addColumn(){
		ArrayList<JFXTreeTableColumn<T,String>> A0=new ArrayList<JFXTreeTableColumn<T,String>>();
		for(int i=0;i<S0.size();i++){
			A0.add(new JFXTreeTableColumn<>(S0.get(i)));
			}
		for(int i=0;i<A0.size();i++){
			A0.get(i).setPrefWidth(150);
			//下一句话设置数据合法性，不知道要不要加。

			A0.get(i).setCellFactory((TreeTableColumn<T, String> param)-> new GenericEditableTreeTableCell<>(
		            new TextFieldEditorBuilder()));;
		}
		
		A0.get(0).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p1;});
		A0.get(1).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p2;});
		A0.get(2).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p3;});
		A0.get(3).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p4;});
		A0.get(4).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p5;});
		A0.get(5).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p6;});
		A0.get(6).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p7;});
		A0.get(7).setCellValueFactory((TreeTableColumn.CellDataFeatures<T, String> param) -> { return param.getValue().getValue().p8;});
		

		
        final TreeItem<T> root=new RecursiveTreeItem<>(Obs, RecursiveTreeObject::getChildren); ;

        JFXTreeTableView<T> treeView = new JFXTreeTableView<T>(root);
        treeView.setShowRoot(false);
        treeView.setEditable(true);
       
        treeView.getColumns().setAll(A0);
    		FlowPane main = new FlowPane();
            main.setPadding(new Insets(10));
            main.getChildren().add(treeView);
    	
    		
    		JFXButton okbtn = new JFXButton("导出报表");
    		okbtn.setOnAction((action)->btnAction1());
    		main.getChildren().add(okbtn);
    		
    		JFXTextField textfield=new JFXTextField();
    		textfield.setPrefWidth(250);
    		main.getChildren().add(textfield);
    		

    		textfield.setText("D:\\销售明细"+User.calcPreciseTime()+".xls");
    		label=new Label("    默认导出至D盘根目录");
    		label.setPrefWidth(200);
    		main.getChildren().add(label);
    		
            return main;
        
	}

	
	private void btnAction1(){
		System.out.println("Print Sth.");
	}

	 private final class T extends RecursiveTreeObject<T>{
		  StringProperty p1;
		  StringProperty p2;
		  StringProperty p3;
		  StringProperty p4;
		  StringProperty p5;
		  StringProperty p6;
		  StringProperty p7;
		  StringProperty p8;
		  
		  public T (String p1,String p2,String p3,String p4,String p5,String p6,String p7 ,String p8){
			  this.p1=new SimpleStringProperty (p1);
			  this.p2=new SimpleStringProperty (p2);
			  this.p3=new SimpleStringProperty (p3);
			  this.p4=new SimpleStringProperty (p4);
			  this.p5=new SimpleStringProperty (p5);
			  this.p6=new SimpleStringProperty (p6);
			  this.p7=new SimpleStringProperty (p7);
			  this.p8=new SimpleStringProperty(p8);
			  
		  }
		  
	}
	

}
 


	
