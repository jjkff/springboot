package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 经销商收货实体
 * Created by pinkMan on 2017/8/4.
 */
public class DealerReceiveData extends  ApiRdcOutData{
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

    public DealerReceiveData(){}

    public DealerReceiveData(CodeData codeData){
        this.id=codeData.getId();
        this.parentCode=codeData.getParentCode();
        this.packLevel=codeData.getPackLevel();
        this.code=codeData.getCode();
        this.headerId=codeData.getOutHeaderId();
        this.batchCode=codeData.getBatchCode();
        this.productId=codeData.getProductId();
    }

    @Override
    public String getHeaderId() {
        return headerId;
    }

    @Override
    public String getDetailId() {
        return detailId;
    }

    @Override
    public String getParentCode() {
        return parentCode;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public String getBatchCode() {
        return batchCode;
    }

    @Override
    public String getScanCode() {
        return scanCode;
    }

    @Override
    public String getScanBy() {
        return scanBy;
    }

    @Override
    public Date getScanTime() {
        return scanTime;
    }

    @Override
    public Integer getQty() {
        return qty;
    }

    @Override
    public Integer getIsLocalInt() {
        return isLocalInt;
    }

    @Override
    public Integer getPackLevel() {
        return packLevel;
    }

    @Override
    public String getBoxCode() {
        return boxCode;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getCodeList() {
        return codeList;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isLocal() {
        return isLocal;
    }

    @Override
    public Integer getIsLocal_Int() {
        return isLocal_Int;
    }

    @Override
    public String getMaterialId() {
        return materialId;
    }

    @Override
    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    @Override
    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    @Override
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    @Override
    public void setScanCode(String scanCode) {
        this.scanCode = scanCode;
    }

    @Override
    public void setScanBy(String scanBy) {
        this.scanBy = scanBy;
    }

    @Override
    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    @Override
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public void setIsLocalInt(Integer isLocalInt) {
        this.isLocalInt = isLocalInt;
    }

    @Override
    public void setPackLevel(Integer packLevel) {
        this.packLevel = packLevel;
    }

    @Override
    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setCodeList(String codeList) {
        this.codeList = codeList;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setLocal(boolean local) {
        isLocal = local;
    }

    @Override
    public void setIsLocal_Int(Integer isLocal_Int) {
        this.isLocal_Int = isLocal_Int;
    }

    @Override
    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }
}
