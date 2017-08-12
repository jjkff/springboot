package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * Created by Jack on 2017/7/29.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiRdcOutDetail {

    private String id;// 主键

    private String headerId;

    private String code;// 单据号码

    private String productId;// 产品id

    private String batchCode;// 批号

    private Integer expectPcsQty;// 计划出库单品数

    private Integer actualPcsQty;// 实际出库单品数

    private List<ApiRdcOutData> dataList;


    private String addTime;

    private String receiveId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date editTime;

    private String productCode;

    private String productName;

    private String productSKU;

    private String remark;

    private String sendId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public Integer getExpectPcsQty() {
        return expectPcsQty;
    }

    public void setExpectPcsQty(Integer expectPcsQty) {
        this.expectPcsQty = expectPcsQty;
    }

    public Integer getActualPcsQty() {
        return actualPcsQty;
    }

    public void setActualPcsQty(Integer actualPcsQty) {
        this.actualPcsQty = actualPcsQty;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
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

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public List<ApiRdcOutData> getDataList() {
        return dataList;
    }

    public void setDataList(List<ApiRdcOutData> dataList) {
        this.dataList = dataList;
    }
}
