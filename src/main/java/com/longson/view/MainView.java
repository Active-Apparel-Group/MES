package com.longson.view;
import com.longson.utils.GetScreenSize;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainView {

    private final Stage stage = new Stage();
    private TabPane tabPane=new TabPane();

    public MainView(String username) {
//        Text text = new Text("账号：" + username );
//        BorderPane bor = new BorderPane();
//        bor.setStyle("-fx-background-color: cadetblue");
//        bor.setCenter(text);
//        Scene scene = new Scene(bor);
//
//
//        stage.setScene(scene);
//        stage.setTitle("登陆成功 ");
//        stage.setWidth(500);
//        stage.setHeight(500);
//        stage.setResizable(false); //登录窗口的大小不允许改变
//        stage.show();
        stage.setTitle("Active Apparel Group");

        Scene scene = new Scene(new Group());//创建场景并加载节点容器组

        SplitPane sp = new SplitPane();//获取节点容器组对





//      AnchorPane anchorPane = new AnchorPane();

//       Group sceneRoot=new Group();


        Image  home =new Image("images/home.png");
        ImageView  homeimage=new ImageView(home);

        Image  cale =new Image("images/calendar.png");
        ImageView  calender=new ImageView(cale);

        Image  chart =new Image("images/chart.png");
        ImageView  chartimage=new ImageView(chart);



        Image image = new Image("images/icon4.png");//"file:resource/imagas/icon4.png"

        //设置树菜单   图标
        ImageView Image=new ImageView(image);
        Image packimage = new Image("images/record.png");//file:resource/imagas/package.png
        ImageView packImage=new ImageView(packimage);

        Image data = new Image("images/data.png");//file:resource/imagas/package.png
        ImageView dataimage=new ImageView(data);

        Image view = new Image("images/computer.png");//file:resource/imagas/package.png
        ImageView viewimage=new ImageView(view);

        Image fabricicon = new Image("images/icon_treemenu_fabric.png");//file:resource/imagas/package.png
        ImageView treemenu_fabric=new ImageView(fabricicon);

        Image craft = new Image("images/icon_treemenu_craft.png");//file:resource/imagas/package.png
        ImageView treemenu_craft=new ImageView(craft);

        Image cut = new Image("images/icon_treemenu_cut.png");//file:resource/imagas/package.png
        ImageView treemenu_cut=new ImageView(cut);


        Image time = new Image("images/icon_treemenu_time.png");//file:resource/imagas/package.png
        ImageView treemenu_time=new ImageView(time);

        Image sew = new Image("images/icon_treemenu_sew.png");//file:resource/imagas/package.png
        ImageView treemenu_sew=new ImageView(sew);

        Image bond= new Image("images/icon_treemenu_bond.png");//file:resource/imagas/package.png
        ImageView treemenu_bond=new ImageView(bond);

        Image paint = new Image("images/icon_treemenu_paint.png");//file:resource/imagas/package.png
        ImageView treemenu_paint=new ImageView(paint);

        Image financeicon = new Image("images/icon_treemenu_finance.png");//file:resource/imagas/package.png
        ImageView treemenu_finance=new ImageView(financeicon);

        Image finish = new Image("images/icon_treemenu_finish.png");//file:resource/imagas/package.png
        ImageView treemenu_finish=new ImageView(finish);

        Image pnp = new Image("images/icon_treemenu_pnp.png");//file:resource/imagas/package.png
        ImageView treemenu_pnp=new ImageView(pnp);


        Button button = new Button("ImportExcel");
        button.setStyle("-fx-font: 16 arial; -fx-base: #ee2211;");
//        ------>Execl  数据导入
        button.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel文件", "*.xlsx"));
            File file = fileChooser.showOpenDialog(stage);
            if(file != null) {
                String filePath = file.getAbsolutePath();
                System.out.println("选择的Excel文件路径为：" + filePath);
            }
        });


        Image user = new Image("images/useric.png");//file:resource/imagas/package.png
        ImageView userimage=new ImageView(user);





        Tooltip.install(userimage, new Tooltip(username));




        ToolBar toolBar = new ToolBar();//创建工具栏
        toolBar.getItems().addAll(homeimage,calender,chartimage,Image,button,userimage);


        toolBar.setStyle("-fx-background-color:#fffacd");
        //Creating tree items
        final TreeItem<String> sysManage = new TreeItem<>("系统运维",viewimage);
        final TreeItem<String> fabricManage = new TreeItem<>("物料管理",treemenu_fabric);//创建树形结构选项组件
        final TreeItem<String> technicalManage = new TreeItem<>("工艺指标",treemenu_craft);//创建树形结构选项组件
        final TreeItem<String> cutManage = new TreeItem<>("裁剪管理",treemenu_cut);//创建树形结构选项组件
        final TreeItem<String> ntpManage=new TreeItem<>("工时管理",treemenu_time);
        final TreeItem<String> sewManage = new TreeItem<>("生产管理",treemenu_sew);//创建树形结构选项组件
        final TreeItem<String> bondManage = new TreeItem<>("烫缝管理",treemenu_bond);
        final TreeItem<String> paintManage = new TreeItem<>("印花管理",treemenu_paint);
        final TreeItem<String> finance=new TreeItem<>("Finance",treemenu_finance);
        final TreeItem<String> finishManage = new TreeItem<>("成品管理",treemenu_finish);
        final TreeItem<String> PNPManage = new TreeItem<>("PNP出货中心",treemenu_pnp);


        /**
         * 系统管理模块
         */
        final TreeItem<String> sysuser = new TreeItem<>("用户管理");//创建树形结构选项组件
        final TreeItem<String> sysitem = new TreeItem<>("系统参数");//创建树形结构选项组件
        final TreeItem<String> sysversion = new TreeItem<>("版本信息");//创建树形结构选项组件
        final TreeItem<String> mytansk= new TreeItem<>("个人中心");

        /**
         * 工艺指标模块
         */



        /**
         * 物料管理模块
         */
        final TreeItem<String> fabricsheet = new TreeItem<>("物料送货单",packImage);//创建树形结构选项组件
        final TreeItem<String> matralInWarehouse = new TreeItem<>("物料入仓",dataimage);//创建树形结构选项组件
        final TreeItem<String> IQCcheck = new TreeItem<>("IQC 检验");//创建树形结构选项组件
        final TreeItem<String> fabricinWarehouse = new TreeItem<>("面料入库");//创建树形结构选项组件
        final TreeItem<String> fabricoutWarehouse = new TreeItem<>("面料出库");//创建树形结构选项组件
        /**
         * 工艺指标模块
         */
        final TreeItem<String> tentsheet = new TreeItem<>("大货工艺单");//创建树形结构选项组件  --->ERP m3
        final TreeItem<String> simplesize = new TreeItem<>("样衣尺寸表");//创建树形结构选项组件
        final TreeItem<String> materiallist = new TreeItem<>("物料清单");//创建树形结构选项组件
//            final TreeItem<String>



        /**
         * 工时管理模块
         */
        final TreeItem<String> ntp = new TreeItem<>("NPT 时工登记",packImage);//创建树形结构选项组件
        final TreeItem<String> ntp_record=new TreeItem<>("NPT 记录");
        final TreeItem<String>  work_attendance=new TreeItem<>("考勤核对");//考勤管理

        

        /**
         * 生产管理
         */

        final TreeItem<String>  CutCall=new TreeItem<>("裁片呼叫");
        final TreeItem<String>  finishscan=new TreeItem<>("成品扫描");

        /**
         * 财务模块
         */


        /**
         * 裁剪管理模块
         */
        final TreeItem<String> cutplan = new TreeItem<>("裁剪计划");//创建树形结构选项组件
        final TreeItem<String> Mo=new TreeItem<>("制造订单");
        final TreeItem<String> childCut1 = new TreeItem<>("面料接收");//创建树形结构选项组件
        final TreeItem<String> childCut2 = new TreeItem<>("面料松布");//创建树形结构选项组件
        final TreeItem<String> childCut3 = new TreeItem<>("裁剪拉布");//创建树形结构选项组件
        final TreeItem<String> cutprocess = new TreeItem<>("裁剪进度");//创建树形结构选项组件
        final TreeItem<String> piececheck = new TreeItem<>("裁片检查");//创建树形结构选项组件
        final TreeItem<String> cutstrips= new TreeItem<>("切捆条");//创建树形结构选项组件

        /**
         * 印花管理模块
         */
        //Creating the root element


        /**
         * 新增财务盘点模块
         */
        final  TreeItem<String>  fabricinventory=new TreeItem<>("面料盘点");
        final  TreeItem<String>  pieceinventory=new TreeItem<>("裁片盘点");
        final  TreeItem<String>  finishinventory=new TreeItem<>("成品盘点");



        final TreeItem<String> root = new TreeItem<>("Dashboard");





        root.setExpanded(true);//默认设置根节点可展开

        //Adding tree items to the root

        root.getChildren().setAll(sysManage,fabricManage, technicalManage, cutManage,ntpManage,sewManage,finance,bondManage,paintManage,finishManage,PNPManage);//根节点添加3个叶子节点
        sysManage.getChildren().addAll(sysuser,sysitem,sysversion,mytansk);
        fabricManage.getChildren().setAll(fabricsheet,matralInWarehouse,IQCcheck,fabricinWarehouse,fabricoutWarehouse);
        technicalManage.getChildren().setAll(tentsheet,simplesize,materiallist);
        cutManage.getChildren().setAll(Mo,cutplan,childCut1,childCut2,childCut3,cutprocess);
        ntpManage.getChildren().setAll(ntp,ntp_record,work_attendance);
        sewManage.getChildren().setAll(CutCall,finishscan);
        finance.getChildren().setAll(fabricinventory,pieceinventory,finishinventory);


        //Creating a column
        TreeTableColumn<String,String> column = new TreeTableColumn<>("");//创建一个表格列

        column.setPrefWidth(150);//列宽设置
        ;
        //Defining cell content
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> p) ->
                new ReadOnlyStringWrapper(p.getValue().getValue()));//定义所选cell组件的内容格式
        //Creating a tree table view
        final TreeTableView<String> treeTableView = new TreeTableView<>(root);//创建一个表格树组件并添加根选项节点到树形表格当中\
        treeTableView.setPrefHeight(GetScreenSize.getScreenheight-toolBar.getHeight());
//            treeTableView.setOnMouseClicked(new EventHandler<MouseEvent>()
//            {
//                @Override
//                public void handle(MouseEvent mouseEvent)
//                {
//                    if(mouseEvent.getClickCount() == 2)
//                    {
//                        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
//                        System.out.println("Selected Text : " + item.getValue());
//
//                        if (item.getValue()=="Upload to HDFS") {
//                            ModuleDialog md = new ModuleDialog(primaryStage);
//                        }
//                    }
//                }
//            });
        treeTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                TreeItem<String> currentSelectItem = (TreeItem<String>) newValue;
                if (currentSelectItem != null && currentSelectItem.getValue() == "Upload to HDFS") {
                    System.out.println("selection(" + ((TreeItem<String>) newValue).getValue() + ") change");

                }
            }
        });
        /**
         *
         */
        treeTableView.setOnMouseClicked(new EventHandler<MouseEvent>()
                                        {
                                            @Override
                                            public void handle(MouseEvent mouseEvent)
                                            {
                                                if(mouseEvent.getClickCount() == 2)
                                                {
                                                    TreeItem<String> item = treeTableView.getSelectionModel().getSelectedItem();
                                                    System.out.println("Selected Text : " + item.getValue());
//                        for (int i = 0; i <item.getChildren().size() ; i++) {
//                            System.out.println(item.getChildren().get(i));
//                        }
//                        tabPane.setSide;

                                                    if (item.getValue().equals("个人中心")) {
                                                        Tab personaltab =new Tab("个人中心");
//                            Tab  tab2= new Tab("面料接收")N
                                                        PersonalCenter pc=new PersonalCenter();

                                                        personaltab.setContent(pc);

//                            tab2.setText("面料接收");


                                                        tabPane.getSelectionModel().select(personaltab);
                                                        tabPane.getTabs().add(personaltab);
//                            sp.getItems().add(tabPane);



                                                    }
                                                    if (item.getValue().equals("面料接收")) {
                                                        Tab tab2=new Tab("面料接收");
//                            Tab  tab2= new Tab("面料接收")N
                                                        FabricReceive tab=new FabricReceive();

                                                        tab2.setContent(tab);

//                            tab2.setText("面料接收");


                                                        tabPane.getSelectionModel().select(tab2);
                                                        tabPane.getTabs().add(tab2);
//                            sp.getItems().add(tabPane);


                                                        System.out.println("Geater->面料接收被选中");
                                                    }
                                                    if (item.getValue()=="面料送布") {
                                                        Tab sentFabric=new Tab("面料送布");
                                                        tabPane.getSelectionModel().select(sentFabric);
                                                        tabPane.getTabs().add(sentFabric);
//                            sp.getItems().add(tabPane);


                                                        System.out.println("面料送布功能被选中 ");
                                                    }

                                                    if (item.getValue()=="制造订单") {
                                                        Tab tablemanorder=new Tab("制造订单");
                                                        ManufacturOrder manufacturingOrder = new ManufacturOrder();
                                                        tablemanorder.setContent(manufacturingOrder);
                                                        tabPane.getSelectionModel().select(tablemanorder);
                                                        tabPane.getTabs().add(tablemanorder);
//                            sp.getItems().add(tabPane);


                                                        System.out.println("制造订单 ");
                                                    }

                                                    if (item.getValue()=="裁剪计划") {
                                                        Tab sentFabric=new Tab("裁剪计划");
                                                        PlanCutView planCutStage = new PlanCutView();
                                                        sentFabric.setContent(planCutStage);
                                                        tabPane.getSelectionModel().select(sentFabric);
                                                        tabPane.getTabs().add(sentFabric);
//                            sp.getItems().add(tabPane);


                                                        System.out.println("裁剪计划 ");
                                                    }
                                                    if(item.getValue()=="NPT 时工登记"){
                                                        Tab NTP=new Tab("NPT时工登记",packImage);
                                                        NptView ntp = new NptView(username);
                                                        NTP.setContent(ntp);
                                                        tabPane.getSelectionModel().select(NTP);
                                                        tabPane.getTabs().add(NTP);
                                                        System.out.println("添加产能");

                                                    }
                                                    if(item.getValue()=="裁片呼叫"){
                                                        Tab Call=new Tab("裁片呼叫");
                                                        CutCallView CutCall = new CutCallView(username);
                                                        Call.setContent(CutCall);
                                                        tabPane.getSelectionModel().select(Call);
                                                        tabPane.getTabs().add(Call);
                                                        System.out.println("裁片呼叫");

                                                    }

                                                    if(item.getValue()=="成品扫描"){
                                                        Tab finishScan = new Tab("成品扫描");
                                                        FinishProductScanView finishProductScanView = new FinishProductScanView();
                                                        finishScan.setContent(finishProductScanView);
                                                        tabPane.getSelectionModel().select(finishScan);
                                                        tabPane.getTabs().add(finishScan);


                                                    }
                                                    if(item.getValue()=="NPT 记录"){
                                                        Tab npttab=new Tab("NPT 记录");
                                                        NptApprove nptapprove = new NptApprove();
                                                        npttab.setContent(nptapprove);
                                                        tabPane.getSelectionModel().select(npttab);
                                                        tabPane.getTabs().add(npttab);


                                                    }

                                                }
                                            }
                                        }
        );

        VBox vb=new VBox();
        treeTableView.getColumns().add(column);//表格添加列
//        treeTableView.setLayoutX(0);
//        treeTableView.setLayoutY(20);
//        treeTableView.setPrefWidth(60);//树表格添加宽度
        treeTableView.setPrefHeight(GetScreenSize.getScreenheight);
        treeTableView.setShowRoot(true);//树表格显示根节点
//            sceneRoot.getChildren().addAll(treeTableView,toolBar);
//            bl.setTop(toolBar);
//            bl.setLeft(treeTableView);

        sp.getItems().addAll(treeTableView,tabPane);
//        sp.setStyle("-fx-background-color:whitesmoke");



//        sceneRoot.getChildren().addAll(treeTableView,vBox);//节点容器组添加树表格节点
//        Scene  scene=new Scene(anchorPane);
//        groot.getChildren().setAll(sceneRoot,vBox);
        vb.getChildren().addAll(toolBar,sp);
        scene.setRoot(vb);
        stage.setScene(scene);//舞台设置场景
        stage.setWidth((GetScreenSize.getScreenwidth)*2/3);
        stage.setHeight((GetScreenSize.getScreenheight)*2.5/3);
//            primaryStage.setMaximized(true); 设置全屏
        stage.getIcons().add(new Image("images/icon.png")); //file:resource/imagas/package.png

//            Image image = new Image("/resources/images/icon.png");
//            primaryStage.getIcons().add(image);

        stage.show();//舞台展现

//        sp.setDividerPositions(0.18f,0.82f);
//        sp.setMinSize(0.06f,0.78);
        treeTableView.maxWidthProperty().bind(sp.widthProperty().multiply(0.18));


        stage.showingProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    sp.setDividerPositions(0.15f,0.85f);
                    observable.removeListener(this);
                }
            }
        });





    }



}



