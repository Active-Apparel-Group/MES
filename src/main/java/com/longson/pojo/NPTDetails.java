package com.longson.pojo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 *
 * 创建Npt 时工补贴明细实体对象
 * 单据状态
 * 0 录入
 * 1待确认
 * 2 确认
 * 3 待审
 * 4 取消
 */

public class NPTDetails {
      //工号
    private  int code;
     //姓名
    private String employee;
    //款号
    private  String  style;
    //工序
    private String process;
    //补贴原因
    private  String reason;
    //申请工时
    private  String applyfortime;
    //补贴数量
    private  int number;
    //补贴金额
    private  double amount;
    // 备注
    private String remark;





    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getApplyfortime() {
        return applyfortime;
    }

    public void setApplyfortime(String applyfortime) {
        this.applyfortime = applyfortime;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "NPTDetails{" +
                "code=" + code +
                ", employee='" + employee + '\'' +
                ", applyfortime='" + applyfortime + '\'' +
                ", style='" + style + '\'' +
                ", process='" + process + '\'' +
                ", reason='" + reason + '\'' +
                ", number=" + number +
                ", amount=" + amount +
                ", remark='" + remark + '\'' +
                '}'+'\n';
    }

    public NPTDetails(int code, String employee, String style, String process, String reason, String applyfortime, int number, double amount, String remark) {
        this.code = code;
        this.employee = employee;
        this.style = style;
        this.process = process;
        this.reason = reason;
        this.applyfortime = applyfortime;
        this.number = number;
        this.amount = amount;
        this.remark = remark;
    }

    public NPTDetails() {
    }
    //    TableColumn<NTP,String> formstate=new TableColumn<>("工号");
//        formstate.setCellValueFactory(new PropertyValueFactory<>("code"));
//    TableColumn<NTP,String> MRPSSOI=new TableColumn<>("姓名");
//        MRPSSOI.setCellValueFactory(new PropertyValueFactory<>("employee"));
//    TableColumn<NTP,String> type=new TableColumn<>("申请工时");
//        type.setCellValueFactory(new PropertyValueFactory<>("time"));
//    TableColumn<NTP,String> transfertype=new TableColumn<>("款号");
//        transfertype.setCellValueFactory(new PropertyValueFactory<>("style"));
//    TableColumn<NTP,String> factory=new TableColumn<>("工序");
//        factory.setCellValueFactory(new PropertyValueFactory<>("process"));
//    TableColumn<NTP,String> tbdept=new TableColumn<>("补贴原因");
//        tbdept.setCellValueFactory(new PropertyValueFactory<>("reason"));
//    TableColumn<NTP,String> tbtransferFactory=new TableColumn<>("数量");
//        tbtransferFactory.setCellValueFactory(new PropertyValueFactory<>("number"));
//    TableColumn<NTP,String> tbtransferdept=new TableColumn<>("补贴元/H");
//        tbtransferdept.setCellValueFactory(new PropertyValueFactory<>("amount"));
//    TableColumn<NTP,String> tbtransferline=new TableColumn<>("备注");
//        tbtransferline.setCellValueFactory(new PropertyValueFactory<>("remark"));

}
