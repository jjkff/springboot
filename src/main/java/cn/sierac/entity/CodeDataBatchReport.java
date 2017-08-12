package cn.sierac.entity;

import java.util.Date;

/**
 * Created by Jack on 2017/8/7.
 */
public class CodeDataBatchReport {

    private String id ;
    private String batchCode;		// 生产批号
    private String productCode;		// 产品代码
    private String productName;		// 产品名称
    private Date mfgDate;		// 生产日期
    private Integer ctns;		// 箱数
    private Integer qty;		// 单品数
    private Date beginDate;//开始时间
    private Date endDate;//结束时间
    private String delFlag ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
    }

    public Integer getCtns() {
        return ctns;
    }

    public void setCtns(Integer ctns) {
        this.ctns = ctns;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
