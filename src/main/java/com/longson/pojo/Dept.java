package com.longson.pojo;


/*
查询部门信息
 */
public class Dept {

    private  String dept;
    private  String line;
    private  String employee;

    public Dept(String dept, String line, String employee) {
        this.dept = dept;
        this.line = line;
        this.employee = employee;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGroup() {
        return line;
    }

    public void setGroup(String group) {
        this.line = group;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dept='" + dept + '\'' +
                ", line='" + line + '\'' +
                ", employee='" + employee + '\'' +
                '}';
    }
}
