package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 仓库调拨出库实体
 * Created by pinkman on 2017/7/29.
 */
public class WarehouseMoveData extends  ApiRdcOutData{

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

    public WarehouseMoveData(){
    }
    public WarehouseMoveData(CodeData codeData){
        this.id=codeData.getId();
        this.parentCode=codeData.getParentCode();
        this.packLevel=codeData.getPackLevel();
        this.code=codeData.getCode();
        this.headerId=codeData.getOutHeaderId();
        this.batchCode=codeData.getBatchCode();
        this.productId=codeData.getProductId();
    }
}
