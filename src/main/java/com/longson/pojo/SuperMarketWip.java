package com.longson.pojo;

/**
 *  裁片超市库存 列表
 */
public class SuperMarketWip {
    //序号
    private  int No;
    //创建日期
    private  String createDate;
    //仓库编码
    private  String code;
    //仓库名称
    private String codeName;
    //计划号
    private  String schemeNumbe;
    //款号
    private  String styleNo;
    //款式
    private  String style_sort;
    //部位
    private  String parts;
    //需求颜色
    private  String main_color_name;
    //颜色
    private  String color_name;
    //色号
    private  String color_no;
    //缸号
    private String vat_no;
    //尺码
    private String size;
    //库存
    private  int wip;

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getSchemeNumbe() {
        return schemeNumbe;
    }

    public void setSchemeNumbe(String schemeNumbe) {
        this.schemeNumbe = schemeNumbe;
    }

    public String getStyleNo() {
        return styleNo;
    }

    public void setStyleNo(String styleNo) {
        this.styleNo = styleNo;
    }

    public String getStyle_sort() {
        return style_sort;
    }

    public void setStyle_sort(String style_sort) {
        this.style_sort = style_sort;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getMain_color_name() {
        return main_color_name;
    }

    public void setMain_color_name(String main_color_name) {
        this.main_color_name = main_color_name;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getColor_no() {
        return color_no;
    }

    public void setColor_no(String color_no) {
        this.color_no = color_no;
    }

    public String getVat_no() {
        return vat_no;
    }

    public void setVat_no(String vat_no) {
        this.vat_no = vat_no;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getWip() {
        return wip;
    }

    public void setWip(int wip) {
        this.wip = wip;
    }

    public SuperMarketWip(int no, String createDate, String code, String codeName, String schemeNumbe, String styleNo, String style_sort,
                          String parts, String main_color_name, String color_name, String color_no, String vat_no, String size, int wip) {
        No = no;
        this.createDate = createDate;
        this.code = code;
        this.codeName = codeName;
        this.schemeNumbe = schemeNumbe;
        this.styleNo = styleNo;
        this.style_sort = style_sort;
        this.parts = parts;
        this.main_color_name = main_color_name;
        this.color_name = color_name;
        this.color_no = color_no;
        this.vat_no = vat_no;
        this.size = size;
        this.wip = wip;
    }


    @Override
    public String toString() {
        return "SuperMarketWip{" +
                "No=" + No +
                ", createDate=" + createDate +
                ", code=" + code +
                ", codeName=" + codeName +
                ", schemeNumbe='" + schemeNumbe + '\'' +
                ", styleNo='" + styleNo + '\'' +
                ", style_sort='" + style_sort + '\'' +
                ", parts=" + parts +
                ", main_color_name='" + main_color_name + '\'' +
                ", color_name='" + color_name + '\'' +
                ", color_no='" + color_no + '\'' +
                ", vat_no='" + vat_no + '\'' +
                ", size='" + size + '\'' +
                ", wip=" + wip +
                '}'+"\n";
    }
}
