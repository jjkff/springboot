package cn.sierac.entity;

import cn.sierac.utils.UuidUtils;

import java.util.Date;

/**
 * 出库实体(基类)
 * Created by Jack on 2017/7/28.
 */
public class RdcOutHeader {
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
//    private String outTypeCode;

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
    private String scanBeginTime;

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
    private String submitDate;

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


    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getUploadId() {
        return uploadId;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public String getScanBy() {
        return scanBy;
    }

    public String getScanBeginTime() {
        return scanBeginTime;
    }

    public String getBillType() {
        return billType;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public String getSubmitBy() {
        return submitBy;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public String getSendId() {
        return sendId;
    }

    public String getSendCode() {
        return sendCode;
    }

    public String getSendName() {
        return sendName;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public void setScanBy(String scanBy) {
        this.scanBy = scanBy;
    }

    public void setScanBeginTime(String scanBeginTime) {
        this.scanBeginTime = scanBeginTime;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public void setSubmitBy(String submitBy) {
        this.submitBy = submitBy;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }
}
