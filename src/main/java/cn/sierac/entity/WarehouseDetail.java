package cn.sierac.entity;

import cn.sierac.utils.UuidUtils;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 出库单据详细下载接口实体类
 * Created by Jack on 2017/7/31.
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class WarehouseDetail {

     public WarehouseDetail(){}

     private String id ;

     private String code;

     private String  headerId;

     private String productId;

     private String productCode;

     private String productSku;

     private String productName;

     private String sendId;

     private String receiveId;

     private String receiveCode;

     private String batchCode;

     private Integer expectPcsQty;

     private Integer actualPcsQty;

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

    public String getReceiveCode() {
        return receiveCode;
    }

    public void setReceiveCode(String receiveCode) {
        this.receiveCode = receiveCode;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
