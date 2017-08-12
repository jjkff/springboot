package cn.sierac.entity;

import cn.sierac.utils.UuidUtils;

import java.util.Date;

/**
 * 经销商发货实体
 * Created by Jack on 2017/7/27.
 */
public class Dealer {


    /**
     * id
     */
    private String id ;
    /**
     * 单据号码
     */
    private String code;

    /**
     *出库单号
     */
//    private String orderCode;

    /**
     *出库类型代码
     */
    private String outTypeCode;

    /**
     * 上传id
     */
    private String uploadId;

    /**
     * 上传日期
     */
    private String uploadTime;

    /**
     * 扫描者
     */
    private String scanBy;

    /**
     * 扫描开始时间
     */
    private Date scanBeginTime;

    /**
     * 单据类型
     */
    private String billType;

    /**
     * 单据状态
     */
    private String billStatus;

    /**
     * 提交者
     */
    private String submitBy;

    /**
     * 出库单日期
     */
    private Date submitDate;

    /**
     * 发货仓id
     */
    private String sendId;

    /**
     * 发货仓代码
     */
    private String sendCode;

    /**
     * 发货仓名称
     */
    private String sendName;

    /**
     * 收货人id
     */
    private String receiveId;

    /**
     * 客户姓名
     */
    private String receiveName;

    /**
     * 客户手机号
     */
//    private String receivePhone;

    /**
     * 客户地址
      */
//    private String receiveAddress;

    /**
     * 计划数量
     */
//    private Integer expectPcsQty;

    /**
     * 实际数量
     */
//    private Integer actualPcsQty;

    /**
     * 开始 出库单日期
     */
//    private Date beginSubmitDate;

    /**
     * 结束 出库单日期
     */
//    private Date endSubmitDate;

    public Dealer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOutTypeCode() {
        return outTypeCode;
    }

    public void setOutTypeCode(String outTypeCode) {
        this.outTypeCode = outTypeCode;
    }




    public String getScanBy() {
        return scanBy;
    }

    public void setScanBy(String scanBy) {
        this.scanBy = scanBy;
    }

    public Date getScanBeginTime() {
        return scanBeginTime;
    }

    public void setScanBeginTime(Date scanBeginTime) {
        this.scanBeginTime = scanBeginTime;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getSubmitBy() {
        return submitBy;
    }

    public void setSubmitBy(String submitBy) {
        this.submitBy = submitBy;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }
}
