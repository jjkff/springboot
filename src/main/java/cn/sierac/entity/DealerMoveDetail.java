package cn.sierac.entity;

import java.util.List;

/**
 * 经销商调拨出库详情
 * Created by pinkMan on 2017/8/2.
 */
public class DealerMoveDetail extends WarehouseDetail{
    public DealerMoveDetail(){

    }
    private List<DealerMoveData> dataList;

    public List<DealerMoveData> getDataList() {
        return dataList;
    }

    public void setDataList(List<DealerMoveData> dataList) {
        this.dataList = dataList;
    }
}
