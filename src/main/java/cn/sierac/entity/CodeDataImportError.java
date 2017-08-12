package cn.sierac.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created by Jack on 2017/8/7.
 */
public class CodeDataImportError {

    private String id ;

    private String code;		// 单品码
    private String errorStatus;		// 错误状态
    private String parentCode;		// 上级编码
    private String errorCode;		// 错误代码
    private String errorInfo;		// error_info
    private String lineCode;		// line_code
    private String batchCode;		// 生产批号
    private String rootCode;		// 托码
    private Date printDate;		// 打印日期
    private Integer packLevel; //包装层级
    private String delFlag; //

    protected Date createDate; // 创建日期


    protected boolean isNewRecord = false;




    public CodeDataImportError(CodeData codeData){
        super();
        this.code=codeData.getCode();
        this.parentCode=codeData.getParentCode();
        this.lineCode=codeData.getLineCode();
        this.batchCode=codeData.getBatchCode();
        this.rootCode=codeData.getRootCode();
        this.printDate=codeData.getPrintDate();
        this.packLevel=codeData.getPackLevel();

    }

    public CodeDataImportError() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getRootCode() {
        return rootCode;
    }

    public void setRootCode(String rootCode) {
        this.rootCode = rootCode;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public Integer getPackLevel() {
        return packLevel;
    }

    public void setPackLevel(Integer packLevel) {
        this.packLevel = packLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @return
     */
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isNewRecord() {
        return isNewRecord;
    }

    public void setNewRecord(boolean newRecord) {
        isNewRecord = newRecord;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
