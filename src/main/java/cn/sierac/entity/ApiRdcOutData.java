package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Jack on 2017/7/31.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiRdcOutData {

    private String headerId;//

    private String detailId;//

    private String parentCode;// 箱码

    private String productId;// 产品id

    private String batchCode;// 批号

    private String scanCode;// 扫描码

    private String scanBy;// 扫描者

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date scanTime;// 扫描时间

    private Integer qty;// 数量

    private Integer isLocalInt;// 是否本地

    private Integer packLevel;//包装层级

    //后加
    private String boxCode;

    private String code;

    private String codeList;


    private String id;

    private boolean isLocal;

    private Integer isLocal_Int;

    private String materialId;

    public ApiRdcOutData(){}

    public ApiRdcOutData(CodeData codeData){
        this.id=codeData.getId();
        this.parentCode=codeData.getParentCode();
        this.packLevel=codeData.getPackLevel();
        this.code=codeData.getCode();
        this.headerId=codeData.getOutHeaderId();
        this.batchCode=codeData.getBatchCode();
        this.productId=codeData.getProductId();
    }

    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
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

    public String getScanCode() {
        return scanCode;
    }

    public void setScanCode(String scanCode) {
        this.scanCode = scanCode;
    }

    public String getScanBy() {
        return scanBy;
    }

    public void setScanBy(String scanBy) {
        this.scanBy = scanBy;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getIsLocalInt() {
        return isLocalInt;
    }

    public void setIsLocalInt(Integer isLocalInt) {
        this.isLocalInt = isLocalInt;
    }

    public Integer getPackLevel() {
        return packLevel;
    }

    public void setPackLevel(Integer packLevel) {
        this.packLevel = packLevel;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeList() {
        return codeList;
    }

    public void setCodeList(String codeList) {
        this.codeList = codeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public Integer getIsLocal_Int() {
        return isLocal_Int;
    }

    public void setIsLocal_Int(Integer isLocal_Int) {
        this.isLocal_Int = isLocal_Int;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }
}
