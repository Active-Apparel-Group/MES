package com.longson.view;

import com.alibaba.fastjson.JSON;
import com.longson.pojo.Orders;

import com.longson.utils.HttpUrlConnect;
import com.longson.utils.TransferUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * 制造订单主页面
 */
public class ManufacturOrder extends VBox {
    private VBox vbox;
    private VBox vbox2;
    private VBox vbox3;
    private VBox vbox4;
    private VBox vbox5;
    private VBox vbox6;
    private VBox vbox7;
    private VBox vbox8;
    private HBox hBox;

    public ManufacturOrder() {
        vbox = new VBox();

        Label startdate = new Label("开始日期");
        DatePicker startdateField = new DatePicker();

        Label customersystemlabel = new Label("客户款号");
        vbox.getChildren().addAll(startdate, customersystemlabel);
        vbox.setSpacing(18);


//        systemtextfield.setStyle("-fx-background-color: lightgrey");
        TextField customersystemtextfield = new TextField();
//        customersystemtextfield.setStyle("-fx-background-color: lightgrey");
        vbox2 = new VBox();
        vbox2.setSpacing(10);
        vbox2.getChildren().addAll(startdateField, customersystemtextfield);
        vbox3 = new VBox();
        Label endDate = new Label("结束日期");
        vbox3.setSpacing(18);
        Label styleNo = new Label("系统款号");


        vbox4 = new VBox();
        DatePicker endDateTextField = new DatePicker();
        TextField styleTextfield = new TextField();

        vbox4.setSpacing(10);
        vbox3.getChildren().addAll(endDate, styleNo);
        vbox4.getChildren().addAll(endDateTextField, styleTextfield);

        vbox5 = new VBox();
        vbox6 = new VBox();
        vbox7 = new VBox();
        vbox8 = new VBox();
        Label scheme = new Label("计划号");
        Label Customer = new Label("客户");
        Label factorylabel = new Label("Loc");
//         Image image = new Image("images/icon4.png");
        Button select = new Button("查询");
        select.setPrefWidth(100);
//         query.setGraphic(new ImageView(image));

        TextField schemetext = new TextField();
        TextField customertext = new TextField();
        ComboBox factory = new ComboBox<>();

        factory.getItems().addAll("嘉乐生产A部", "嘉乐生产B部", "嘉乐生产C部");
        factory.getSelectionModel().select(0);
        vbox5.getChildren().addAll(scheme, Customer);
        vbox5.setSpacing(18);
        vbox6.getChildren().addAll(schemetext, customertext);
        vbox6.setSpacing(10);
        vbox7.getChildren().addAll(factorylabel);
        vbox7.setSpacing(18);
        vbox8.getChildren().addAll(factory, select);
        vbox8.setSpacing(10);


        hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(vbox, vbox2, vbox3, vbox4, vbox5, vbox6, vbox7, vbox8);
        hBox.setMargin(vbox, new Insets(12, 5, 10, 5));
        hBox.setMargin(vbox2, new Insets(10, 5, 10, 10));
        hBox.setMargin(vbox3, new Insets(12, 5, 10, 20));
        hBox.setMargin(vbox4, new Insets(10, 5, 10, 5));
        hBox.setMargin(vbox5, new Insets(12, 5, 10, 20));
        hBox.setMargin(vbox6, new Insets(10, 5, 10, 5));
        hBox.setMargin(vbox7, new Insets(12, 5, 10, 20));
        hBox.setMargin(vbox8, new Insets(10, 5, 10, 10));
        //设置内边距
        this.setPadding(new Insets(10));

        //创建查询实体对象

        TableView manufacturOrderTable = new TableView();
//        ScrollPane sc =new ScrollPane(manufacturOrderTable);
        //获取屏幕宽度
//        double screenwidth= Screen.getPrimary().getBounds().getWidth();--  javafx
        double width = Toolkit.getDefaultToolkit().getScreenSize().width;
        //获取屏幕高度
//        double screenheight=Screen.getPrimary().getBounds().getHeight();-- javafx
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;
        manufacturOrderTable.setPrefHeight(height-60);
        manufacturOrderTable.setPrefWidth(width - 60);

        TableColumn<Orders, Integer> state = new TableColumn<>("状态");
        state.setCellValueFactory(new PropertyValueFactory<>("state"));
        //上面是使用的自带的CellFactory，通常情况下应该是足够我们用的，但很多时候我们需要显示一些自定义的东西，那么就需要自定义Cell了。
        // 自定义表格控件   如果为0   展示一个TextFiled  0,1
        /**
        state.setCellFactory(new Callback<TableColumn<Orders, Integer>, TableCell<Orders, Integer>>() {
            @Override
            public TableCell<Orders, Integer> call(TableColumn<Orders, Integer> param) {
                return new TableCell<Orders, Integer>() {
                    private TextField open = new TextField("OPEN/生产中");

                    private TextField closed = new TextField("CLOSED/关闭");

                    @Override
                    protected void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                            setGraphic(null);

                        } else {
                            int a = item.intValue();
                            if (a == 0) {
                                open.setPrefWidth(15);
                                open.setStyle("-fx-text-fill: gray;-fx-background-color: deeppink;-fx-alignment: center");


                                this.setGraphic(open);

                            } else {
                                closed.setPrefWidth(15);
                                closed.setStyle("-fx-text-fill: gray;-fx-background-color:springgreen;-fx-alignment: center");
                                setGraphic(closed);
                            }
                        }
                    }

//                        int  a =item.intValue();
//                        if (a!=null || a) {
//                            this.setGraphic(open);
//
//                        } if(a==1){
//                            setGraphic(closed);
//                        }
//                        else {
//                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                            alert.setTitle("Age Info");
//                            alert.setHeaderText(null);
//                            alert.setContentText("This person is over 30 years old.");


                    // Javafx: TableView根据列值更改行颜色


//                    @Override
//                    protected void updateItem(Integer item, boolean empty) {
//                        super.updateItem(item, empty);
//
//                        setText(empty ? "" : getItem().toString());
//                        setGraphic(null);
//
//                        TableRow<Orders> currentRow = getTableRow();
//
//                        if (!isEmpty()) {
//
//                            if(item.equals("0"))
//                                currentRow.setStyle("-fx-background-color:lightcoral");
//                            else
//                                currentRow.setStyle("-fx-background-color:lightgreen");
//                        }
//                    }
                };


            }


        });
        */
        TableColumn<Orders, Integer> code = new TableColumn<>("单据编号");
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        TableColumn<Orders, Integer> formDate = new TableColumn<>("单据日期");
        formDate.setCellValueFactory(new PropertyValueFactory<>("form_date"));
        TableColumn<Orders, Integer> dept = new TableColumn<>("部门");
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        TableColumn<Orders, Integer> orderNumber = new TableColumn<>("计划号");
        orderNumber.setCellValueFactory(new PropertyValueFactory<>("order_no"));
        TableColumn<Orders, Integer> styleNumber = new TableColumn<>("款号");
        styleNumber.setCellValueFactory(new PropertyValueFactory<>("style_no"));
        TableColumn<Orders, Integer> styleDescribe = new TableColumn<>("款式描述");
        styleDescribe.setCellValueFactory(new PropertyValueFactory<>("style_describe"));
        TableColumn<Orders, Integer> styleSort = new TableColumn<>("款式");
        styleSort.setCellValueFactory(new PropertyValueFactory<>("style_sort"));
        TableColumn<Orders, Integer> customer = new TableColumn<>("客户");
        customer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        TableColumn<Orders, Integer> customerNo = new TableColumn<>("客户款号");
        customerNo.setCellValueFactory(new PropertyValueFactory<>("customer_no"));
        TableColumn<Orders, Integer> number = new TableColumn<>("订单数量");
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        TableColumn<Orders, Integer> jobRatio = new TableColumn<>("成本系数");
        jobRatio.setCellValueFactory(new PropertyValueFactory<>("job_ratio"));
        TableColumn<Orders, Integer> createor = new TableColumn<>("创建人");
        createor.setCellValueFactory(new PropertyValueFactory<>("create_by"));
        TableColumn<Orders, Integer> createtime = new TableColumn<>("创建日期");
        createtime.setCellValueFactory(new PropertyValueFactory<>("create_time"));
        TableColumn<Orders, Integer> menoinfo = new TableColumn<>("计划组别");
        menoinfo.setCellValueFactory(new PropertyValueFactory<>("memo_infor"));
        TableColumn submitCol = new TableColumn("操作");
        submitCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new ButtonTableCell();
            }
        });


        state.setPrefWidth(100.0d);
        code.setPrefWidth(100.0d);
        styleDescribe.setPrefWidth(200);
        state.setStyle("-fx-alignment: CENTER;");
        code.setStyle("-fx-alignment: CENTER;");
        formDate.setStyle("-fx-alignment: CENTER;");
        dept.setStyle("-fx-alignment: CENTER;");
        styleNumber.setStyle("-fx-alignment: CENTER;");
        styleDescribe.setStyle("-fx-alignment: CENTER;");
        styleSort.setStyle("-fx-alignment: CENTER;");
        customer.setStyle("-fx-alignment: CENTER;");
        customerNo.setStyle("-fx-alignment: CENTER;");
        number.setStyle("-fx-alignment: CENTER;");
        jobRatio.setStyle("-fx-alignment: CENTER;");
        createor.setStyle("-fx-alignment: CENTER;");
        createtime.setStyle("-fx-alignment: CENTER;");
        menoinfo.setStyle("-fx-alignment: CENTER;");


        /**
         * 绑定列到tableview 中
         */
        manufacturOrderTable.getColumns().add(state);
        manufacturOrderTable.getColumns().add(code);
        manufacturOrderTable.getColumns().add(formDate);
        manufacturOrderTable.getColumns().add(dept);
        manufacturOrderTable.getColumns().add(orderNumber);
        manufacturOrderTable.getColumns().add(styleNumber);
        manufacturOrderTable.getColumns().add(styleDescribe);
        manufacturOrderTable.getColumns().add(styleSort);
        manufacturOrderTable.getColumns().add(customer);
        manufacturOrderTable.getColumns().add(customerNo);
        manufacturOrderTable.getColumns().add(number);
        manufacturOrderTable.getColumns().add(jobRatio);
        manufacturOrderTable.getColumns().add(createor);
        manufacturOrderTable.getColumns().add(createtime);
        manufacturOrderTable.getColumns().add(menoinfo);
//        manufacturOrderTable.getColumns().add(submitCol);   添加删除按键

        manufacturOrderTable.setRowFactory(tv -> {
            TableRow<Orders> row = new TableRow<>();
            row.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Orders or = row.getItem();
                    System.out.println(or);
                }
            });
            return row;
        });

//点击查询  调用数据接口
        select.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                     @Override
                                     public void handle(MouseEvent event) {

                                         LocalDate startdate = startdateField.getValue();
                                         LocalDate enddate = endDateTextField.getValue();
                                         HashMap<Object, Object> map = new HashMap<>();
                                         map.put("startdate", startdate);
                                         map.put("enddate", enddate);
                                         String json = JSON.toJSONString(map);
                                         String data = HttpUrlConnect.doPost("http://10.32.24.85:8010/web/ManufacturingOrder", json);

                                         List<Orders> orders = TransferUtils.parseJsonToOrders(data);
//               ObservableList<Person> data = FXCollections.observableArrayList(persons);
//                tableView.setItems(data);
//              System.out.println(params);


                                             ObservableList<Orders> result = FXCollections.observableArrayList(orders);
                                             manufacturOrderTable.setItems(result);

//                System.out.println(orders);


                                     }

                                 }

        );


//        sc.setPannable(true);

        this.getChildren().addAll(hBox, manufacturOrderTable);


    }


    //    上面是使用的自带的CellFactory，通常情况下应该是足够我们用的，但很多时候我们需要显示一些自定义的东西，那么就需要自定义Cell了。
    public class ButtonTableCell extends TableCell<Orders, String> {
        private Button submitBtn = new Button("删除");


        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                this.setGraphic(submitBtn);


            } else {
                setGraphic(null);
            }
        }
    }
}
//上面是使用的自带的CellFactory，通常情况下应该是足够我们用的，但很多时候我们需要显示一些自定义的东西，那么就需要自定义Cell了。
// 自定义表格控件   如果为0   展示一个TextFiled  0,1
