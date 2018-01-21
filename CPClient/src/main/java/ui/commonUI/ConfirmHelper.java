package ui.commonUI;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**     
* @author 李安迪
* @date 2018年1月13日
* @description
*/
public class ConfirmHelper {
	public static boolean showConfirmDialog(){
		
		Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,"获取策略后不可修改之前信息哦");
	    Optional<ButtonType> result = confirmation.showAndWait();
	    if(result.isPresent() && result.get() == ButtonType.OK){
	        return true;
	     }
	    else{
	    	return false;
	     }
	}
	public static boolean showConfirmDialog(String s){
		
		Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,s);
	    Optional<ButtonType> result = confirmation.showAndWait();
	    if(result.isPresent() && result.get() == ButtonType.OK){
	        return true;
	     }
	    else{
	    	return false;
	     }
	}
}
