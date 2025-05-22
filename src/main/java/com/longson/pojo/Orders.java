package com.longson.pojo;

public class Orders {


    private int  state;
    //单据编号
    private String code;
    //单据日期
    private String form_date;
    //部门
    private String dept;
    //计划号
    private String order_no;
    //款号
    private String style_no;
    //款式描述
    private String style_describe;
    //款式
    private String  style_sort;
    //订单数
    private String number;
    //客户
    private String customer;
    //客户款号
    private  String customer_no;
    //成本系数
    private String job_ratio;
    // 创建人
    private String create_by;
    //创建时间
    private String create_time ;
    //计划组别
    private String memo_infor;


    public void setState(int state) {
        this.state = state;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setForm_date(String form_date) {
        this.form_date = form_date;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public void setStyle_no(String style_no) {
        this.style_no = style_no;
    }

    public void setStyle_describe(String style_describe) {
        this.style_describe = style_describe;
    }

    public void setStyle_sort(String style_sort) {
        this.style_sort = style_sort;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public void setJob_ratio(String job_ratio) {
        this.job_ratio = job_ratio;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setMemo_infor(String memo_infor) {
        this.memo_infor = memo_infor;
    }

    public int getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    public String getForm_date() {
        return form_date;
    }

    public String getDept() {
        return dept;
    }

    public String getOrder_no() {
        return order_no;
    }

    public String getStyle_no() {
        return style_no;
    }

    public String getStyle_describe() {
        return style_describe;
    }

    public String getStyle_sort() {
        return style_sort;
    }

    public String getNumber() {
        return number;
    }

    public String getCustomer() {
        return customer;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public String getJob_ratio() {
        return job_ratio;
    }

    public String getCreate_by() {
        return create_by;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getMemo_infor() {
        return memo_infor;
    }

    public Orders(int state, String code, String form_date, String dept, String order_no, String style_no, String style_describe, String style_sort, String number, String customer, String customer_no, String job_ratio, String create_by, String create_time, String memo_infor) {
        this.state = state;
        this.code = code;
        this.form_date = form_date;
        this.dept = dept;
        this.order_no = order_no;
        this.style_no = style_no;
        this.style_describe = style_describe;
        this.style_sort = style_sort;
        this.number = number;
        this.customer = customer;
        this.customer_no = customer_no;
        this.job_ratio = job_ratio;
        this.create_by = create_by;
        this.create_time = create_time;
        this.memo_infor = memo_infor;
    }

    @Override
    public String toString() {
        return "Order{" +
                "state=" + state +
                ", code='" + code + '\'' +
                ", form_date='" + form_date + '\'' +
                ", dept='" + dept + '\'' +
                ", order_no='" + order_no + '\'' +
                ", style_no='" + style_no + '\'' +
                ", style_describe='" + style_describe + '\'' +
                ", style_sort='" + style_sort + '\'' +
                ", number='" + number + '\'' +
                ", customer='" + customer + '\'' +
                ", customer_no='" + customer_no + '\'' +
                ", job_ratio='" + job_ratio + '\'' +
                ", create_by='" + create_by + '\'' +
                ", create_time='" + create_time + '\'' +
                ", memo_infor='" + memo_infor + '\'' +
                '}'+'\n';
    }
}

