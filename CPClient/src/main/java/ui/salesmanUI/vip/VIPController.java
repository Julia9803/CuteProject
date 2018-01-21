package ui.salesmanUI.vip;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Stack;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import VO.VIPVO.VIPVO;
import bl.VIPbl.VIPBLServiceImpl;
import blservice.VIPblservice.VIPBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Created by julia98 on 2017/12/22.
 */
public class VIPController {
	@FXML public Pane vip1;
	@FXML public Pane vip2;
	@FXML public ScrollPane scrollPane;
	
    @FXML public Label presentLocation;
    @FXML public Button vipNameSearchBtn;
    @FXML public Button vipPhoneNumberSearchBtn;
    @FXML public Button vipIDSearchBtn;
    @FXML public Pane notice;
    @FXML public Label noticeLabel;
    @FXML public TextField name;
    @FXML public JFXDialog dialog;
    @FXML public JFXDialogLayout dialogLayout;

    @FXML public VBox vBox;
    @FXML public VBox vipVBox;
    @FXML public ImageView editBtn;

    @FXML public TextField searchField;
    @FXML public Button searchBtn;

    @FXML private TextField vipID; //编号
    @FXML private TextField vipCategory; //分类
    @FXML private TextField vipGrade; //级别
    @FXML private TextField vipName; //姓名
    @FXML private TextField vipPhoneNumber;//电话号码
    @FXML private TextField vipEmail; //电子邮箱
    @FXML private TextField vipAddress; //地址
    @FXML private TextField vipPostCode; //邮编
    @FXML private TextField collection;//应收
    @FXML private TextField collectionLimit;//应收额度
    @FXML private TextField payment; //应付
    @FXML private TextField clerk; // 默认业务员

    private String vipTypeSearch = "";//保存模糊查找的类型
    ArrayList<VIPVO> vipvos = new ArrayList<>();//存放模糊查找到的vip列表
    VIPBLService vipBLService = new VIPBLServiceImpl();
    protected TreeView<String> treeView;
    private TreeItem<String> rootTreeItem;
    Stack<TreeItem<String>> stack = new Stack<>();//存放目录的引用 便于增减改名会员

    //初始化节点的方法
    private void setNode(TreeItem<String> node) throws RemoteException {
        TreeItem<String> son1 = new TreeItem<>("分类：" + "供货商");
        son1.setGraphic(new ImageView("img/folderIcon.png"));
        node.getChildren().add(son1);

        TreeItem<String> son2 = new TreeItem<>("分类：" + "经销商");
        son2.setGraphic(new ImageView("img/folderIcon.png"));
        node.getChildren().add(son2);


        ArrayList<VIPVO> vips1 = (ArrayList<VIPVO>) vipBLService.findVIP("供货商", "category");
        if (vips1 != null) {
            for (int i = 0; i < vips1.size(); i++) {
                son1.getChildren().add(new TreeItem<>("会员：" + vips1.get(i).getName()));
            }
        }

        ArrayList<VIPVO> vips2 = (ArrayList<VIPVO>) vipBLService.findVIP("经销商", "category");
        if (vips2 != null) {
            for (int i = 0; i < vips2.size(); i++) {
                son2.getChildren().add(new TreeItem<>("会员：" + vips2.get(i).getName()));
            }
        }
    }

    public void setTextFieldUnable(){
        vipID.setEditable(false);
        vipCategory.setEditable(false);
        vipGrade.setEditable(false);
        vipName.setEditable(false);
        vipPhoneNumber.setEditable(false);
        vipEmail.setEditable(false);
        vipAddress.setEditable(false);
        vipPostCode.setEditable(false);
        collection.setEditable(false);
        collectionLimit.setEditable(false);
        payment.setEditable(false);
        clerk.setEditable(false);
    }

    @FXML
    public void initialize() throws RemoteException{
        initTreeView();
        setTextFieldUnable();
        notice.setVisible(false);
        vipVBox.getChildren().clear();
    }
    //初始TreeView 加载所有商品和分类
    private void initTreeView() throws RemoteException {

        presentLocation.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("标签被点击"));
        //在ScrollPane上配置并加入TreeView
        rootTreeItem = new TreeItem<String>("根目录");
        rootTreeItem.setExpanded(true);

        setNode(rootTreeItem);
        //以下为demo
/*
        TreeItem<String> item1 = new TreeItem<String>("分类：" + "供货商");
        item1.setGraphic(new ImageView("img/folderIcon.png"));
        rootTreeItem.getChildren().add(item1);

        TreeItem<String> item2 = new TreeItem<String>("分类：" + "经销商");
        item2.setGraphic(new ImageView("img/folderIcon.png"));
        rootTreeItem.getChildren().add(item2);

        for (int i = 0; i < 5; i++) {
            TreeItem<String> item3 = new TreeItem<String>("会员：" + i);
            item1.getChildren().add(item3);
        }

        for (int i = 0; i < 5; i++) {
            TreeItem<String> item3 = new TreeItem<String>("会员：" + i);
            item2.getChildren().add(item3);
        }
*/
        //以上为demo

        treeView = new TreeView<>(rootTreeItem);
        vBox.getChildren().add(treeView);
        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                {
                    TreeItem<String> vipItem = treeView.getSelectionModel().getSelectedItem();
                    System.out.println(vipItem.getValue().toString() + "被点击");

                    if (vipItem.getValue().toString().contains("会员")) {
                        System.out.println("是会员项 可以进行下一步操作");
                        vipVBox.getChildren().clear();
                        //为了测试运行结果 先注释下面一行从数据库获取对应商品信息的语句
                        try {
                            newVIPPane(vipBLService.getVIP(vipItem.getValue().toString().substring(3)));
                        } catch (RemoteException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
        );

        //设置右键菜单
        ContextMenu menu = new ContextMenu();
        menu.setStyle("-fx-background-color: #FF7575");

        MenuItem newVIPBar = new MenuItem("新建会员");
        newVIPBar.setGraphic(new ImageView("img/add.png"));

        newVIPBar.setOnAction(e->{

            TreeItem<String> selectItem = treeView.getSelectionModel().getSelectedItem();

            System.out.println("选中项文字 " + selectItem.getValue().toString());
            System.out.println("选中项子节点文字" + selectItem.getChildren().toString());

            if((selectItem.getValue().toString().contains("分类") && selectItem.isLeaf()) || (selectItem.getValue().toString().contains("分类") && selectItem.getChildren().toString().contains("会员"))) {

                TreeItem<String> vipTreeItem = new TreeItem<>("会员："+rootTreeItem.getChildren().size());
                selectItem.getChildren().add(vipTreeItem);
                stack.push(vipTreeItem);
                noticeLabel.setText("新建会员");
                notice.setVisible(true);
            }else{
            	    dialog.setContent(new JFXButton("此节点下不可添加会员"));
                dialog.show(dialogLayout);
                //presentLocation.setText("此节点下不可添加会员");
                System.out.println("此节点下不可添加会员");
            }

        });

        MenuItem deleteBar = new MenuItem("删除");
        deleteBar.setGraphic(new ImageView("img/delete.png"));
        deleteBar.setOnAction(e ->{
            TreeItem selectItem = treeView.getSelectionModel().getSelectedItem();

            System.out.println("判断删除的是会员还是分类：" + selectItem.getValue().toString().substring(0,2));

            switch (selectItem.getValue().toString().substring(0,2)) {
                case "会员":
                    System.out.println("删除会员所属分类：" + selectItem.getParent().getValue().toString().substring(3) + " 删除会员名称：" + selectItem.getValue().toString().substring(3));
                    try {
                        vipBLService.deleteVIP(selectItem.getValue().toString().substring(3));
                    } catch (RemoteException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    dialog.setContent(new JFXButton(selectItem.getValue().toString() + " 已删除"));
                    dialog.show(dialogLayout);
                    break;

                case "分类":
                 	dialog.setContent(new JFXButton("此节点下不可删除"));
                    dialog.show(dialogLayout);
                    //presentLocation.setText("此节点下不可删除");
                    System.out.println("此节点下不可删除");
                    break;
            }
            selectItem.getParent().getChildren().remove(selectItem);
        });

        MenuItem refactorBar = new MenuItem("改名");
        refactorBar.setGraphic(new ImageView("img/survey.png"));
        refactorBar.setOnAction(e->{

            //判断当前节点是否可添加商品
            TreeItem<String> selectItem = treeView.getSelectionModel().getSelectedItem();

            System.out.println("选中项文字 " + selectItem.getValue().toString());
            //System.out.println("选中项子节点文字" + selectItem.getChildren().toString());
            System.out.println(selectItem.getValue().toString().substring(0,2));
            if(selectItem.getValue().toString().substring(0,2).contains("会员")) {
                stack.push(selectItem);
                noticeLabel.setText("修改名称");
                notice.setVisible(true);
            }else{
            	    dialog.setContent(new JFXButton("此节点下不可修改名称"));
                dialog.show(dialogLayout);
                //presentLocation.setText("此节点下不可修改名称");
                System.out.println("此节点下不可修改名称");
            }
        });

        menu.getItems().add(newVIPBar);
        menu.getItems().add(refactorBar);
        menu.getItems().add(deleteBar);
        treeView.setContextMenu(menu);
    }

        /**
         * 编辑会员信息
         */
    /*@FXML
    private void setEditBtn(){
        try {
            new VIPInfoEditWin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 模糊查找会员确认按钮
     * @throws RemoteException 
     */
    @FXML
    private void setSearchBtn() throws RemoteException{
        if(searchField.getText()!=null){
            switch (this.vipTypeSearch){
                case "客户名":
                    this.vipTypeSearch = "name";
                    break;
                case "客户ID":
                    this.vipTypeSearch = "id";
                    break;
                case "客户电话":
                    this.vipTypeSearch = "phoneNumber";
                    break;
            }
            vipvos = (ArrayList<VIPVO>)vipBLService.findVIP(searchField.getText(),this.vipTypeSearch);
            vipVBox.getChildren().clear();
            for(int i =0;i<vipvos.size();i++){
                newVIPPane(vipvos.get(i));
            }
        }
    }

    @FXML
    public void onVIPNameSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + vipNameSearchBtn.getText());
        this.vipTypeSearch = vipNameSearchBtn.getText();
    }

    @FXML

    public void onVIPIDSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + vipIDSearchBtn.getText());
        this.vipTypeSearch = vipIDSearchBtn.getText();
    }

    @FXML
    public void onVIPPhoneNumberSearchBtnClicked(){
        searchField.setPromptText("模糊查找" + vipPhoneNumberSearchBtn.getText());
        this.vipTypeSearch = vipPhoneNumberSearchBtn.getText();
    }

    VIPVO tmpVO = new VIPVO("00000001"
            ,"分类1"
            ,"1"
            ,"姓名1"
            ,"18800000000"
            ,"123456789@qq.com"
            ,"地址1"
            ,"210046"
            ,100
            ,1000
            ,100
            ,"业务员1");

    /**
     * 新建会员，修改名称出现的提示框
     * 其中stack存放TreeItem的引用
     * 此方法只是修改对应目录名称，新建工作已在上一层做好
     * @throws RemoteException 
     */
    @FXML
    public void onSureBtnClicked() throws RemoteException {
        String tmp = "";
        switch (noticeLabel.getText()) {
            case "新建会员":
                tmp = "会员：";
                stack.peek().setValue(tmp + "" + name.getText());
                tmpVO.setName(name.getText());
                tmpVO.setCategory(stack.peek().getParent().getValue().toString().substring(3));
                String id = vipBLService.newVIPID(tmpVO);
                VIPVO vo = vipBLService.getVIP(name.getText());
                vo.setId(id);
                vipBLService.modifyVIP(vo);
                break;

            case "修改名称":
                tmp = stack.peek().getValue().toString();
                System.out.println("原始名称为：" + tmp);
                System.out.println("修改后为：" + tmp.substring(0, 3));

                if (tmp.substring(0, 3).contains("分类")) {
                    noticeLabel.setText("分类名不可修改");
                }

                //惰性删除ui上该分类 对于数据库内数据不改动
                if (tmp.substring(0, 3).contains("会员")) {
                    stack.peek().setValue(tmp.substring(0, 3) + name.getText());
                    System.out.println("原来会员名VIP：" + tmp.substring(3) + "新会员名：" + name.getText());
                    VIPVO vipVO = vipBLService.getVIP(tmp.substring(3));
                    vipVO.setName(name.getText());
                    vipBLService.modifyVIP(vipVO);
                }
                break;
        }
        notice.setVisible(false);
        name.clear();
        stack.pop();
    }

    @FXML
    public void onCancelBtnClicked(){
      	stack.peek().getParent().getChildren().remove(stack.peek());
        notice.setVisible(false);
        name.clear();
        stack.pop();
    }

    private void newVIPPane(VIPVO vipvo){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(703,480);
        anchorPane.setStyle("-fx-background-color: #FFB5B5");
        vipVBox.getChildren().add(anchorPane);
        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(36);
        gridPane.setLayoutY(42);
        gridPane.setPrefWidth(612);
        gridPane.setPrefHeight(352);
        anchorPane.getChildren().add(gridPane);

        Label greenLabel = new Label();
        greenLabel.setPrefSize(12,37);
        greenLabel.setStyle("-fx-background-color:  #4F9D9D");
        gridPane.add(greenLabel,0,0);

        Label vipInfoLabel = new Label("   客户信息");
        vipInfoLabel.setPrefSize(98,23);
        vipInfoLabel.setFont(Font.font(18));
        gridPane.add(vipInfoLabel,0,0);

        Label vipNameLabel = new Label("姓名");
        vipNameLabel.setPrefSize(123,39);
        vipNameLabel.setFont(Font.font(13));
        vipNameLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipNameLabel,0,1);

        Label vipIDLabel = new Label("编号");
        vipIDLabel.setPrefSize(123,39);
        vipIDLabel.setFont(Font.font(13));
        vipIDLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipIDLabel,3,1);

        Label vipCategoryLabel = new Label("分类");
        vipCategoryLabel.setPrefSize(123,39);
        vipCategoryLabel.setFont(Font.font(13));
        vipCategoryLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipCategoryLabel,0,2);

        Label vipGradeLabel = new Label("分类");
        vipGradeLabel.setPrefSize(123,39);
        vipGradeLabel.setFont(Font.font(13));
        vipGradeLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipGradeLabel,3,2);

        Label vipPhoneNumberLabel = new Label("电话");
        vipPhoneNumberLabel.setPrefSize(123,39);
        vipPhoneNumberLabel.setFont(Font.font(13));
        vipPhoneNumberLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipPhoneNumberLabel,0,3);

        Label vipAddressLabel = new Label("地址");
        vipAddressLabel.setPrefSize(123,39);
        vipAddressLabel.setFont(Font.font(13));
        vipAddressLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipAddressLabel,3,3);

        Label vipEmailLabel = new Label("邮编");
        vipEmailLabel.setPrefSize(123,39);
        vipEmailLabel.setFont(Font.font(13));
        vipEmailLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipEmailLabel,0,4);

        Label vipPostCodeLabel = new Label("邮编");
        vipPostCodeLabel.setPrefSize(123,39);
        vipPostCodeLabel.setFont(Font.font(13));
        vipPostCodeLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipPostCodeLabel,3,4);

        Label greenLabel2 = new Label();
        greenLabel2.setPrefSize(12,37);
        greenLabel2.setStyle("-fx-background-color:  #4F9D9D");
        gridPane.add(greenLabel2,0,6);

        Label vipCollectPaymentLabel = new Label("   应收应付");
        vipCollectPaymentLabel.setPrefSize(98,23);
        vipCollectPaymentLabel.setFont(Font.font(18));
        gridPane.add(vipCollectPaymentLabel,0,6);

        Label vipCollectLimitLabel = new Label("应收额度");
        vipCollectLimitLabel.setPrefSize(123,39);
        vipCollectLimitLabel.setFont(Font.font(13));
        vipCollectLimitLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipCollectLimitLabel,0,7);

        Label vipCollectLabel = new Label("应收");
        vipCollectLabel.setPrefSize(123,39);
        vipCollectLabel.setFont(Font.font(13));
        vipCollectLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipCollectLabel,3,7);

        Label vipClerkLabel = new Label("业务员");
        vipClerkLabel.setPrefSize(123,39);
        vipClerkLabel.setFont(Font.font(13));
        vipClerkLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipClerkLabel,0,8);

        Label vipPaymentLabel = new Label("业务员");
        vipPaymentLabel.setPrefSize(123,39);
        vipPaymentLabel.setFont(Font.font(13));
        vipPaymentLabel.setTextFill(Color.gray(0,0.63));
        gridPane.add(vipPaymentLabel,3,8);

        ImageView edit = new ImageView("img/edit.png");
        edit.setFitHeight(25);
        edit.setFitWidth(25);
        edit.setAccessibleHelp(vipvo.getName());
        edit.setOnMousePressed(event -> {
            try {
                VIPInfoEditController.vip = edit.getAccessibleHelp();
                new VIPInfoEditWin(edit.getAccessibleHelp());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        gridPane.add(edit,4,0);

        JFXTextField vipID = new JFXTextField();
        vipID.setText(vipvo.getId());
        vipID.setEditable(false);
        vipID.setPrefSize(123,27);
        gridPane.add(vipID,4,1);

        JFXTextField vipCategory = new JFXTextField();
        vipCategory.setText(vipvo.getCategory());
        vipCategory.setEditable(false);
        vipCategory.setPrefSize(123,27);
        gridPane.add(vipCategory,1,2);

        JFXTextField vipGrade = new JFXTextField();
        vipGrade.setText(vipvo.getGrade().toString());
        vipGrade.setEditable(false);
        vipGrade.setPrefSize(123,27);
        gridPane.add(vipGrade,4,2);

        JFXTextField vipName = new JFXTextField();
        vipName.setText(vipvo.getName());
        vipName.setEditable(false);
        vipName.setPrefSize(123,27);;
        gridPane.add(vipName,1,1);

        JFXTextField vipPhoneNumber = new JFXTextField();
        vipPhoneNumber.setText(vipvo.getPhoneNumber());
        vipPhoneNumber.setEditable(false);
        vipPhoneNumber.setPrefSize(123,27);;
        gridPane.add(vipPhoneNumber,1,3);

        JFXTextField vipEmail = new JFXTextField();
        vipEmail.setText(vipvo.getEmail());
        vipEmail.setEditable(false);
        vipEmail.setPrefSize(123,27);
        gridPane.add(vipEmail,1,4);

        JFXTextField vipAddress = new JFXTextField();
        vipAddress.setText(vipvo.getAddress());
        vipAddress.setEditable(false);
        vipAddress.setPrefSize(123,27);;
        gridPane.add(vipAddress,4,3);

        JFXTextField vipPostCode = new JFXTextField();
        vipPostCode.setText(vipvo.getPostCode());
        vipPostCode.setEditable(false);
        vipPostCode.setPrefSize(123,27);
        gridPane.add(vipPostCode,4,4);

        JFXTextField collection = new JFXTextField();
        collection.setText(""+vipvo.getCollection());
        collection.setEditable(false);
        collection.setPrefSize(123,27);
        gridPane.add(collection,4,7);

        JFXTextField collectionLimit = new JFXTextField();
        collectionLimit.setText(""+vipvo.getCollectionLimit());
        collectionLimit.setEditable(false);
        collectionLimit.setPrefSize(123,27);
        gridPane.add(collectionLimit,1,7);

        JFXTextField payment = new JFXTextField();
        payment.setText(""+vipvo.getPayment());
        payment.setEditable(false);
        payment.setPrefSize(123,27);;
        gridPane.add(payment,4,8);

        JFXTextField clerk = new JFXTextField();
        clerk.setText(vipvo.getClerk());
        clerk.setEditable(false);
        clerk.setPrefSize(123,27);
        gridPane.add(clerk,1,8);

        Label tmpLabel0 = new Label();
        tmpLabel0.setPrefSize(123,39);
        
        Label tmpLabel1 = new Label();
        tmpLabel1.setPrefSize(123,39);
        
        Label tmpLabel2 = new Label();
        tmpLabel2.setPrefSize(123,39);
        
        Label tmpLabel3 = new Label();
        tmpLabel3.setPrefSize(123,39);
        
        Label tmpLabel4 = new Label();
        tmpLabel4.setPrefSize(123,39);
        
        Label tmpLabel5 = new Label();
        tmpLabel5.setPrefSize(123,39);
        
        Label tmpLabel6 = new Label();
        tmpLabel6.setPrefSize(123,39);
        
        Label tmpLabel7 = new Label();
        tmpLabel7.setPrefSize(123,39);
        
        Label tmpLabel8 = new Label();
        tmpLabel8.setPrefSize(123,39);
  
        gridPane.addColumn(2,tmpLabel0,tmpLabel1,tmpLabel2,tmpLabel3,tmpLabel4,tmpLabel5,tmpLabel6,tmpLabel7,tmpLabel8);

        System.out.println("new VIPPane init Success!");
    }
}
