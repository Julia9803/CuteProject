package ui.salesmanUI;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class SaleNewController {
	@FXML public Pagination pagination;
	@FXML public void onPaginationClicked() {
		pagination.setPageFactory(new Callback<Integer,Node>(){
			@Override
			public Node call(Integer param) {
				ImageView lamp1 = new ImageView();
				Image image1 = new Image("lamp1.jpg");
				lamp1.setImage(image1 );
				return lamp1;
			}
		});
	}

}
