package cn.sierac.entity;

import java.util.List;

/**
 * 出库
 * Created by pinkman on 2017/7/31.
 */
public class WarehouseMoveDetail extends WarehouseDetail{
    public WarehouseMoveDetail(){

    }
    private List<WarehouseMoveData> dataList;

    public List<WarehouseMoveData> getDataList() {
        return dataList;
    }

    public void setDataList(List<WarehouseMoveData> dataList) {
        this.dataList = dataList;
    }
}
