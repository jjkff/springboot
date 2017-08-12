package cn.sierac.entity;

import java.util.List;

/**
 * 收货
 * Created by pinkMan on 2017/8/4.
 */
public class DealerReceiveDetail extends WarehouseDetail{
    public DealerReceiveDetail(){

    }
    private List<DealerReceiveData> dataList;

    public List<DealerReceiveData> getDataList() {
        return dataList;
    }

    public void setDataList(List<DealerReceiveData> dataList) {
        this.dataList = dataList;
    }
}
