package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 仓库调拨出库实体
 * Created by pinkman on 2017/7/29.
 */
public class WarehouseMoveHeader{
    public WarehouseMoveHeader(){
    }

    private String id;

    /**
     * 单据号
     */
    private String code;

    /**
     * 单据类型
     */
    private String billType;

    /**
     * 单据类型
     */
    private String billStatus;

    private String sendId;

    private String sendName;

    private String receiveId;

    private String uploadId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date uploadTime;

    private String submitBy;

    private String scanBy;

    private String productId;

    private Date submitDate;

    private String receiveName;

    private Integer expectPcsQty;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date opDate;

    private Integer actualPcsQty;

    private User createBy; // 创建者

    private Date createDate;

    private User updateBy; // 更新者

    private Date updateDate; // 更新日期

    private String sendCode;

    private List<WarehouseMoveDetail> detailList;

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public void setSubmitBy(String submitBy) {
        this.submitBy = submitBy;
    }

    public void setScanBy(String scanBy) {
        this.scanBy = scanBy;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public void setExpectPcsQty(Integer expectPcsQty) {
        this.expectPcsQty = expectPcsQty;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    public void setActualPcsQty(Integer actualPcsQty) {
        this.actualPcsQty = actualPcsQty;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public void setDetailList(List<WarehouseMoveDetail> detailList) {
        this.detailList = detailList;
    }

    public String getId() {

        return id;
    }

    public String getCode() {
        return code;
    }

    public String getBillType() {
        return billType;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public String getSendId() {
        return sendId;
    }

    public String getSendName() {
        return sendName;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public String getUploadId() {
        return uploadId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public String getSubmitBy() {
        return submitBy;
    }

    public String getScanBy() {
        return scanBy;
    }

    public String getProductId() {
        return productId;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public Integer getExpectPcsQty() {
        return expectPcsQty;
    }

    public Date getOpDate() {
        return opDate;
    }

    public Integer getActualPcsQty() {
        return actualPcsQty;
    }

    public User getCreateBy() {
        return createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getSendCode() {
        return sendCode;
    }

    public List<WarehouseMoveDetail> getDetailList() {
        return detailList;
    }
}
