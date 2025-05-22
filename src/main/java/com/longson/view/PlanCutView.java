package com.longson.view;

import com.longson.pojo.CutScheme;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * 裁剪计划主界面
 */

public class PlanCutView extends VBox {

        private  VBox vbox;
        private  VBox vbox2;
        private  VBox vbox3;
        private  VBox vbox4;
        private  VBox vbox5;
        private  VBox vbox6;
        private  VBox vbox7;
        private  VBox vbox8;
        private  HBox hBox;

        public PlanCutView(){
            vbox=new VBox();

            Label systemlabel = new Label("系统款号");
            TextField systemtextfield = new TextField();

            Label customersystemlabel = new Label("客户款号");
            vbox.getChildren().addAll(systemlabel,customersystemlabel);
            vbox.setSpacing(18);


//        systemtextfield.setStyle("-fx-background-color: lightgrey");
            TextField  customersystemtextfield= new TextField();
//        customersystemtextfield.setStyle("-fx-background-color: lightgrey");
            vbox2=new VBox();
            vbox2.setSpacing(10);
            vbox2.getChildren().addAll(systemtextfield,customersystemtextfield);
            vbox3=new VBox();
            Label stateDate=new Label("开始日期");
            vbox3.setSpacing(18);
            Label endDate=new Label("结束日期");



            vbox4=new VBox();
            DatePicker stateDateTextField=new DatePicker();
            DatePicker endDateTextField=new DatePicker();

            vbox4.setSpacing(10);
            vbox3.getChildren().addAll(stateDate,endDate);
            vbox4.getChildren().addAll(stateDateTextField,endDateTextField);

            vbox5=new VBox();
            vbox6=new VBox();
            vbox7=new VBox();
            vbox8=new VBox();
            Label scheme=new Label("计划号");
            Label Customer=new Label("客户");
            Label factorylabel=new Label("Loc");
//         Image image = new Image("images/icon4.png");
            Button query=new Button("查询");
            query.setPrefWidth(100);
//         query.setGraphic(new ImageView(image));

            TextField schemetext=new TextField();
            TextField customertext=new TextField();
            ComboBox factory=new ComboBox<>();

            factory.getItems().addAll("嘉乐生产A部","嘉乐生产B部","嘉乐生产C部");
            factory.getSelectionModel().select(0);
            vbox5.getChildren().addAll(scheme,Customer);
            vbox5.setSpacing(18);
            vbox6.getChildren().addAll(schemetext,customertext);
            vbox6.setSpacing(10);
            vbox7.getChildren().addAll(factorylabel);
            vbox7.setSpacing(18);
            vbox8.getChildren().addAll(factory,query);
            vbox8.setSpacing(10);



            hBox=new HBox();
            hBox.setSpacing(10);
            hBox.getChildren().addAll(vbox,vbox2,vbox3,vbox4,vbox5,vbox6,vbox7,vbox8);
            hBox.setMargin(vbox, new Insets(12, 5, 10, 5));
            hBox.setMargin(vbox2, new Insets(10, 5, 10, 5));
            hBox.setMargin(vbox3, new Insets(12, 5, 10, 100));
            hBox.setMargin(vbox4, new Insets(10, 5, 10, 5));
            hBox.setMargin(vbox5, new Insets(12, 5, 10, 100));
            hBox.setMargin(vbox6, new Insets(10, 5, 10, 5));
            hBox.setMargin(vbox7, new Insets(12, 5, 10, 100));
            hBox.setMargin(vbox8, new Insets(10, 5, 10, 5));

            this.setPadding(new Insets(10));

            /**
             *  private int NO;
             *  private  int Status;
             * //计划开裁日期
             * private String  PlanCuttingDate;
             * //计划开裁组别
             * private String    CuttingLine;
             * //计划号
             * private String    Schedule_no;
             * //客户
             * private  String   Customer;
             * //系统款号
             * private String   SystemStyleNo;
             * //备注
             * private String    Remarks;
             * //车缝上线日期
             * private String    Sewingstartdate;
             *  //VAP 计划要求日期
             * private String    PlanRequiredate;
             * //VAP   接收日期
             * private String    VAPReadyDate;
             * //预裁剪数
             * private String    PreCutnumber;
             * //款式
             * private String    StyleDescription;
             * //  颜色及面料种类
             * private String    Fabricdescription;
             * //几种面料
             * private String    NumberofFabrictype;
             * //印/绣花/复合切割/烫标
             * private String    VAPDescription;
             * //"	"车缝组
             * private String    SewingLineNo;
             * //开MO时间
             * private String    MO_Issue_Date;
             * //纸样日期
             * private String    PatternReceiveddate;
             * //工艺单时间
             * private String    TechinicalMemo;
             *

             * //面料打单日期
             * private String    FabricIssueDate;
             *  //面料状态
             * private String    FabricStatus;
             * //布料缩率
             * private String    FabricShrinkage;
             * //实裁百分比
             * private String   Actualcuttingpercentage ;
             * // 实裁日期
             * private String   Actualcuttingdate;
             * //裁剪主面料
             * private String   Cutmainfabric;
             * //印绣花
             * private String   Printing_bongdin;
             * //烫缝发出日期
             * private String   bondingsentDate;
             * //烫缝回货期
             * private String   bondingreceiveDate ;
             *
             * private String   piecefinishdate;
             */

            TableView  tb=new TableView<CutScheme>();
            tb.setPrefHeight(860);
            TableColumn<CutScheme, String> NO = new TableColumn<>("序号");
            NO.setCellValueFactory(new PropertyValueFactory<>("NO"));
            TableColumn<CutScheme, String> Status = new TableColumn<>("状态");
            Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
            TableColumn<CutScheme, String> planCutDate = new TableColumn<>("计划开裁日期");
            planCutDate.setCellValueFactory(new PropertyValueFactory<>("planCuttingDate"));
            TableColumn<CutScheme,String> CuttingLine=new TableColumn<>("计划开裁组别");
            CuttingLine.setCellValueFactory(new PropertyValueFactory<>("CuttingLine") );
            TableColumn<CutScheme,String> Schedule_no=new TableColumn<>("计划号");
            Schedule_no.setCellValueFactory(new PropertyValueFactory<>("Schedule_no") );
            TableColumn<CutScheme, String> Customer_no = new TableColumn<>("客户");
            Customer_no.setCellValueFactory(new PropertyValueFactory<>("Customer"));
            TableColumn<CutScheme, String> style_no = new TableColumn<>("系统款号");
            style_no.setCellValueFactory(new PropertyValueFactory<>("SystemStyleNo"));
            TableColumn<CutScheme,String> remark=new TableColumn<>("备注");
            remark.setCellValueFactory(new PropertyValueFactory<>("Remarks") );
            TableColumn<CutScheme,String> sewingStartDate=new TableColumn<>("车缝上线日期");
            sewingStartDate.setCellValueFactory(new PropertyValueFactory<>("Sewingstartdate") );
            TableColumn<CutScheme,String> PlanRequiredate=new TableColumn<>("VAP 计划要求日期");
            PlanRequiredate.setCellValueFactory(new PropertyValueFactory<>("PlanRequiredate") );
            TableColumn<CutScheme,String>  vapin_phr=new TableColumn<>("VAP 回货期");
            vapin_phr.setCellValueFactory(new PropertyValueFactory<>("VAPReadyDate") );
            TableColumn<CutScheme,String> pre_cut=new TableColumn<>("预裁剪数");
            pre_cut.setCellValueFactory(new PropertyValueFactory<>(" PreCutnumber") );
            TableColumn<CutScheme,Double> style_sort=new TableColumn<>("款式描述");
            style_sort.setCellValueFactory(new PropertyValueFactory<>("StyleDescription") );
            TableColumn<CutScheme,Double> fabric_descript=new TableColumn<>("面料描述");
            fabric_descript.setCellValueFactory(new PropertyValueFactory<>("Fabricdescription") );
            TableColumn<CutScheme,Double> fabric_number=new TableColumn<>("面料种类");
            fabric_number.setCellValueFactory(new PropertyValueFactory<>("NumberofFabrictype") );
            TableColumn<CutScheme,Double> vap=new TableColumn<>("VAP");
            vap.setCellValueFactory(new PropertyValueFactory<>("VAPDescription"));
            TableColumn<CutScheme,String> lines=  new TableColumn<>("生产组别");
            lines.setCellValueFactory(new PropertyValueFactory<>(" SewingLineNo"));
            TableColumn<CutScheme,String>  MO_Issue_Date=new TableColumn<>("开单日期");
            MO_Issue_Date.setCellValueFactory(new PropertyValueFactory<>(" MO_Issue_Date"));
            TableColumn<CutScheme,String> PatternReceiveddate=new TableColumn<>("纸样日期");
            PatternReceiveddate.setCellValueFactory(new PropertyValueFactory<>(" PatternReceiveddate"));
            TableColumn<CutScheme,String>  TechinicalMemo=new TableColumn<>("工艺单日期");
            TechinicalMemo.setCellValueFactory(new PropertyValueFactory<>("TechinicalMemo"));
            TableColumn<CutScheme,String>   FabricIssueDate=new TableColumn<>("面料打单日期");
            FabricIssueDate.setCellValueFactory(new PropertyValueFactory<>(" FabricIssueDate"));
            TableColumn<CutScheme,String>  FabricStatus=new TableColumn<>("面料状态");
            FabricStatus.setCellValueFactory(new PropertyValueFactory<>("FabricStatus"));
            TableColumn<CutScheme,String>  FabricShrinkage=new TableColumn<>("布料缩率");
            FabricShrinkage.setCellValueFactory(new PropertyValueFactory<>("FabricShrinkage"));
            TableColumn<CutScheme,String>   Actualcuttingpercentage= new TableColumn<>("实裁数百分比");
            Actualcuttingpercentage.setCellValueFactory(new PropertyValueFactory<>(" Actualcuttingpercentage"));
            TableColumn<CutScheme,String>    Actualcuttingdate= new TableColumn<>("实裁日期");
            Actualcuttingdate.setCellValueFactory(new PropertyValueFactory<>(" Actualcuttingpercentage"));
            TableColumn<CutScheme,String>    Cutmainfabric= new TableColumn<>("裁剪主面料");
            Cutmainfabric.setCellValueFactory(new PropertyValueFactory<>("Cutmainfabric"));
            TableColumn<CutScheme,String>     Printing_bongdin= new TableColumn<>("印绣花发出日期");
            Printing_bongdin.setCellValueFactory(new PropertyValueFactory<>(" Actualcuttingpercentage"));
            TableColumn<CutScheme,String>    bondingsentDate= new TableColumn<>("印绣花接收日期");
            bondingsentDate.setCellValueFactory(new PropertyValueFactory<>("Printing_bongdin"));


            /**
             * 添加数据到冗余列
             */

            tb.getColumns().add(NO);
            tb.getColumns().add(Status);
            tb.getColumns().add(planCutDate);
            tb.getColumns().add(CuttingLine);
            tb.getColumns().add(Schedule_no);
            tb.getColumns().add(Customer_no);
            tb.getColumns().add(style_no);
            tb.getColumns().add(remark);
            tb.getColumns().add(sewingStartDate);
            tb.getColumns().add(PlanRequiredate);
            tb.getColumns().add(vapin_phr);
            tb.getColumns().add(pre_cut);
            tb.getColumns().add(fabric_descript);
            tb.getColumns().add(fabric_number);
            tb.getColumns().add(vap);
            tb.getColumns().add(MO_Issue_Date);
            tb.getColumns().add(PatternReceiveddate);
            tb.getColumns().add(TechinicalMemo);
            tb.getColumns().add(FabricIssueDate);
            tb.getColumns().add(FabricStatus);
            tb.getColumns().add(FabricShrinkage);
            tb.getColumns().add(Actualcuttingpercentage);
            tb.getColumns().add(Actualcuttingdate);
            tb.getColumns().add(Cutmainfabric);
            tb.getColumns().add(Printing_bongdin);
            tb.getColumns().add(bondingsentDate);

            ScrollPane sc =new ScrollPane(tb);










            this.getChildren().addAll(hBox,sc);





        }
    }


