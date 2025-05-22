package com.longson.view;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longson.pojo.*;
import com.longson.utils.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class NptView extends VBox {


    private CheckBox wash;
    private CheckBox fixpiece;
    private CheckBox paint;
    private CheckBox fabricquestion;
    private CheckBox supplierissues;
    private CheckBox sample;
    private CheckBox second;
    private CheckBox cutquestion;
    private CheckBox bond;
    private CheckBox cottonissue;
    private CheckBox customerissue;
    private CheckBox other;

    private Map<String, ObservableList<String>> workshoptMap = new HashMap<>();
    private Map<String, ObservableList<String>> factoryMap = new HashMap<>();


    public NptView(String username) {

        HBox firsthbox = new HBox();
        Label label = new Label("流水号");
        TextField textField = new TextField();
        textField.setText(UtilsTime.getorderId());
        textField.setEditable(false);


        firsthbox.setMargin(label, new Insets(10, 10, 0, 10));
        firsthbox.setMargin(textField, new Insets(5, 10, 0, 10));
        firsthbox.getChildren().addAll(label, textField);

        HBox hBox = new HBox();
////RADIO Button 单例模式t
//        RadioButton  Wait=new RadioButton("waiting");
//        RadioButton  Train=new RadioButton("Train-off line");
//        RadioButton  Meet=new RadioButton("Meeting");
//        hBox.getChildren().add(Wait);
//        hBox.getChildren().add(Train);
//        hBox.getChildren().add(Meet);


        Line line1 = new Line();
        line1.setStroke(Color.GRAY);
        line1.setStartX(200.f);
        line1.setStartY(30.0f);
        line1.setEndX(400.0f);
        line1.setEndY(30.0f);


//radioButton 组合模式
        ToggleGroup Nptgroup = new ToggleGroup();
//布局二  设备 NPT  类型
        ToggleButton Nptwait = new ToggleButton("Waiting/等待");
        Nptwait.setStyle("-fx-background-color: lightgreen");

        Nptwait.setToggleGroup(Nptgroup);
        Nptwait.setSelected(true);
        final ToggleButton Nptmeet = new ToggleButton("Meeting/会议");
        Nptmeet.setStyle("-fx-background-color: pink");
        Nptmeet.setToggleGroup(Nptgroup);
        Nptmeet.setSelected(false);
        ToggleButton Npttrain = new ToggleButton("Train-off Line/培训");
        Npttrain.setToggleGroup(Nptgroup);
        //  增加水平方向分割线
        Line line2 = new Line();
        line2.setStroke(Color.GRAY);
        line2.setStartX(200.f);
        line2.setStartY(20.0f);
        line2.setEndX(1100.0f);
        line2.setEndY(20.0f);
        //布局一  设置 NPT 计算方式
        HBox hgroupbox = new HBox();
        ToggleGroup Npttype = new ToggleGroup();
        RadioButton hours = new RadioButton("计时");
        hours.setToggleGroup(Npttype);
        hours.setSelected(true);
        RadioButton piece = new RadioButton("计件");
        piece.setToggleGroup(Npttype);
        hgroupbox.setSpacing(20);
        hgroupbox.getChildren().addAll(hours, piece);

        hBox.getChildren().addAll(hgroupbox, Nptwait, Nptmeet, Npttrain);

        VBox vBox = new VBox();
        vBox.setSpacing(20);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        Label datelable = new Label("单据日期");
        TextField datetf = new TextField();
        datetf.setEditable(false);
        datetf.setText(formatter.format(date));

        //布局三 通过接口获取 所有人的 工厂 车间 组别  等 人事信息
        HBox chbox = new HBox();
        Label fa = new Label("工厂/Factory ");
        ComboBox cb = new ComboBox<>();
        Label ws = new Label("部门/Dept  ");
        ComboBox workshop = new ComboBox<>();
        Label dp = new Label("组别/Line  ");
        //更新GROUP  组件
        ComboBox group = new ComboBox<>();

        ObservableList<String> factoryGroupsA01 = FXCollections.observableArrayList("A01", "A02","A03","A04","A06","A08","A09","收发辅助");
        ObservableList<String> factoryGroupsA02 = FXCollections.observableArrayList("A05", "A07","A10","A11","A12");
        ObservableList<String> factoryGroupsAFinish = FXCollections.observableArrayList("后道整烫","后道烫标", "后道辅助","后道包装");
        ObservableList<String> factoryGroupsB01 = FXCollections.observableArrayList("B29", "B30","B31","B32","B33","B34","B34");
        ObservableList<String> factoryGroupsB02 = FXCollections.observableArrayList("B20", "B21","B22","B23","B24","B25", "B26","B27","B28");
        ObservableList<String> factoryGroupsBFinish = FXCollections.observableArrayList("后道整烫","后道烫标", "后道辅助","后道包装");
        ObservableList<String> factoryGroupsC= FXCollections.observableArrayList( "C01","C02","C03","C04","C05","C06","C07","C08","C09","C10","C11","C12","C13","C14","C15","C16");
        ObservableList<String> factoryGroupsCFinish = FXCollections.observableArrayList("61组", "62组","65组","66组","67组");
        ObservableList<String> factoryGroupsHH = FXCollections.observableArrayList("H01","H02", "H03");
        //通过指定的工厂

        workshoptMap.put("A车缝一组",factoryGroupsA01);
        workshoptMap.put("A车缝二组",factoryGroupsA02);
        workshoptMap.put("A后道",factoryGroupsAFinish);
        workshoptMap.put("B车缝一组",factoryGroupsB01);
        workshoptMap.put("B车缝二组",factoryGroupsB02);
        workshoptMap.put("B后道",factoryGroupsBFinish);
        workshoptMap.put("C车缝",factoryGroupsC);
        workshoptMap.put("C后道",factoryGroupsCFinish);
        workshoptMap.put("H车缝",factoryGroupsHH);

        ObservableList<String> workshopsA = FXCollections.observableArrayList("A车缝一组", "A车缝二组","A后道");
        ObservableList<String> workshopsB = FXCollections.observableArrayList("B车缝一组", "B车缝二组","B后道");
        ObservableList<String> workshopsC = FXCollections.observableArrayList("C车缝", "C后道");
        ObservableList<String> workshopsHH = FXCollections.observableArrayList("H车缝", "H后道");


        // 创建组别
         factoryMap.put("嘉乐生产A部",workshopsA);
         factoryMap.put("嘉乐生产B部",workshopsB);
         factoryMap.put("嘉乐生产C部",workshopsC);
         factoryMap.put("华汇生产部",workshopsHH);




// 通过点击工厂的选项，来更新workshop 视图

        cb.setItems(FXCollections.observableArrayList(factoryMap.keySet()));

        cb.valueProperty().addListener((obs, oldFactory, newFactory) -> {
            if (newFactory != null) {
                workshop.setItems(factoryMap.get(newFactory));
                // 清空组别ComboBox并禁用它
            }
        });







//        workshop.setItems(FXCollections.observableArrayList(factory.getWorkshops().));通过点击车间的选项更新组别视图
        workshop.valueProperty().addListener((obs, oldDepartment, newDepartment) -> {
            if (newDepartment != null && workshoptMap.containsKey(newDepartment)) {
                group.setItems(workshoptMap.get(newDepartment));
            } else {
                group.setItems(FXCollections.observableArrayList()); // 清空员工列表
            }
        });





        Button add = new Button("+");
        add.setPrefWidth(40);


        cb.getSelectionModel().selectFirst();
        workshop.getSelectionModel().selectFirst();
        group.getSelectionModel().selectFirst();


        chbox.getChildren().addAll(datelable, datetf, fa, cb, ws, workshop, dp, group, add);
        chbox.setSpacing(3);
        chbox.setMargin(datelable, new Insets(15, 0, 0, 10));
        chbox.setMargin(datetf, new Insets(12, 10, 0, 10));
        chbox.setMargin(fa, new Insets(15, 0, 0, 10));
        chbox.setMargin(cb, new Insets(12, 0, 0, 0));
        chbox.setMargin(ws, new Insets(15, 5, 0, 50));
        chbox.setMargin(workshop, new Insets(12, 0, 0, 0));
        chbox.setMargin(dp, new Insets(15, 5, 0, 50));
        chbox.setMargin(group, new Insets(12, 0, 0, 0));


//转出工厂
//        HBox roboc= new HBox();
//        Label rofa= new Label("转出工厂");
//        ChoiceBox rocb=new ChoiceBox();
//        rocb.setItems(FXCollections.observableArrayList("嘉乐生产A部","嘉乐生产B部","嘉乐生产C部"));
//        Label rows= new Label("转出车间");
//        ChoiceBox roworkshop= new ChoiceBox();
//        roworkshop.setItems(FXCollections.observableArrayList("B车缝一组","B车缝二组"));
//        Label rodp= new Label("转出部门");
//        ChoiceBox rodept= new ChoiceBox();
//        rodept.setItems(FXCollections.observableArrayList("A01","A02"));
//
//        Label roepcode= new Label("创建人");
//        ChoiceBox roep= new ChoiceBox();
//        roep.setItems(FXCollections.observableArrayList("35001张珊","34001李四","52018王五"));
//

//        roboc.getChildren().addAll(rofa,rocb,rows,roworkshop,rodp,rodept,roepcode,roep,add);
//
//
//
//
//        rocb.getSelectionModel().selectFirst();
//        roworkshop.getSelectionModel().selectFirst();
//        rodept.getSelectionModel().selectFirst();
//        roep.getSelectionModel().selectFirst();
//
//
//
//
//
//        roboc.setMargin(rofa,new Insets(5,10,11,10));
//        roboc.setMargin(rows,new Insets(5,10,11,50));
//        roboc.setMargin(rodp,new Insets(5,10,11,50));
//        roboc.setMargin(roepcode,new Insets(5,10,11,50));
//        roboc.setMargin(add,new Insets(5,10,11,200));

        //返工补贴原因归类
        HBox title = new HBox(10);
        Label titlelable = new Label("返工原因补贴归类");
        title.getChildren().addAll(titlelable);
        HBox reasonhbox = new HBox(80);
        wash = new CheckBox("水洗");
        fixpiece = new CheckBox("修片");
        paint = new CheckBox("印花问题");
        fabricquestion = new CheckBox("面/辅料问题");
        supplierissues = new CheckBox("供应商承担");
        sample = new CheckBox("工艺/样板");
        second = new CheckBox("二次操作(含二次整改)");
        cutquestion = new CheckBox("裁片问题");
        bond = new CheckBox("压胶问题");
        cottonissue = new CheckBox("绗棉问题");
        customerissue = new CheckBox("客户问题");
        other = new CheckBox("其他");
        VBox box1 = new VBox(10);
        box1.getChildren().addAll(wash, second);
        VBox box2 = new VBox(10);
        box2.getChildren().addAll(fixpiece, cutquestion);
        VBox box3 = new VBox(10);
        box3.getChildren().addAll(paint, bond);
        VBox box4 = new VBox(10);
        box4.getChildren().addAll(fabricquestion, cottonissue);
        VBox box5 = new VBox(10);
        box5.getChildren().addAll(supplierissues, customerissue);
        VBox box6 = new VBox(10);
        box6.getChildren().addAll(sample, other);


        // 监听每个CheckBox的选中状态
//        ChangeListener<Boolean> checkBoxChangeListener = (observable, oldValue, newValue) -> {
//            StringBuilder selectedOptions = new StringBuilder("Selected Options: ");
//            boolean first = true;
//
//            if (wash.isSelected()) {
//                if (!first) selectedOptions.append(",");
//                selectedOptions.append(wash.getText());
//                first = false;
//            }
//
//            if (fixpiece.isSelected()) {
//                if (!first) selectedOptions.append(",");
//                selectedOptions.append(fixpiece.getText());
//                first = false;
//            }
//
//            if (paint.isSelected()) {
//                if (!first) selectedOptions.append(",");
//                selectedOptions.append(paint.getText());
//            }
//            if (fabricquestion.isSelected()) {
//                if (!first) selectedOptions.append(",");
//                selectedOptions.append(fabricquestion.getText());
//                first = false;
//            }
//
//            if (supplierissues.isSelected()) {
//                if (!first) selectedOptions.append(",");
//                selectedOptions.append(supplierissues.getText());
//                first = false;
//            }
//
//            if (sample.isSelected()) {
//                if (!first) selectedOptions.append(",");
//                selectedOptions.append(sample.getText());
//            }
//            if (second.isSelected()) {
//                if (!first) selectedOptions.append(",");
//                selectedOptions.append(second.getText());
//            }
//            if (cutquestion.isSelected()) {
//                if (!first) selectedOptions.append(",");
//                selectedOptions.append(cutquestion.getText());
//            }
//
//
//
//        };
//
//        wash.selectedProperty().addListener(checkBoxChangeListener);
//        fixpiece.selectedProperty().addListener(checkBoxChangeListener);
//        paint.selectedProperty().addListener(checkBoxChangeListener);
//        fabricquestion.selectedProperty().addListener(checkBoxChangeListener);
//        supplierissues.selectedProperty().addListener(checkBoxChangeListener);
//        sample.selectedProperty().addListener(checkBoxChangeListener);
//        second.selectedProperty().addListener(checkBoxChangeListener);
//        cutquestion.selectedProperty().addListener(checkBoxChangeListener);


        reasonhbox.getChildren().addAll(box1, box2, box3, box4, box5, box6);


        //责任工厂  责任车间  责任部门  责任人
//        HBox dutyhbox= new HBox();
//        Label dufa= new Label("责任工厂");
//        ChoiceBox ducb=new ChoiceBox();
//        ducb.setItems(FXCollections.observableArrayList("嘉乐生产A部","嘉乐生产B部","嘉乐生产C部"));
//        Label duws= new Label("责任车间");
//        ChoiceBox duworkshop= new ChoiceBox();
//        duworkshop.setItems(FXCollections.observableArrayList("B车缝一组","B车缝二组"));
//        Label dudp= new Label("责任部门");
//        ChoiceBox dudept= new ChoiceBox();
//        dudept.setItems(FXCollections.observableArrayList("A01","A02"));
//
//        Label duep= new Label("责任人");
//        ChoiceBox duemployee= new ChoiceBox();
//        duemployee.setItems(FXCollections.observableArrayList("35001张珊","34001李四","52018王五"));
//        dutyhbox.getChildren().addAll(dufa,ducb,duws,duworkshop,dudp,dudept,duep,duemployee);


        //为水平布局设置边框
//        Background border = new Background(
//              new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY),
//                new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, new Insets(1)) // 内边距为5
//        );
//        dutyhbox.setBackground(border);

        // 设置HBox的填充和边框颜色
//        dutyhbox.setStyle("-fx-border-color: black; -fx-border-width: 0.01;");


//        rocb.getSelectionModel().selectFirst();
//        roworkshop.getSelectionModel().selectFirst();
//        rodept.getSelectionModel().selectFirst();
//        roep.getSelectionModel().selectFirst();


//        dutyhbox.setMargin(dufa,new Insets(5,10,11,10));
//        dutyhbox.setMargin(duws,new Insets(5,10,11,50));
//        dutyhbox.setMargin(dudp,new Insets(5,10,11,50));
//        dutyhbox.setMargin(duep,new Insets(5,10,11,50));


        //责任部门上沿分割线

        Line line3 = new Line();
        line3.setStroke(Color.GRAY);
        line3.setStartX(200.f);
        line3.setStartY(25.0f);
        line3.setEndX(1100.0f);
        line3.setEndY(25.0f);

        //责任部门
        HBox dutytitle = new HBox();
        Label dutydept = new Label("责任部门：如果是公司内部影响，写明部门，如果是供应商问题，写明供应商名称以及订单合同号");
//        dutytitle.getChildren().add(details);
        HBox dbox = new HBox();
        TextArea field = new TextArea();
        field.setPrefWidth(GetScreenSize.getScreenwidth / 2);
        field.setPrefHeight(200);
        field.setWrapText(true);
        dbox.setVisible(true);
        dbox.getChildren().add(field);
        dbox.setMargin(field, new Insets(10, 10, 10, 0));

        ComboBox<String> deptComboBox = new ComboBox<>();
        deptComboBox.setItems(FXCollections.observableArrayList("JLA", "JLB"));
        dutytitle.getChildren().addAll(dutydept, deptComboBox);
        dutytitle.setMargin(deptComboBox, new Insets(0, 0, 0, 50));


        //登记转出时间

        HBox htime = new HBox();
        Label startedate = new Label("开始时间");
        final TextField jf = new TextField();
        Label enddate = new Label("结束时间");
        final TextField edjf = new TextField();
        Label tm = new Label("转出工时");
        TextField tmf = new TextField("20min");


        Image image = new Image("images/flash2.png");//file:resource/imagas/package.png
        ImageView Image = new ImageView(image);
        Button imagebutton = new Button();
        imagebutton.setGraphic(Image);
        //新增提交按键
        Button submit = new Button("submit");
        submit.setPrefSize(60, 60);

        htime.setMargin(submit, new Insets(5, 10, 10, 200));
        htime.setMargin(startedate, new Insets(5, 10, 10, 10));
        htime.setMargin(enddate, new Insets(5, 10, 10, 50));
        htime.setMargin(tm, new Insets(5, 10, 10, 50));
        htime.setMargin(imagebutton, new Insets(0, 10, 10, 20));
        htime.setMargin(add, new Insets(5, 10, 10, 150));


        htime.getChildren().addAll(startedate, jf, enddate, edjf, tm, tmf, imagebutton, submit);


        HBox confirmbox = new HBox();

        this.setSpacing(5);
        Button cancel = new Button("取消");
        cancel.setStyle("-fx-text-fill:WHITE;-fx-background-color:#5264AE;-fx-font-size:14px;-fx-float:right;");
        Button confirm = new Button("保存");
        confirm.setStyle("-fx-text-fill:WHITE;-fx-background-color:#5264AE;-fx-font-size:14px;-fx-float:right;");


        Label sumtime = new Label("合计工时");
        TextField sumtimejText = new TextField();
        Label sumnumber = new Label("合计数量");
        TextField sumnumberjText = new TextField();
        sumnumberjText.setText("0.0");
        Label sumsalary = new Label("合计补贴");
        TextField sumsalaryjText = new TextField();
        confirmbox.setAlignment(Pos.CENTER_RIGHT);

        confirmbox.setMargin(sumtime, new Insets(0, 5, 0, 0));
        confirmbox.setMargin(sumtimejText, new Insets(0, 20, 0, 0));
        confirmbox.setMargin(sumnumber, new Insets(0, 5, 0, 0));
        confirmbox.setMargin(sumnumberjText, new Insets(0, 600, 0, 0));
        confirmbox.setMargin(cancel, new Insets(0, 5, 2, 0));
        confirmbox.setMargin(confirm, new Insets(0, 2, 2, 0));



        confirmbox.getChildren().addAll(sumnumber,sumnumberjText,cancel, confirm);



        //组装组件
//        this.getChildren().addAll(firsthbox,hgroupbox,line1,hBox,chbox,line2,title,reasonhbox,line3,dutytitle,dbox,table);


//        private int No;
//        //单据状态
//        private String formstate;
//        //流水号
//        private String MRPSSOI;
//        //类型
//        private String type;
//        //转出类型
//        private String transfertype;
//        //人员工厂
//        private String Factory;
//        //人员车间
//        private String Dept;
//        //组别
//        private  String line;
//        //转出员工
//        private String emolyee;
//        //转出工厂
//        private String transferFactory;
//        //人员车间
//        private String transferDept;
//        //转出组别
//        private String transferline;
//
//        //责任工厂
//        private String dutyFactory;
//        //责任车间
//        private String dutyDept;
//        //责任组别
//        private String dutyline;
//        //责任人员
//        private String dutyemployee;
//        //开始时间
//        private  String startDate;
//        //结束日期
//        private  String  endDate;
//        //转出时间
//        private  String transfertime;
//        //操作人
//        private String operater;
//        //操作时间
//        private String createtime;

        //添加表格

        ObservableList<NPTDetails> data = FXCollections.observableArrayList();

        TableView<NPTDetails> table = new TableView<>();

        table.setEditable(true);


        //测试 失去焦点  获取
        Callback<TableColumn<NPTDetails, String>,
                TableCell<NPTDetails, String>> cellFactory
                = (TableColumn<NPTDetails, String> p) -> new EditingCell();

        TableColumn<NPTDetails, String> No = new TableColumn<>("序号");
        No.setCellValueFactory(new PropertyValueFactory<>("NO"));
        No.setCellFactory(new IDCell<>());
        No.setSortable(false); // 通常序号列不需要排序
//        No.setCellFactory(new IDCell<>());
//
//        ;  --暂时 不用这种方法获取

        TableColumn<NPTDetails, Integer> code = new TableColumn<>("工号");
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        code.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        code.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<NPTDetails, Integer>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<NPTDetails, Integer> event) {
                ((NPTDetails) event.getTableView().getItems().
                        get(event.getTablePosition().getRow())).setCode(event.getNewValue());
                ((NPTDetails) event.getTableView().getItems().
                        get((event.getTablePosition().getRow()))).setEmployee("张珊");


            }
        });


//        添加一行数据：tableView.getItems().add(new Object());
//
//        tableView.setEditable(true); // 表格设置为可编辑
//
//        remarkColumn.setCellFactory(TextFieldTableCell.forTableColumn());// 给需要编辑的列设置属性
//
//        这时，会发现整数和BigDecimal还有日期不能编辑，需要加转换器才可以进行编辑
//
//        numColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//
//        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new BigDecimalStringConverter()));
//————————————————
//
//        版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
//
//        原文链接：https://blog.csdn.net/svygh123/article/details/128652736


        //  设置当前 单元格 可以编辑
//        code.setCellFactory(new Callback<TableColumn, TableCell>() {
//            public TableCell call(
//                    TableColumn p) {
//                return new CheckBoxTableCell();
//            }};


        /**
         * *******设置单元格返回一个勾选框
         */

//        code.setCellFactory(new Callback<TableColumn<NTPDetails, String>, TableCell<NTPDetails, String>>() {
//            @Override
//            public TableCell<NTPDetails, String> call(TableColumn<NTPDetails, String> param) {
//                return new CheckBoxTableCell();
//            }
//        });
        TableColumn<NPTDetails, String> employeeName = new TableColumn<>("姓名");
        employeeName.setCellValueFactory(new PropertyValueFactory<>("employee"));

        TableColumn<NPTDetails, String> apply = new TableColumn<>("申请工时");
        apply.setCellValueFactory(new PropertyValueFactory<>("applyfortime"));
        apply.setCellFactory(TextFieldTableCell.forTableColumn());
        apply.setOnEditCommit(event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setApplyfortime(event.getNewValue()));

        TableColumn<NPTDetails, String> style = new TableColumn<>("款号");
        style.setCellValueFactory(new PropertyValueFactory<>("style"));
        style.setCellFactory(TextFieldTableCell.forTableColumn());
        style.setOnEditCommit(event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setStyle(event.getNewValue()));

        TableColumn<NPTDetails, String> process = new TableColumn<>("工序");
        process.setOnEditCommit(event -> event.getTableView().getItems().get(event.getTablePosition().getRow()).setProcess(event.getNewValue()));
        process.setCellValueFactory(new PropertyValueFactory<>("process"));
        process.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<NPTDetails, String> reason = new TableColumn<>("补贴原因");
        reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        reason.setCellFactory(TextFieldTableCell.forTableColumn());
        reason.setOnEditCommit(event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setReason(event.getNewValue()));

        TableColumn<NPTDetails, Integer> number = new TableColumn<>("数量");
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        number.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        number.setOnEditCommit(event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setNumber(event.getNewValue()));

        TableColumn<NPTDetails, Double> amount = new TableColumn<>("补贴元/H");
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amount.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
//        amount.setCellFactory(cellFactory);
        amount.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<NPTDetails, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<NPTDetails, Double> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setAmount(event.getNewValue());
                sumnumberjText.setText(String.valueOf(updateTotalSum(table)));
            }
        });


        TableColumn<NPTDetails, String> remark = new TableColumn<>("备注");
        remark.setCellValueFactory(new PropertyValueFactory<>("remark"));
        remark.setCellFactory(TextFieldTableCell.forTableColumn());


        TableColumn<NPTDetails, Number> op = new TableColumn<>("操作");
        op.setCellValueFactory(new PropertyValueFactory<>("operate"));

//        op.setCellFactory(new Callback<TableColumn<NPTDetails, Void>, TableCell<NPTDetails, Void>>() {
//            @Override
//            public TableCell<NPTDetails, Void> call(TableColumn<NPTDetails, Void> param) {
//                       return    new TableCell<NPTDetails, Void>() {
//                    Image delete = new Image("images/closefill.png");
//                    ImageView deleteview = new ImageView(delete);
//                    Button deletebutton = new Button("nihao ");
//
//
//                    {
//                        deletebutton.setGraphic(deleteview);
//                        deletebutton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                            @Override
//                            public void handle(MouseEvent event) {
//                                int selectedIndex = table.getSelectionModel().getSelectedIndex();
//                                table.getItems().remove(selectedIndex);
//                            }
//                        });
//                    }
//
//
//                };
//
//            }
//        });


//        remark.setCellFactory();
//        column2.setCellFactory((tableColumn) -> new EditingCell<Person>());
//        remark.setCellFactory((tableColumn) -> new EditingCell<NTPDetails>());




        op.setCellFactory(new Callback<TableColumn<NPTDetails, Number>, TableCell<NPTDetails, Number>>() {
            @Override
            public TableCell<NPTDetails, Number> call(TableColumn<NPTDetails, Number> param) {

                TableCell<NPTDetails, Number> cell = new TableCell<NPTDetails, Number>() {
                    //                   Image delete = new Image("images/fill.png");
//                   ImageView deleteview = new ImageView(delete);
                    final Button button = new Button("-");

                    {

                        button.setPrefSize(25, 10);
                        button.setStyle(
                                "-fx-background-color:#FF8888;" +         //设置背景颜色
                                        "-fx-background-radius:20;" +     //设置背景圆角
                                        "-fx-text-fill:#FFFFFF;" +        //设置字体颜色
                                        "-fx-border-radius:20;" +         //设置边框圆角
                                        "-fx-border-color:#FFFF00;" +     //设置边框颜色
                                        "-fx-border-style:dotted;" +      //设置边框样式
                                        "-fx-border-width:0;" +           //设置边框宽度
//                                       "-fx-border-insets:-5;"+          //设置边框插入值
                                        "-fx-font-weight:bold"       //设置边框插入值


                        );


//                      button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("图片被点击了"));

                        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Information Dialog");
                                alert.setHeaderText("Please focus");
                                alert.setContentText("Do you want to delete the currently selected item!");


                                Optional<ButtonType> result = alert.showAndWait();
                                ButtonType buttonType = result.get();
                                if ((buttonType == ButtonType.OK)) {
//                                       int row =table.getSelectionModel().getSelectedIndex(); //**** 获取选中的行

                                    int index = getIndex(); // 获取按键点击的行
                                    table.getItems().remove(index);
                                    sumnumberjText.setText(String.valueOf(updateTotalSum(table)));
                                }


                            }


                        });

                        //设置单元格 单行选择模式

                        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


                        // 添加一个监听器来监听选择变化
//                       table.getSelectionModel().selectedIndexProperty().addListener((obs, oldValue, newValue) -> {
//                           if (newValue.intValue() == -1) {
//                               System.out.println("没有选中的行");
//                           } else {
//                               System.out.println("选中的行为"+newValue);
//                           }
//
//                       });


                    }

                    // 添加一个监听器来监听选择变化


                    @Override
                    protected void updateItem(Number item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };


                return cell;
            }
        });


        //将列添加道表格中
        table.getColumns().add(No);
        table.getColumns().add(code);
        table.getColumns().add(employeeName);
        table.getColumns().add(apply);
        table.getColumns().add(style);
        table.getColumns().add(process);
        table.getColumns().add(reason);
        table.getColumns().add(number);
        table.getColumns().add(amount);
        table.getColumns().add(remark);
        table.getColumns().add(op);


        table.setPrefHeight(GetScreenSize.getScreenheight);
        table.setPrefWidth(GetScreenSize.getScreenwidth);
        vBox.setPadding(new Insets(0, 10, 0, 10));


        //组装组件
//        this.getChildren().addAll(firsthbox,hgroupbox,line1,hBox,chbox,line2,title,reasonhbox,line3,dutytitle,dbox,table);

        this.getChildren().addAll(firsthbox, hgroupbox, line1, hBox, chbox, line2, title, reasonhbox, line3, dutytitle, dbox, table, confirmbox);
        this.setStyle("-fx-background-color: white");


        //获取Radiobutton 选中的内容

        Npttype.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            RadioButton rb = (RadioButton) newValue;
            String rbtext = rb.getText();


        });

        Nptgroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            if (newValue != null) {
                ToggleButton tb = (ToggleButton) newValue;
                System.out.println(tb.getText());
            }
            ;
        });


        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

//              RadioButton rb=(RadioButton) Nptgroup.getSelectedToggle();
//               String value=rb.getText();
//                System.out.println(value);


//
//                RadioButton rb=(RadioButton) Npttype.getSelectedToggle();
//                String rbtext=rb.getText();
//
//                ToggleButton tb=(ToggleButton)Nptgroup.getSelectedToggle();
//                String tbtext=tb.getText();
//                String favalue=cb.getValue().toString();
//                String wsvalue=workshop.getValue().toString();
//                String dpvalue=dept.getValue().toString();
//                String epvalue=ep.getValue().toString();

//                String rocbvalue=rocb.getValue().toString();
//                String rowsvalue=roworkshop.getValue().toString();
//                String rodpvalue=rodept.getValue().toString();

//                String ducbvalue=ducb.getValue().toString();
//                String duwsvalue=duworkshop.getValue().toString();
//                String duptvalue=dudept.getValue().toString();
//                String duempvalue=duemployee.getValue().toString();
//
//                String startdatevalue=jf.getText();
//                String enddatevalue=edjf.getText();
//                String tmfvalue=tmf.getText();
//                //创建人
////                String createvalue=roep.getValue().toString();
//
//                //获取服务器 当前 存储的时间
//                Calendar calendar = Calendar.getInstance();
//                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String createtime=sdf.format(calendar.getTime());


                NPTDetails nptDetails = new NPTDetails();


//                int row =table.getSelectionModel().getSelectedIndex();
//                if (row >= -1) {
//                    table.getSelectionModel().select(row+1);
//                    nptDetails.setNO(row+1);
//                    System.out.println(row);
//                    // 处理向下箭头键
//                    // ... 类似地处理选择模型的更新
//                }


                table.getItems().add(nptDetails);


            }
        });

//        final ToggleGroup group = new ToggleGroup();
//
//        RadioButton rb1 = new RadioButton("Home");
//        rb1.setToggleGroup(group);
//        rb1.setSelected(true);
//
//        RadioButton rb2 = new RadioButton("Calendar");
//        rb2.setToggleGroup(group);
//
//        RadioButton rb3 = new RadioButton("Contacts");
//        rb3.setToggleGroup(group);


        imagebutton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        String value = jf.getText();
                        String value2 = edjf.getText();

                        Calendar calendar = Calendar.getInstance();
                        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        String time = sdf.format(calendar.getTime());
                        if (value.equals("")) {
                            jf.setText(time);
                        }
                        if (value2.equals("")) {
                            edjf.setText(time);
                        } else {
                            try {
                                //计算两个时间的差，在转换为String
                                tmf.setText(String.valueOf(UtilsTime.getTime(jf.getText(), edjf.getText())) + "min");
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                };
                thread.setName("获取时间线程");
                thread.start();


            }
        });


        confirm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ObservableList<NPTDetails> items = table.getItems();
                System.out.println(items);
                String json = JSON.toJSONString(items);

                /**
                 *
                 *
                 ID
                 流水号
                 单据日期           0.25   20%             0.5               0.75           1.0
                 单据状态         A001  录入 A002  内部部门确认   A003  鉴定部门确认 A004 责任部门确认  william
                 审批进度  0
                 完成进度比  0%
                 计算类型     计时/计件
                 时工补贴类型  会议
                 申请工厂   JLA
                 申请部门    A生产 一组
                 申请组别  A01
                 补贴原因    工序难做
                 责任部门      印花车间
                 合计工时
                 合计补贴元
                 合计数量

                 备注

                 创建人
                 创建日期

                 内部部门审批人
                 内部部门审批日期
                 内部部门审批状态

                 鉴定部门审批人
                 鉴定部门审批日期
                 鉴定部门审批状态

                 责任部门审批人
                 责任部门审批日期
                 责任部门审批状态

                 William 确认
                 William 确认日期
                 William 确认状态



                 */

                //获取流水号
                String serialNumber = textField.getText();
                String formDate = datetf.getText();
                String formCode = "A001";
                String formState = "创建";
                // String approve=""审批进度
                //String approveprocess=""  审批进度比


                Toggle selectedToggle = Npttype.getSelectedToggle();
                String calculationType = ((RadioButton) selectedToggle).getText();  //计算类型
                Toggle subsidToggle = Nptgroup.getSelectedToggle();
                String subsidttype = ((ToggleButton) subsidToggle).getText();//补贴类型

//                 String  question=selectedOptions.toString();
//                System.out.println("1111"+question);

                StringBuilder selectedOptions = new StringBuilder("Selected Options: ");
                boolean first = true;

                if (wash.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(wash.getText());
                    first = false;
                }

                if (fixpiece.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(fixpiece.getText());
                    first = false;
                }

                if (paint.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(paint.getText());
                }
                if (fabricquestion.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(fabricquestion.getText());
                    first = false;
                }

                if (supplierissues.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(supplierissues.getText());
                    first = false;
                }
                if (bond.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(bond.getText());
                    first = false;
                }

                if (sample.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(sample.getText());
                }
                if (second.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(second.getText());
                }
                if (cutquestion.isSelected()) {
                    if (!first) selectedOptions.append(",");
                    selectedOptions.append(cutquestion.getText());
                }

                String reason = selectedOptions.toString();  //补贴原因
                String factory = (String) cb.getSelectionModel().getSelectedItem();//获取工厂信息
                String workgroup = (String) workshop.getSelectionModel().getSelectedItem();// 获取车间信息
                String line = (String) group.getSelectionModel().getSelectedItem();
                String responsdepartment = (String) deptComboBox.getSelectionModel().getSelectedItem(); //责任部门
                String remark = field.getText();
//                HashMap<Object, Object> map = new HashMap<>();
//                map.put("SerialNumber", serialNumber);
//                map.put("FormDate", formDate);
//                map.put("FormCode", formCode);
//                map.put("FormState", formState);
//                map.put("CalculationType", calculationType);//计算类型
//                map.put("SubsidtType", subsidttype);//补贴类型
//                map.put("Factory", factory);
//                map.put("WorkGroup", workgroup);
//                map.put("Line", line);
//
//                map.put("respondepartment", responsdepartment);
//                map.put("Remark", remark);
//                map.put("User", username);
//                String result = JSONObject.toJSONString(map);
//                String sendresult = HttpUrlConnect.doPost("http://10.32.24.85:8010/web/submit", result);
//                System.out.println("----------------" + result);
//                System.out.println(sendresult);

                NPT npt=new NPT();
                npt.setSerialNumber(serialNumber);
                npt.setFormDate(formDate);
                npt.setFormCode(formCode);
                npt.setFormState(formState);
                npt.setCalculationTe(calculationType);
                npt.setSubsidtType(subsidttype);
                npt.setFactory(factory);
                npt.setWorkGroup(workgroup);
                npt.setLine(line);
                npt.setRespondepartment(responsdepartment);
                npt.setRemark(remark);
                npt.setCreateor(username);
                npt.setItems(items);

                String result = JSONObject.toJSONString(npt);
                String sendresult = HttpUrlConnect.doPost("http://10.32.24.85:8010/web/submit", result);
                System.out.println("----------------" + result);
                System.out.println(sendresult);


                //弹出警告 提示框

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Please focus");
                alert.setContentText("Whether to store all data in the table!");
                alert.showAndWait();
                Optional<ButtonType> isresult = alert.showAndWait();
                ButtonType buttonType = isresult.get();
                if ((buttonType == ButtonType.OK)) {
//                                       int row =table.getSelectionModel().getSelectedIndex(); //**** 获取选中的行

                    System.out.println("打印成功");
                }
            }
        });

        /**
         * 在JavaFX中，你可以通过为TableView设置一个事件监听器来获取用户点击按键的行索引
         */


//        table.setRowFactory(new Callback<TableView<NPTDetails>, TableRow<NPTDetails>>() {
//            @Override
//            public TableRow<NPTDetails> call(TableView<NPTDetails> param) {
//                return new TableRow<NPTDetails>() {
//                    @Override
//                    protected void updateItem(NPTDetails npt, boolean empty) {
//                        super.updateItem(npt, empty);
//                        if (npt != null && !empty) {
//                            setOnMouseClicked(event -> {
//                                // 获取点击的行索引
//                                int index = getIndex();
//                                System.out.println("Clicked on row: " + index);
//                            });
//                        }
//                    }
//                };
//            }
//        });


        // Focus traversal policy for TableView cells
        table.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.UP) {
                // 处理向上箭头键
                int currentIndex = table.getSelectionModel().getSelectedIndex();
                if (currentIndex > 0) {
                    table.getSelectionModel().select(currentIndex - 1);
                    // 注意：这里并没有直接设置焦点到单元格，而是更新了选择模型。
                    // JavaFX 通常会根据选择模型来自动更新焦点。
                }
                event.consume(); // 消耗事件，防止默认行为发生
            } else if (event.getCode() == KeyCode.DOWN) {
                int currentIndex = table.getSelectionModel().getSelectedIndex();
                if (currentIndex > 0) {
                    table.getSelectionModel().select(currentIndex + 1);
                    // 处理向下箭头键
                    // ... 类似地处理选择模型的更新
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                // 处理向左箭头键
                // ... 需要获取当前列并找到前一列，然后更新选择模型
                event.consume();
            } else if (event.getCode() == KeyCode.RIGHT) {
                // 处理向右箭头键
                // ... 需要获取当前列并找到后一列，然后更新选择模型
                event.consume();
            }
            // 注意：对于 LEFT 和 RIGHT 键，你可能需要额外的逻辑来确定当前列并找到相邻的列。
            // 这通常涉及到获取当前选择的单元格位置，然后使用该位置来查找相应的列。
        });


//        table.setRowFactory( tv -> {
//            TableRow<NTPDetails> row = new TableRow<>();
//            row.setOnMouseClicked(event -> {
//                if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
//
//                    code.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//                    code.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<NTPDetails, Integer>>() {
//                        @Override
//                        public void handle(TableColumn.CellEditEvent<NTPDetails, Integer> event) {
//                            ((NTPDetails)event.getTableView().getItems().
//                                    get(event.getTablePosition().getRow())).setCode(event.getNewValue());
//                        }
//                    });
//                    System.out.println("11111");
//                }
//            });
//            return row ;
//        });


//        Nptgroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//            @Override
//            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//                if (newValue.equals("Meeting/会议")){
//                    Nptmeet.setStyle("-fx-background-color: red");
//                }else{
//                    Nptmeet.setStyle("-fx-background-color: wheat");
//                }
//            }
//        });


        // 如果使用了


    }

    // 更新总和的方法
    private double updateTotalSum(TableView<NPTDetails> table) {
        double totalSum = 0.0;
        for (NPTDetails nptdetails : table.getItems()) {
            totalSum += nptdetails.getAmount();
        }

        return totalSum;
        // 如果使用了totalSumListener，则不需要在这里更新UI，监听器会处理
        // 但在这个例子中，我们直接在方法内部更新了Label
    }


}



