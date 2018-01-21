package ui.stockmanUI;


import VO.storeVO.StoreLogVO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StoreLogItemController {
    @FXML
    Label time;
    @FXML Label num;
    @FXML Label goodsID;
    @FXML Label goodsName;
    @FXML Label Type;
    @FXML Label price;

    public void set(StoreLogVO vo){
        time.setText(vo.time);
        goodsID.setText(vo.id);
        goodsName.setText(vo.name);
        price.setText(Double.toString(vo.price));
        num.setText(Integer.toString(vo.num));

        switch(vo.type){
            case PRESENT:Type.setText("库存赠出");
                       break;
            case LOSS:Type.setText("报损出库");
                break;
            case SALE:Type.setText("销售出库");
                break;
            case STOCK:Type.setText("进货入库");
                break;
            case OVERFLOW:Type.setText("报溢入库");
                break;
            case SALE_RETURN:Type.setText("销售退货入库");
                break;
            case STOCK_RETURN:Type.setText("进货退货出库");
                break;
                default:break;
        }
    }
}
