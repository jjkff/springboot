package cn.sierac.entity;

/**
 * Created by Jack on 2017/7/29.
 */
public class WarehouseOutScanCheck {

    private String id ;

    private String code;

    private String orderCode;

    private String parentCode;

    private String batchCode;

    private String productId;

    private String productName;

    private String status;

    private String statusInfo;

    private Integer packLevel;

    private Integer  pcsPerCtn;

    private Integer ctnPerPlt;

    private String spec;

    private Integer qty;

    public WarehouseOutScanCheck() {
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public Integer getPackLevel() {
        return packLevel;
    }

    public void setPackLevel(Integer packLevel) {
        this.packLevel = packLevel;
    }

    public Integer getPcsPerCtn() {
        return pcsPerCtn;
    }

    public void setPcsPerCtn(Integer pcsPerCtn) {
        this.pcsPerCtn = pcsPerCtn;
    }

    public Integer getCtnPerPlt() {
        return ctnPerPlt;
    }

    public void setCtnPerPlt(Integer ctnPerPlt) {
        this.ctnPerPlt = ctnPerPlt;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
