package com.longson.pojo;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 创建NPT  时工补贴主表
 *
 *
 */
public class NPT {
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
     合计
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

    //流水号
    private String serialNumber;
    //单据日期
    private String formDate;
    //单据代码
    private String formCode;
    //单据状态
    private String formState;
    //计算类型
    private String calculationTe;
    //补贴类型
    private String subsidtType;
    //申请工厂
    private String factory;
    //申请车间
    private String workGroup;
    //申请小组
    private String line;
    //补贴原因
    private String reason;
    //合计工时
    private String time;
    //合计数量
    private  int number;
    //合计工资
    private  double  salay;
    //责任部门
    private String respondepartment;
    //备注
    private String remark;
    //创建人
    private String createor;
    //创建人工号
    private int createorcode;
    //创建日期
    private Date createdate;


    private List<NPTDetails> items;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getFormState() {
        return formState;
    }

    public void setFormState(String formState) {
        this.formState = formState;
    }

    public String getCalculationTe() {
        return calculationTe;
    }

    public void setCalculationTe(String calculationTe) {
        this.calculationTe = calculationTe;
    }

    public String getSubsidtType() {
        return subsidtType;
    }

    public void setSubsidtType(String subsidtType) {
        this.subsidtType = subsidtType;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRespondepartment() {
        return respondepartment;
    }

    public void setRespondepartment(String respondepartment) {
        this.respondepartment = respondepartment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateor() {
        return createor;
    }

    public void setCreateor(String createor) {
        this.createor = createor;
    }

    public int getCreateorcode() {
        return createorcode;
    }

    public void setCreateorcode(int createorcode) {
        this.createorcode = createorcode;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public List<NPTDetails> getItems() {
        return items;
    }

    public void setItems(List<NPTDetails> items) {
        this.items = items;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSalay() {
        return salay;
    }

    public void setSalay(double salay) {
        this.salay = salay;
    }

    public NPT(String serialNumber, String formDate, String formCode, String formState, String calculationTe,
               String subsidtType, String factory, String workGroup, String line, String reason, String time, int number, double salay, String respondepartment,
               String remark, String createor, int createorcode, Date createdate, List<NPTDetails> items) {
        this.serialNumber = serialNumber;
        this.formDate = formDate;
        this.formCode = formCode;
        this.formState = formState;
        this.calculationTe = calculationTe;
        this.subsidtType = subsidtType;
        this.factory = factory;
        this.workGroup = workGroup;
        this.line = line;
        this.reason = reason;
        this.time = time;
        this.number = number;
        this.salay = salay;
        this.respondepartment = respondepartment;
        this.remark = remark;
        this.createor = createor;
        this.createorcode = createorcode;
        this.createdate = createdate;
        this.items = items;
    }


    @Override
    public String toString() {
        return "NPT{" +
                "serialNumber='" + serialNumber + '\'' +
                ", formDate='" + formDate + '\'' +
                ", formCode='" + formCode + '\'' +
                ", formState='" + formState + '\'' +
                ", calculationTe='" + calculationTe + '\'' +
                ", subsidtType='" + subsidtType + '\'' +
                ", factory='" + factory + '\'' +
                ", workGroup='" + workGroup + '\'' +
                ", line='" + line + '\'' +
                ", reason='" + reason + '\'' +
                ", time='" + time + '\'' +
                ", number=" + number +
                ", salay=" + salay +
                ", respondepartment='" + respondepartment + '\'' +
                ", remark='" + remark + '\'' +
                ", createor='" + createor + '\'' +
                ", createorcode=" + createorcode +
                ", createdate=" + createdate +
                ", items=" + items +
                '}';
    }

    public NPT() {
    }
}
