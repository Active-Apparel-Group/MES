package com.longson.view;
import com.alibaba.fastjson.JSON;
import com.longson.pojo.Dept;
import com.longson.pojo.SuperMarketWip;
import com.longson.utils.HttpUrlConnect;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class AlertWindow {

    /**
     * 生产管理--》 裁片呼叫 弹窗
     *
     *     @Override
     *     public void handle(WindowEvent event) {
     *         System.out.println("4 - 窗口正在加载...");
     *     }
     * });
     *         stage.setOnShown(new EventHandler<WindowEvent>() {
     * @Override
     * public void handle(WindowEvent event) {
     *         System.out.println("6 - 窗口加载完成!");
     *         }
     *         });
     *         stage.heightProperty().addListener(new ChangeListener<Number>() {
     * @Override
     * public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
     *         System.out.println("5 - ChangeListener 窗口高度变化监听");
     *         }
     */






    public AlertWindow(Dept dept, SuperMarketWip wip){
//        AlertWindow.display("CuttingCall","是否关闭");

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Label line = new Label("Line");
        TextField jtline=new TextField();
        jtline.setEditable(false);
        jtline.setPrefWidth(100);
        jtline.setText(dept.getLine());
        Label labledept = new Label("Dept");
        TextField jtdept=new TextField();
        jtdept.setEditable(false);
        jtdept.setPrefWidth(100);
        jtdept.setText(dept.getDept());
        Label date=new Label("Date");
        DatePicker dpDate=new DatePicker();


        dpDate.setPrefWidth(130);
        Label number=new Label("Number");
        TextField jtnumber=new TextField();
        jtnumber.setPrefWidth(100);

        HBox fhbox=new HBox();
        fhbox.getChildren().addAll(labledept,jtdept,line,jtline);

        fhbox.setMargin(line,new Insets(5,12,5,50));
        fhbox.setMargin(labledept,new Insets(5,5,5,5));
        fhbox.setSpacing(5);

        HBox shbox=new HBox();
        shbox.getChildren().addAll(date,dpDate,number,jtnumber);
        shbox.setSpacing(5);
        shbox.setMargin(number,new Insets(5,5,5,10));
        shbox.setMargin(date,new Insets(5,5,5,5));

        HBox tbox=new HBox();
        Button conform= new Button("Confirm");
        tbox.getChildren().add(conform);
        tbox.setAlignment(Pos.BOTTOM_RIGHT);
        shbox.setMargin(conform,new Insets(10,10,10,10));


        conform.setOnMouseClicked(new EventHandler<MouseEvent>() {

//            String username=name.getText().trim();
//            String password=passwordField.getText().trim();
//            HashMap<Object, Object> map = new HashMap<>();
//                    map.put("username",username);
//                    map.put("password",password);
//            String json= JSON.toJSONString(map);
//            String data = HttpURLConnect.doPost("http://localhost:8010/web/applogin", json);
            @Override
            public void handle(MouseEvent event) {


                //   localDate-->转 Date
                LocalDate date=dpDate.getValue();
                Instant instant = date.atTime(LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault()).toInstant();
                Date indate = Date.from(instant);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                String needdate=dateFormat.format(indate);

                String deptment=jtdept.getText().trim();
                String line=jtline.getText().trim();
                String order=wip.getSchemeNumbe();
                String style=wip.getStyleNo().trim();
                String parts=wip.getParts().trim();
                String color=wip.getColor_name().trim();
                String vat=wip.getVat_no().trim();
                String size=wip.getSize().trim();

                int number=Integer.parseInt(jtnumber.getText().trim());
                Calendar calendar = Calendar.getInstance();

                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time=sdf.format(calendar.getTime());
                String employee=dept.getEmployee().trim();

                HashMap<Object, Object> map = new HashMap<>();
                map.put("time",time);
                map.put("deptment",deptment);
                map.put("line",line);
                map.put("order",order);
                map.put("style",style);
                map.put("parts",parts);
                map.put("color",color);
                map.put("vat",vat);
                map.put("size",size);
                map.put("needdate",needdate);
                map.put("number",number);
                map.put("employee",employee);

                String json= JSON.toJSONString(map);
                String data = HttpUrlConnect.doPost("http://localhost:8010/web/applogin", json);


            }
        });







//        btn1.setOnMouseClicked(event -> {
//            res = true;
//            System.out.println("你点击了是");
//            stage.close();
//        });
//        btn2.setOnMouseClicked(event -> {
//            res = false;
//            System.out.println("你点击了否");
//            stage.close();
//        });
        VBox vBox = new VBox();
        vBox.getChildren().addAll(fhbox,shbox,tbox);

        vBox.setMargin(fhbox,new Insets(15,0,10,0));

        //设置居中
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setStyle("-fx-background-color:ghostwhite");
        Scene scene = new Scene(vBox, 350, 120);
        /**
         * 绑定快捷键
         *
         */
//        KeyCombination kc1 = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);
//        Mnemonic mnemonic1 = new Mnemonic(jtnumber,kc1);
//        scene.addMnemonic(mnemonic1);

//        Platform.runLater(() -> jtdept.requestFocus());


        KeyCombination kccb = new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN);
        scene.getAccelerators().put(kccb, new Runnable() {//其实还是当前线程执行
            @Override
            public void run() {
                System.out.println("Run方法的执行者 = " + Thread.currentThread().getName());
            }
        });



        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);

        stage.setTitle("Call Back");
        stage.showAndWait();





    }












//    public static boolean display(String title,String msg){
//        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        Label label = new Label();
//        label.setText(msg);
//        Label line = new Label("Line");
//        TextField jtline=new TextField();
//        jtline.setPrefWidth(100);
//        jtline.setText();
//        Label dept = new Label("DEPT");
//        TextField jtdept=new TextField();
//        jtdept.setPrefWidth(100);
//        Label date=new Label("Date");
//        DatePicker dpDate=new DatePicker();
//        dpDate.setPrefWidth(130);
//        Label number=new Label("Number");
//        TextField jtnumber=new TextField();
//        jtnumber.setPrefWidth(100);
//
//        HBox fhbox=new HBox();
//        fhbox.getChildren().addAll(dept,jtdept,line,jtline);
//
//        fhbox.setMargin(line,new Insets(5,12,5,50));
//        fhbox.setMargin(dept,new Insets(5,5,5,5));
//        fhbox.setSpacing(5);
//
//        HBox shbox=new HBox();
//        shbox.getChildren().addAll(date,dpDate,number,jtnumber);
//        shbox.setSpacing(5);
//        shbox.setMargin(number,new Insets(5,5,5,10));
//        shbox.setMargin(date,new Insets(5,5,5,5));
//
//
//
//
//
////        btn1.setOnMouseClicked(event -> {
////            res = true;
////            System.out.println("你点击了是");
////            stage.close();
////        });
////        btn2.setOnMouseClicked(event -> {
////            res = false;
////            System.out.println("你点击了否");
////            stage.close();
////        });
//        VBox vBox = new VBox();
//        vBox.getChildren().addAll(fhbox,shbox);
//        vBox.setMargin(fhbox,new Insets(15,0,20,0));
//        //设置居中
//        vBox.setAlignment(Pos.BASELINE_CENTER);
//        vBox.setStyle("-fx-background-color:ghostwhite");
//        Scene scene = new Scene(vBox, 350, 100);
//
//
//        stage.setScene(scene);
//        stage.setMaximized(false);
//        stage.setResizable(false);
//        stage.initStyle(StageStyle.UTILITY);
//
//        stage.setTitle(title);
//        stage.showAndWait();
//
//        return res;
//
//
//        }

}
