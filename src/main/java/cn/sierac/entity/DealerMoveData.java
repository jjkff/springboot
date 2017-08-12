package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 经销商调拨出库实体
 * Created by pinkMan on 2017/7/29.
 */
public class DealerMoveData {
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

    public DealerMoveData(){}

    public DealerMoveData(CodeData codeData){
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

    public String getDetailId() {
        return detailId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public String getProductId() {
        return productId;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public String getScanCode() {
        return scanCode;
    }

    public String getScanBy() {
        return scanBy;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public Integer getQty() {
        return qty;
    }

    public Integer getIsLocalInt() {
        return isLocalInt;
    }

    public Integer getPackLevel() {
        return packLevel;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public String getCode() {
        return code;
    }

    public String getCodeList() {
        return codeList;
    }

    public String getId() {
        return id;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public Integer getIsLocal_Int() {
        return isLocal_Int;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public void setScanCode(String scanCode) {
        this.scanCode = scanCode;
    }

    public void setScanBy(String scanBy) {
        this.scanBy = scanBy;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setIsLocalInt(Integer isLocalInt) {
        this.isLocalInt = isLocalInt;
    }

    public void setPackLevel(Integer packLevel) {
        this.packLevel = packLevel;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodeList(String codeList) {
        this.codeList = codeList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public void setIsLocal_Int(Integer isLocal_Int) {
        this.isLocal_Int = isLocal_Int;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }
}
