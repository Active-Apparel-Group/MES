package com.longson.view;

import com.alibaba.fastjson.JSON;
import com.longson.pojo.CallList;
import com.longson.pojo.Orders;
import com.longson.pojo.SuperMarketWip;
import com.longson.utils.HttpUrlConnect;
import com.longson.utils.TransferUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//定义成品扫描查询 界面
public  class FinishProductScanView  extends  VBox{

    private HBox hBox;

//    public CutCallView(String username) {
////            vbox = new VBox();
////
////            Label startdate = new Label("开始日期");
////            DatePicker startdateField = new DatePicker();
////
////            Label customersystemlabel = new Label("客户款号");
////            vbox.getChildren().addAll(startdate, customersystemlabel);
////            vbox.setSpacing(18);
////
////
//////        systemtextfield.setStyle("-fx-background-color: lightgrey");
////            TextField customersystemtextfield = new TextField();
//////        customersystemtextfield.setStyle("-fx-background-color: lightgrey");
////            vbox2 = new VBox();
////            vbox2.setSpacing(10);
////            vbox2.getChildren().addAll(startdateField, customersystemtextfield);
////            vbox3 = new VBox();
////            Label endDate = new Label("结束日期");
////            vbox3.setSpacing(18);
////            Label styleNo = new Label("系统款号");
////
////
////            vbox4 = new VBox();
////            DatePicker endDateTextField = new DatePicker();
////            TextField styleTextfield = new TextField();
////
////            vbox4.setSpacing(10);
////            vbox3.getChildren().addAll(endDate, styleNo);
////            vbox4.getChildren().addAll(endDateTextField, styleTextfield);
////
////            vbox5 = new VBox();
////            vbox6 = new VBox();
////            vbox7 = new VBox();
////            vbox8 = new VBox();
////            Label scheme = new Label("计划号");
////            Label Customer = new Label("客户");
////            Label factorylabel = new Label("Loc");
//////         Image image = new Image("images/icon4.png");
////            Button select = new Button("查询");
////            select.setPrefWidth(100);
//////         query.setGraphic(new ImageView(image));
////
////            TextField schemetext = new TextField();
////            TextField customertext = new TextField();
////            ComboBox factory = new ComboBox<>();
////
////            factory.getItems().addAll("嘉乐生产A部", "嘉乐生产B部", "嘉乐生产C部");
////            factory.getSelectionModel().select(0);
////            vbox5.getChildren().addAll(scheme, Customer);
////            vbox5.setSpacing(18);
////            vbox6.getChildren().addAll(schemetext, customertext);
////            vbox6.setSpacing(10);
////            vbox7.getChildren().addAll(factorylabel);
////            vbox7.setSpacing(18);
////            vbox8.getChildren().addAll(factory, select);
////            vbox8.setSpacing(10);
////
////
////            hBox = new HBox();
////            hBox.setSpacing(10);
////            hBox.getChildren().addAll(vbox, vbox2, vbox3, vbox4, vbox5, vbox6, vbox7, vbox8);
////            hBox.setMargin(vbox, new Insets(12, 5, 10, 5));
////            hBox.setMargin(vbox2, new Insets(10, 5, 10, 10));
////            hBox.setMargin(vbox3, new Insets(12, 5, 10, 20));
////            hBox.setMargin(vbox4, new Insets(10, 5, 10, 5));
////            hBox.setMargin(vbox5, new Insets(12, 5, 10, 20));
////            hBox.setMargin(vbox6, new Insets(10, 5, 10, 5));
////            hBox.setMargin(vbox7, new Insets(12, 5, 10, 20));
////            hBox.setMargin(vbox8, new Insets(10, 5, 10, 10));
////            //设置内边距
////            this.setPadding(new Insets(10));
//
//        /**
//         * +ADD   增加查询条件 组件
//         */
//
//
//        hBox= new HBox();
//        Label startdate = new Label("开始日期");
//        DatePicker startdateField = new DatePicker();
//        Label enddate = new Label("结束日期");
//        DatePicker enddateField = new DatePicker();
//        Label style_no = new Label("系统款号");
//        TextField styleField = new TextField();
//        Label order_no = new Label("计划号");
//        TextField orderField = new TextField();
//        hBox.setSpacing(10);
//        Button select = new Button("查询");
//        select.setPrefWidth(100);
//
//        hBox.getChildren().addAll(startdate,startdateField,enddate,enddateField,style_no,styleField,order_no,orderField,select);
//        hBox.setPadding(new Insets(20,5,20,5));
//
//
//
//
//
//        //创建查询实体对象]
//        HBox tableBox = new HBox();
//        //新增呼叫请求列表
//        TableView calllist = new TableView();
//        TableColumn<CallList, Integer> no = new TableColumn<>("序号");
//        no.setCellValueFactory(new PropertyValueFactory<>("callNo"));;
//        TableColumn<CallList, Integer> state = new TableColumn<>("状态");
//        state.setCellValueFactory(new PropertyValueFactory<>("state"));
//        TableColumn<CallList, Integer> callDate = new TableColumn<>("请求日期");
//        callDate.setCellValueFactory(new PropertyValueFactory<>("callDate"));
//        TableColumn<CallList, Integer> dept = new TableColumn<>("部门");
//        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
//        TableColumn<CallList, Integer> group = new TableColumn<>("小组");
//        group.setCellValueFactory(new PropertyValueFactory<>("group"));
//        TableColumn<CallList, Integer> orderNumber = new TableColumn<>("计划号");
//        orderNumber.setCellValueFactory(new PropertyValueFactory<>("schemeNumbe"));
//        TableColumn<CallList, Integer> styleNumber = new TableColumn<>("款号");
//        styleNumber.setCellValueFactory(new PropertyValueFactory<>("styleNo"));
//        TableColumn<CallList, String> callparts = new TableColumn<>("部位");
//        callparts.setCellValueFactory(new PropertyValueFactory<>("parts"));
//        TableColumn<CallList, Integer> callcolor = new TableColumn<>("颜色");
//        callcolor.setCellValueFactory(new PropertyValueFactory<>("Color"));
//        TableColumn<CallList, Integer> vatno = new TableColumn<>("缸号");
//        vatno.setCellValueFactory(new PropertyValueFactory<>("vatNo"));
//        TableColumn<CallList, Integer> size = new TableColumn<>("尺码");
//        size.setCellValueFactory(new PropertyValueFactory<>("size"));
//        TableColumn<CallList, Integer> NeedDate = new TableColumn<>("需求日期");
//        NeedDate.setCellValueFactory(new PropertyValueFactory<>("NeedDate"));
//        TableColumn<Orders, Integer> Number = new TableColumn<>("需求数量");
//        Number.setCellValueFactory(new PropertyValueFactory<>("Number"));
//        TableColumn submitCol = new TableColumn("操作");
//
//
//        //让列宽 自动适配
//
////            no.setPrefWidth(50.0d);
////            state.setPrefWidth(50.0d);
////            callDate.setPrefWidth(60.0d);
////            dept.setPrefWidth(50.0d);
////            group.setPrefWidth(50.0d);
////            orderNumber.setPrefWidth(50.0d);
////            styleNumber.setPrefWidth(50.0d);
////            callparts.setPrefWidth(50.0d);
////            callcolor.setPrefWidth(50.0d);
////            size.setPrefWidth(50.0d);
////            vatno.setPrefWidth(50.0d);
////            size.setPrefWidth(50.0d);
////            NeedDate.setPrefWidth(60.0d);
////            Number.setPrefWidth(70.0d);
//
//
//        no.setResizable(false);
//        state.setResizable(false);
//        callDate.setResizable(false);
//        dept.setResizable(false);
//        group.setResizable(false);
//        orderNumber.setResizable(false);
//        styleNumber.setResizable(false);
//        callparts.setResizable(false);
//        callcolor.setResizable(false);
//        size.setResizable(false);
//        vatno.setResizable(false);
//        size.setResizable(false);
//        NeedDate.setResizable(false);
//        Number.setResizable(false);
//
//        callDate.setStyle("-fx-alignment: CENTER;");
//        dept.setStyle("-fx-alignment: CENTER;");
//        group.setStyle("-fx-alignment: CENTER;");
//        orderNumber.setStyle("-fx-alignment: CENTER;");
//        styleNumber.setStyle("-fx-alignment: CENTER;");
//        callparts.setStyle("-fx-alignment: CENTER;");
//        callcolor.setStyle("-fx-alignment: CENTER;");
//        vatno.setStyle("-fx-alignment: CENTER;");
//        size.setStyle("-fx-alignment: CENTER;");
//        NeedDate.setStyle("-fx-alignment: CENTER;");
//        Number.setStyle("-fx-alignment: CENTER;");
//
//
//
//
//        /**
//         * 绑定列到tableview 中
//         */
//        calllist.getColumns().add(no);
//        calllist.getColumns().add(state);
//        calllist.getColumns().add(callDate);
//        calllist.getColumns().add(dept);
//        calllist.getColumns().add(group);
//        calllist.getColumns().add(orderNumber);
//        calllist.getColumns().add(styleNumber);
//        calllist.getColumns().add(callparts);
//        calllist.getColumns().add(callcolor);
//        calllist.getColumns().add(vatno);
//        calllist.getColumns().add(size);
//        calllist.getColumns().add(NeedDate);
//        calllist.getColumns().add(Number);
//
//
//
//
//
//
//        TableView calltable = new TableView();
////        ScrollPane sc =new ScrollPane(manufacturOrderTable);
//        //获取屏幕宽度
////        double screenwidth= Screen.getPrimary().getBounds().getWidth();--  javafx
//        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
//        //获取屏幕高度
////        double screenheight=Screen.getPrimary().getBounds().getHeight();-- javafx
//        double height = Toolkit.getDefaultToolkit().getScreenSize().height;
//        calltable.setPrefHeight(height - 60);
//        calltable.setPrefWidth((width - 60));
//        calltable.setPrefSize(width-60,height-60);
//        calllist.setPrefSize(width-400,height-60);
//
//        TableColumn<Orders, Integer> NO = new TableColumn<>("序号");
//        NO.setCellValueFactory(new PropertyValueFactory<>("No"));
//        //上面是使用的自带的CellFactory，通常情况下应该是足够我们用的，但很多时候我们需要显示一些自定义的东西，那么就需要自定义Cell了。
//        // 自定义表格控件   如果为0   展示一个TextFiled  0,1
//        /**
//         * 上面是使用的自带的CellFactory，通常情况下应该是足够我们用的，但很多时候我们需要显示一些自定义的东西，那么就需要自定义Cell了。
//         *
//         * 自定义  CellFactory
//         */
////            state.setCellFactory(new Callback<TableColumn<Orders, Integer>, TableCell<Orders, Integer>>() {
////                @Override
////                public TableCell<Orders, Integer> call(TableColumn<Orders, Integer> param) {
////                    return new TableCell<Orders, Integer>() {
////                        private TextField open = new TextField("OPEN/生产中");
////
////                        private TextField closed = new TextField("CLOSED/关闭");
////
////                        @Override
////                        protected void updateItem(Integer item, boolean empty) {
////                            super.updateItem(item, empty);
////                            if (empty || item == null) {
////                                setText(null);
////                                setGraphic(null);
////
////                            } else {
////                                int a = item.intValue();
////                                if (a == 0) {
////                                    open.setPrefWidth(15);
////                                    open.setStyle("-fx-text-fill: gray;-fx-background-color: deeppink;-fx-alignment: center");
////
////
////
////                                    this.setGraphic(open);
////
////                                } else {
////                                    closed.setPrefWidth(15);
////                                    closed.setStyle("-fx-text-fill: gray;-fx-background-color:springgreen;-fx-alignment: center");
////                                    setGraphic(closed);
////                                }
////                            }
////                        }
////
//////                        int  a =item.intValue();
//////                        if (a!=null || a) {
//////                            this.setGraphic(open);
//////
//////                        } if(a==1){
//////                            setGraphic(closed);
//////                        }
//////                        else {
//////                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//////                            alert.setTitle("Age Info");
//////                            alert.setHeaderText(null);
//////                            alert.setContentText("This person is over 30 years old.");
////
////
////
////
////
////
////                        // Javafx: TableView根据列值更改行颜色
////
////
//////                    @Override
//////                    protected void updateItem(Integer item, boolean empty) {
//////                        super.updateItem(item, empty);
//////
//////                        setText(empty ? "" : getItem().toString());
//////                        setGraphic(null);
//////
//////                        TableRow<Orders> currentRow = getTableRow();
//////
//////                        if (!isEmpty()) {
//////
//////                            if(item.equals("0"))
//////                                currentRow.setStyle("-fx-background-color:lightcoral");
//////                            else
//////                                currentRow.setStyle("-fx-background-color:lightgreen");
//////                        }
//////                    }
////                    };
////
////
////                }
////
////
////            });
//        TableColumn<Orders, String> createDate = new TableColumn<>("入库日期");
//        createDate.setCellValueFactory(new PropertyValueFactory<>("createDate"));
//        TableColumn<Orders, String> code = new TableColumn<>("仓库编码");
//        code.setCellValueFactory(new PropertyValueFactory<>("code"));
//        TableColumn<Orders, String> codename = new TableColumn<>("仓库名称");
//        codename.setCellValueFactory(new PropertyValueFactory<>("codeName"));
//        TableColumn<Orders, Integer> order = new TableColumn<>("计划号");
//        order.setCellValueFactory(new PropertyValueFactory<>("schemeNumbe"));
//        TableColumn<Orders, String> style = new TableColumn<>("款号");
//        style.setCellValueFactory(new PropertyValueFactory<>("styleNo"));
//        TableColumn<Orders, String> styleSort = new TableColumn<>("款式");
//        styleSort.setCellValueFactory(new PropertyValueFactory<>("style_sort"));
//        TableColumn<Orders, String> partname = new TableColumn<>("部位");
//        partname.setCellValueFactory(new PropertyValueFactory<>("parts"));
//        TableColumn<Orders, String> maincolor = new TableColumn<>("主颜色");
//        maincolor.setCellValueFactory(new PropertyValueFactory<>("main_color_name"));
//        TableColumn<Orders,String> colorno = new TableColumn<>("颜色");
//        colorno.setCellValueFactory(new PropertyValueFactory<>("color_name"));
//        TableColumn<Orders, String> colorcode = new TableColumn<>("色号");
//        colorcode.setCellValueFactory(new PropertyValueFactory<>("color_no"));
//        TableColumn<Orders, String> vat = new TableColumn<>("缸号");
//        vatno.setCellValueFactory(new PropertyValueFactory<>("vat_no"));
//        TableColumn<Orders, String> Size = new TableColumn<>("尺码");
//        size.setCellValueFactory(new PropertyValueFactory<>("size"));
//        TableColumn<Orders, Integer> wip = new TableColumn<>("库存");
//        wip.setCellValueFactory(new PropertyValueFactory<>("wip"));
//
//
//
//
////            NO.setResizable(false);
////            createDate.setResizable(false);
////            order.setResizable(false);
////            style.setResizable(false);
////            styleSort.setResizable(false);
////            partname.setResizable(false);
////            maincolor.setResizable(false);
////            colorno.setResizable(false);
////            colorcode.setResizable(false);
////            size.setResizable(false);
////            vat.setResizable(false);
////            Size.setResizable(false);
////            wip.setResizable(false);
//
//
//        code.setStyle("-fx-alignment: CENTER;");
//        codename.setStyle("-fx-alignment: CENTER;");
//        order.setStyle("-fx-alignment: CENTER;");
//        style.setStyle("-fx-alignment: CENTER;");
//        styleSort.setStyle("-fx-alignment: CENTER;");
//        partname.setStyle("-fx-alignment: CENTER;");
//        maincolor.setStyle("-fx-alignment: CENTER;");
//        colorno.setStyle("-fx-alignment: CENTER;");
//        colorcode.setStyle("-fx-alignment: CENTER;");
//        size.setStyle("-fx-alignment: CENTER;");
//        vat.setStyle("-fx-alignment: CENTER;");
//        Size.setStyle("-fx-alignment: CENTER;");
//        wip.setStyle("-fx-alignment: CENTER;");
//
//
//
//
//        /**
//         * 绑定列到tableview 中
//         */
//        NO.setPrefWidth(50);
//        calltable.getColumns().add(NO);
//        calltable.getColumns().add(createDate);
//        calltable.getColumns().add(code);
//        calltable.getColumns().add(codename);
//        calltable.getColumns().add(order);
//        calltable.getColumns().add(style);
//        calltable.getColumns().add(styleSort);
//        calltable.getColumns().add(partname);
//        calltable.getColumns().add(maincolor);
//        calltable.getColumns().add(colorno);
//        calltable.getColumns().add(colorcode);
//        calltable.getColumns().add(vatno);
//        calltable.getColumns().add(size);
//        calltable.getColumns().add(wip);
////        manufacturOrderTable.getColumns().add(submitCol);   添加删除按键
//
//
//
//
//
//        select.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//                LocalDate startdate = startdateField.getValue();
//                LocalDate enddate = enddateField.getValue();
//                String styleNumber = styleField.getText();
//                String orderNumber = orderField.getText();
//                HashMap<Object, Object> map = new HashMap<>();
//                map.put("startdate", startdate);
//                map.put("enddate", enddate);
//                map.put("styleNumber", styleNumber);
//                map.put("orderNumber", orderNumber);
//                String json = JSON.toJSONString(map);
//                String data=null;
//                data = HttpUrlConnect.doPost("http://10.32.24.85:8010/web/Inventory", json);
//                System.out.println(data);
//                if (data == null&&data=="") {
//
//                    NConnectDBView.inforDialog();
//
//                } else {
//                    List<SuperMarketWip> wips = TransferUtils.parseJsonToSuperMarketWip(data);
//                    ObservableList<SuperMarketWip> result = FXCollections.observableArrayList(wips);
//
//                    calltable.setItems(result);
//
////               ObservableList<Person> data = FXCollections.observableArrayList(persons);
////                tableView.setItems(data);
////              System.out.println(params);
//
//
//                }
//
    public FinishProductScanView(){
//        hBox= new HBox();
//        Label startdate = new Label("开始日期");
//        DatePicker startdateField = new DatePicker();
//        Label enddate = new Label("结束日期");
//        DatePicker enddateField = new DatePicker();
//        Label style_no = new Label("系统款号");
//        TextField styleField = new TextField();
//        Label order_no = new Label("计划号");
//        TextField orderField = new TextField();
//        hBox.setSpacing(10);
//        Button select = new Button("查询");
//        select.setPrefWidth(100);
//        hBox.getChildren().addAll(startdate,startdateField,enddate,enddateField,style_no,styleField,order_no,orderField,select);
//        hBox.setPadding(new Insets(20,5,20,5));
        hBox=new HBox();
        Label sDate = new Label("开始日期");
        DatePicker sdp= new DatePicker();
        Label eDate = new Label("结束日期");
        DatePicker edp = new DatePicker();
        Label style = new Label("系统款号");
        TextField styleField = new TextField();
        Label order = new Label("计划号");
        TextField orderField = new TextField();
        Button query = new Button("查询");
        query.setPrefWidth(100);
        hBox.getChildren().addAll(sDate,sdp,eDate,edp,style,styleField,order,orderField,query);
        hBox.setPadding(new Insets(20,5,20,5));
        hBox.setSpacing(20);

        this.getChildren().add(hBox);

    }

}