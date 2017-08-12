
package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

/**
 * 产品管理Entity
 * 
 * @author wgc
 * @version 2017-02-13
 */

public class Product  {


    private String id ;

    private String code; // 产品代码

    private String sku; // 产品SKU

    private String name; // 产品名称

    private String fullName; // 产品全称

    private String shortName; // 产品简称

    private String englishName; // 英文名

    private String spec; // 规格

    private Integer shelfLife; // 保质期

    private String ctnGtin; // 箱GTIN

    private String pcsGtin; // 单品GTIN

    private Integer typeId; // 产品类型

    private Integer active; // 可用

    private Integer pcsQty; // 每箱单品数

    private Integer ctnQty; // 每托箱数

    @NotNull(message = "条码不能为空")
    private String barcode; // 条码

    private String jdeCode; // JDE编码

    private String type;// 产品类型


    public Product() {
        super();
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getCtnGtin() {
        return ctnGtin;
    }

    public void setCtnGtin(String ctnGtin) {
        this.ctnGtin = ctnGtin;
    }

    public String getPcsGtin() {
        return pcsGtin;
    }

    public void setPcsGtin(String pcsGtin) {
        this.pcsGtin = pcsGtin;
    }

    @JsonIgnore
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @JsonIgnore
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getPcsQty() {
        return pcsQty;
    }

    public void setPcsQty(Integer pcsQty) {
        this.pcsQty = pcsQty;
    }

    public Integer getCtnQty() {
        return ctnQty;
    }

    public void setCtnQty(Integer ctnQty) {
        this.ctnQty = ctnQty;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getJdeCode() {
        return jdeCode;
    }

    public void setJdeCode(String jdeCode) {
        this.jdeCode = jdeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
