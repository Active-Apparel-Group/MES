package com.longson.pojo;
import javafx.beans.property.SimpleDoubleProperty;

public class PojoMaterialProcess {
//    TableColumn<Tableview.Person, String> column1 = new TableColumn<>("序号");
//        column1.setCellValueFactory(new PropertyValueFactory<>("No"));
//    TableColumn<Tableview.Person, String> column2 = new TableColumn<>("客户款号");
//        column2.setCellValueFactory(new PropertyValueFactory<>("customer_style_no"));
//    TableColumn<Tableview.Person,String> column3=new TableColumn<>("系统款号");
//        column3.setCellValueFactory(new PropertyValueFactory<>("style_no") );
//    TableColumn<Tableview.Person, String> column4 = new TableColumn<>("物料名称");
//        column1.setCellValueFactory(new PropertyValueFactory<>("Material_name"));
//    TableColumn<Tableview.Person, String> column5 = new TableColumn<>("物料代码");
//        column2.setCellValueFactory(new PropertyValueFactory<>("Material_code"));
//    TableColumn<Tableview.Person,String> column6=new TableColumn<>("物料描述");
//        column3.setCellValueFactory(new PropertyValueFactory<>("Material_descripe") );
//    TableColumn<Tableview.Person,String> unit=new TableColumn<>("订单单耗");
//        column3.setCellValueFactory(new PropertyValueFactory<>("unit") );
//    TableColumn<Tableview.Person,String> phr=new TableColumn<>("计划用量/m");
//        column3.setCellValueFactory(new PropertyValueFactory<>("planphr") );
//    TableColumn<Tableview.Person,String>  in_phr=new TableColumn<>("初入库量/m");
//        column3.setCellValueFactory(new PropertyValueFactory<>("phr") );
//    TableColumn<Tableview.Person,String> check_phr=new TableColumn<>("IQC 检验/m");
//        column3.setCellValueFactory(new PropertyValueFactory<>("IQC check") );
//    TableColumn<Tableview.Person,String> check_in=new TableColumn<>("入库量/m");
//        column3.setCellValueFactory(new PropertyValueFactory<>("Check in") );

    private int No;
    private String customer_style_no;
    private String style_no;
    private String Material_name;
    private String Material_code;
    private String Material_descripe;
    private double unit;
    private double plan_phr;
    private double phr;
    private double IQC_check;
    private double Check_in;
    private double  progress;
    private String precentage;

    public SimpleDoubleProperty mProgressProperty = new SimpleDoubleProperty();

    public String getPrecentage() {
        return precentage;
    }

    public void setPrecentage(String precentage) {
        this.precentage = precentage;
    }

    public void setProgress(double mProgress){
        this.progress=progress;

    }

    public double getProgress(){
        return progress;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private  String color;

    public PojoMaterialProcess(int no, String customer_style_no, String style_no, String material_name, String material_code, String material_descripe,
                               double unit, double plan_phr, double phr, double IQC_check, double check_in, String color, double  progress, String precentage) {
        this.No = no;
        this.customer_style_no = customer_style_no;
        this.style_no = style_no;
        this.Material_name = material_name;
        this.Material_code = material_code;
        this.Material_descripe = material_descripe;
        this.unit = unit;
        this.plan_phr = plan_phr;
        this.phr = phr;
        this.IQC_check = IQC_check;
        this.Check_in = check_in;
        this.color=color;
        this.progress=progress;
        this.precentage=precentage;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getCustomer_style_no() {
        return customer_style_no;
    }

    public void setCustomer_style_no(String customer_style_no) {
        this.customer_style_no = customer_style_no;
    }

    public String getStyle_no() {
        return style_no;
    }

    public void setStyle_no(String style_no) {
        this.style_no = style_no;
    }

    public String getMaterial_name() {
        return Material_name;
    }

    public void setMaterial_name(String material_name) {
        Material_name = material_name;
    }

    public String getMaterial_code() {
        return Material_code;
    }

    public void setMaterial_code(String material_code) {
        Material_code = material_code;
    }

    public String getMaterial_descripe() {
        return Material_descripe;
    }

    public void setMaterial_descripe(String material_descripe) {
        Material_descripe = material_descripe;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public double getPlan_phr() {
        return plan_phr;
    }

    public void setPlan_phr(double plan_phr) {
        this.plan_phr = plan_phr;
    }

    public double getPhr() {
        return phr;
    }

    public void setPhr(double phr) {
        this.phr = phr;
    }

    public double getIQC_check() {
        return IQC_check;
    }

    public void setIQC_check(double IQC_check) {
        this.IQC_check = IQC_check;
    }

    public double getCheck_in() {
        return Check_in;
    }

    public void setCheck_in(double check_in) {
        Check_in = check_in;
    }
}

