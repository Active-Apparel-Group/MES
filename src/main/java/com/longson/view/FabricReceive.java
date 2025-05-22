package com.longson.view;

import com.longson.pojo.PojoMaterialProcess;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.text.DecimalFormat;

/**
 * 面料接收查询页面
 */
public class FabricReceive extends VBox {


    public FabricReceive() {
//            Stage  primaryStage=new Stage();

        // 创建一个表格视图
        TableView<PojoMaterialProcess> tableView = new TableView<>();


//        Tableview<mianpojoMaterialProcess> maintable = new Tableview();


        // 创建列
        TableColumn<PojoMaterialProcess, String> column1 = new TableColumn<>("序号");
        column1.setCellValueFactory(new PropertyValueFactory<>("No"));
        TableColumn<PojoMaterialProcess, String> column2 = new TableColumn<>("客户款号");
        column2.setCellValueFactory(new PropertyValueFactory<>("customer_style_no"));
        TableColumn<PojoMaterialProcess,String> column3=new TableColumn<>("系统款号");
        column3.setCellValueFactory(new PropertyValueFactory<>("style_no") );
        TableColumn<PojoMaterialProcess,String> color=new TableColumn<>("物料颜色");
        color.setCellValueFactory(new PropertyValueFactory<>("color") );
        TableColumn<PojoMaterialProcess, String> column4 = new TableColumn<>("物料名称");
        column4.setCellValueFactory(new PropertyValueFactory<>("Material_name"));
        TableColumn<PojoMaterialProcess, String> column5 = new TableColumn<>("物料代码");
        column5.setCellValueFactory(new PropertyValueFactory<>("Material_code"));
        TableColumn<PojoMaterialProcess,String> column6=new TableColumn<>("物料描述");
        column6.setCellValueFactory(new PropertyValueFactory<>("material_descripe") );
        TableColumn<PojoMaterialProcess,String> unit=new TableColumn<>("订单单耗");
        unit.setCellValueFactory(new PropertyValueFactory<>("unit") );
        TableColumn<PojoMaterialProcess,String> plan_phr=new TableColumn<>("计划用量/m");
        plan_phr.setCellValueFactory(new PropertyValueFactory<>("plan_phr") );
        TableColumn<PojoMaterialProcess,String>  in_phr=new TableColumn<>("初入库量/m");
        in_phr.setCellValueFactory(new PropertyValueFactory<>("phr") );
        TableColumn<PojoMaterialProcess,String> check_phr=new TableColumn<>("IQC 检验/m");
        check_phr.setCellValueFactory(new PropertyValueFactory<>("IQC_check") );
        TableColumn<PojoMaterialProcess,Double> check_in=new TableColumn<>("入库量/m");
        check_in.setCellValueFactory(new PropertyValueFactory<>("Check_in") );
        TableColumn<PojoMaterialProcess,Double> process=new TableColumn<>("进度");
        process.setCellFactory(ProgressBarTableCell.forTableColumn());
        TableColumn<PojoMaterialProcess,Double> precentage=new TableColumn<>("完成进度%");
        precentage.setCellValueFactory(new PropertyValueFactory<>("precentage") );
//        process.setCellFactory(new Callback<TableColumn<PojoMaterialProcess, Double>, TableCell<PojoMaterialProcess, Double>>() {
//            @Override
//            public TableCell<PojoMaterialProcess, Double> call(TableColumn<PojoMaterialProcess, Double> param) {
//                return  new TableCell<>();
////                System.out.println(param);
////                String message=TableColumn<v>
//            }
//        });
        process.setCellValueFactory(new PropertyValueFactory<>("progress") );



        // 设置列宽
        column1.setPrefWidth(100.0d);
        column2.setPrefWidth(100.0d);
        column6.setPrefWidth(200);
        column1.setStyle( "-fx-alignment: CENTER;");
        column2.setStyle( "-fx-alignment: CENTER;");
        column3.setStyle( "-fx-alignment: CENTER;");
        column4.setStyle( "-fx-alignment: CENTER;");
        column5.setStyle( "-fx-alignment: CENTER;");
        column6.setStyle( "-fx-alignment: CENTER;");
        unit.setStyle( "-fx-alignment: CENTER;");
        plan_phr.setStyle( "-fx-alignment: CENTER;");
        in_phr.setStyle( "-fx-alignment: CENTER;");
        check_phr.setStyle( "-fx-alignment: CENTER;");
        check_in.setStyle( "-fx-alignment: CENTER;");
        color.setStyle( "-fx-alignment: CENTER;");
        process.setStyle( "-fx-alignment: CENTER;");
        precentage.setStyle( "-fx-alignment: CENTER;");



        // 添加列
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(color);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(unit);
        tableView.getColumns().add(plan_phr);
        tableView.getColumns().add(in_phr);
        tableView.getColumns().add(check_phr);
        tableView.getColumns().add(check_in);
        tableView.getColumns().add(process);
        tableView.getColumns().add(precentage);


        // tableView.getColumns().addAll(column1, column2);

        // 无行数据显示时的占位符
        tableView.setPlaceholder(new Label("No Data"));

        Button addLine = new Button("Add");
        Button addnumber = new Button("+");
        Button reduce=new Button("-");
        TextField textField = new TextField();
        Label label = new Label("1");
        label.setStyle("-fx-font-size:20 ");
        DecimalFormat decFormat = new DecimalFormat("#%");

        addLine.setOnMouseClicked((event) -> {
            // 添加行数据
            tableView.getItems().add(new PojoMaterialProcess(1,"092402","092402A","双面磨毛","DPS022J-0001","双面磨毛|白色/全幅160CM/净幅155CM/克重215GSM",0.82,110,100,80,75,"白色",0.92,decFormat.format(0.92) ));
            tableView.getItems().add(new PojoMaterialProcess(2,"092402","092402A","260T涤纶内里","VPO005-4539","260T涤纶内里|丈青2768C/全幅151CM/净幅146CM/克重65GSM",0.82,120,50,50,50,"烟草色RYE",0.4,decFormat.format(0.4)));
            tableView.getItems().add(new PojoMaterialProcess(3,"092402","092402A","2*2罗纹","RCOS001-7000","2*2罗纹|黑/全幅120CM/净幅115CM/克重245GSM",0.82,110,100,100,100,"白色",0.57,decFormat.format(0.57) ));



        });




        Button singleSelect = new Button("SingleMode");
        singleSelect.setOnMouseClicked((event) -> {
            // 设置选择模式为单行
            tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        });
        Button multiSelect = new Button("MultipleMode");
        multiSelect.setOnMouseClicked((event) -> {
            // 设置多行选择模式
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        });
        addnumber.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String s =label.getText();
                int i =Integer.parseInt(s);
                if(i!=0){
                    i= i+1;
                }
                String number=Integer.toString(i);
                label.setText(number);

            }
        });
        reduce.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String s=label.getText();
                int i =Integer.parseInt(s);
                if(i!=0){
                    i= i-1;
                }
                String number=Integer.toString(i);
                label.setText(number);
            }
        });
//        textField.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//
//                String s=textField.getText();
//                int length=s.length();
//                if(length==16){
//                if(s.equals("72-154896-07ZHCN")){
//                    String number=label.getText();
//                    int i =Integer.parseInt(number);
//                    if(i!=0){
//                        i= i-1;
//                    }
//                    String reality=Integer.toString(i);
//                    label.setText(reality);
//                    textField.clear();
//                }else{
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error Dialog");
//                    alert.setHeaderText("Look, an Error Dialog");
//                    alert.setContentText("Ooops, there was an error!");
//
//                    alert.showAndWait();
//                }}
//                else {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error Dialog");
//                    alert.setHeaderText("Look, an Error Dialog");
//                    alert.setContentText("字符编码错误!");
//
//                    alert.showAndWait();
//                }
//                }
//
//
//        });

        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                      @Override
                                      public void handle(KeyEvent event) {
                                          if (event.getCode() == KeyCode.ENTER) {
                                              String s = textField.getText();
                                              if (s.equals("72-154896-07ZHCN")) {
                                                  String number = label.getText();
                                                  int i = Integer.parseInt(number);
                                                  if (i != 0) {
                                                      i = i +1;
                                                  }
                                                  String reality = Integer.toString(i);
                                                  label.setText(reality);
                                                  textField.clear();
                                              } else {
                                                  Alert alert = new Alert(Alert.AlertType.ERROR);
                                                  alert.setTitle("Error Dialog");
                                                  alert.setHeaderText("The text information scanned by the system does not match");
                                                  alert.setContentText("Ooops, there was an error!");

                                                  alert.showAndWait();
                                              }
                                          }
                                      }
                                  }
        );




        // 界面
        HBox topBar = new HBox();
        topBar.getChildren().addAll(addLine, singleSelect, multiSelect, addnumber, reduce, textField);
//                VBox body = new VBox(tableView);
        AnchorPane anchorPane = new AnchorPane();

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.getChildren().addAll(topBar, label);
        vbox.setLayoutX(0);
        vbox.setLayoutY(0);
        tableView.setLayoutX(0);
        tableView.setLayoutY(60);
//            tableView.setPrefSize(1920,920);
        tableView.setPrefSize(1780,850);
//           anchorPane.getChildren().addAll(vbox,tableView);

        this.getChildren().addAll(vbox,tableView);
        //焦点监听事件
        this.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (isNowFocused) {
                System.out.println("获取焦点");
            } else {
                System.out.println("失去焦点");
            }
        });



        /** TOOLBar  ****增加水平分割线
         * Button button1 = new Button("Button 1");
         * toolBar.getItems().add(button1);
         *
         * toolBar.getItems().add(new Separator());
         *
         * Button button2 = new Button("Button 2");
         * toolBar.getItems().add(button2);
         */

//            primaryStage.setScene(scene);
//            primaryStage.setWidth(480.0d);
//            primaryStage.setHeight(320.0d);
//            primaryStage.setTitle("Active Apparel Group");
////                primaryStage.getIcons().add();  设置 窗口图标
//            primaryStage.show();
    }


    public class Person {
        private String name;
        private int age;
        private int code;

        public Person(String name, int age, int code) {
            this.setName(name);
            this.setAge(age);
            this.setCode(code);

        }

        /**
         * Get age value
         *
         * @return the age
         */
        public int getAge() {
            return age;
        }

        /**
         * Set age to age
         *
         * @param age the age to set
         */
        public void setAge(int age) {
            this.age = age;
        }

        /**
         * Get name value
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Set name to name
         *
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }


}



