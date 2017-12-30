package ui.loadingUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by julia98 on 2017/12/29.
 */
public class LoadingFXController {
    @FXML Label loadingTxt;

    public void setLoadingTxt(Label loadingTxt) {
        this.loadingTxt = loadingTxt;
    }
}
