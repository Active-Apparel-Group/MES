package com.longson.pojo;

import java.util.Date;

/**
 * 呼叫请求列表
 */

public class CallList {

    private  int callNo;
    //呼叫状态
    private  int state;
    //呼叫日期
    private  Date callDate;
    //需求部门
    private  String dept;
    //需求小组
    private  String group;
    //计划号
    private  int schemeNumber;
    //需求款式
    private  String callStyle;
    //部位
    private  String parts;
    //需求颜色
    private  String Color;
    //需求缸号
    private  String vatNo;
    //需求尺码
    private  String size;
    //需求日期
    private Date  NeedDate;
    //需求数量
    private int number;

    public int getCallNo() {
        return callNo;
    }

    public void setCallNo(int callNo) {
        this.callNo = callNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getSchemeNumber() {
        return schemeNumber;
    }

    public void setSchemeNumber(int schemeNumber) {
        this.schemeNumber = schemeNumber;
    }

    public String getCallStyle() {
        return callStyle;
    }

    public void setCallStyle(String callStyle) {
        this.callStyle = callStyle;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getVatNo() {
        return vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getNeedDate() {
        return NeedDate;
    }

    public void setNeedDate(Date needDate) {
        NeedDate = needDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CallList(int callNo, int state, Date callDate, String dept, String group,
                    int schemeNumber, String callStyle, String parts, String color, String vatNo, String size, Date needDate, int number) {
        this.callNo = callNo;
        this.state = state;
        this.callDate = callDate;
        this.dept = dept;
        this.group = group;
        this.schemeNumber = schemeNumber;
        this.callStyle = callStyle;
        this.parts = parts;
        Color = color;
        this.vatNo = vatNo;
        this.size = size;
        NeedDate = needDate;
        this.number = number;

    }


    @Override
    public String toString() {
        return "CallList{" +
                "callNo=" + callNo +
                ", state=" + state +
                ", callDate=" + callDate +
                ", dept='" + dept + '\'' +
                ", group='" + group + '\'' +
                ", schemeNumber=" + schemeNumber +
                ", callStyle='" + callStyle + '\'' +
                ", parts='" + parts + '\'' +
                ", Color='" + Color + '\'' +
                ", vatNo='" + vatNo + '\'' +
                ", size='" + size + '\'' +
                ", NeedDate=" + NeedDate +
                ", number=" + number +
                '}';
    }
}
