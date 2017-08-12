package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.*;
import cn.sierac.service.*;
import cn.sierac.utils.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 仓库调拨单据上传
 * Created by pinkMan on 2017/8/1.
 */
@RestController
@RequestMapping("/api/warehouseMove/")
public class ApiWarehouseMoveUpdateController {

    @Autowired
    private WarehouseMoveService warehouseMoveService;

    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    @Autowired
    private WarehouseMoveDataService warehouseMoveDataService;

    @Autowired
    private CodeDataService codeDataService;

    @PostMapping(value = "out/update")
    public Object list(@RequestBody WarehouseMoveHeader warehouseMoveHeader, HttpServletRequest request){
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        Map<String, String> map = new HashMap<String, String>();
        List<Map> list = new ArrayList<Map>();
        list.add(map);
        jsonMap.put("data", list);
        if (ValidateToken.isToken(request)) {
            CodeData codeData = new CodeData();
            try{
                warehouseMoveHeader.setUploadTime(new Date());
                warehouseMoveHeader.setSubmitDate(new Date());
                WarehouseMove move=warehouseMoveService.findByCode(warehouseMoveHeader.getCode());
                if ("0".equals(move.getBillStatus())) {
                    map.put("code", "-1");
                    map.put("message", "该数据已上传");
                    list.add(map);
                    return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list , HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
                }
                warehouseMoveService.update(warehouseMoveHeader);
                codeData.setOutHeaderId(warehouseMoveHeader.getId());
                codeData.setProductId(warehouseMoveHeader.getProductId());
                //保存数据存储
                Map<String, Object> codeMap = new HashMap<String, Object>();
                codeMap.put("moveHeaderId", warehouseMoveHeader.getId());

                for (int j = 0; j < warehouseMoveHeader.getDetailList().size(); j++) {
                    String moveHeaderId = (String) codeMap.get("moveHeaderId");
                    codeMap.clear();
                    codeMap.put("moveHeaderId", moveHeaderId);
                    WarehouseMoveDetail warehouseMoveDetail = warehouseMoveHeader.getDetailList().get(j);
                    warehouseMoveDetailService.update(warehouseMoveDetail);
                    List<WarehouseMoveData> warehouseMoveDataList = warehouseMoveDetail.getDataList();
                    for (WarehouseMoveData warehouseMoveData: warehouseMoveDataList) {
                       warehouseMoveData.setCode(warehouseMoveData.getScanCode());
                        Date date = new Date();
                        CodeData codeData1 = new CodeData();
                        codeData1.setCode(warehouseMoveData.getScanCode());
                        codeData1.setUpdateDate(date);
                        codeData1.setOutHeaderId(warehouseMoveData.getHeaderId());
                        codeData1.setStatus("1");
                        codeDataService.updateAll(codeData1);
                        if (warehouseMoveData.getPackLevel() == 2) {
                            List<CodeData> codeDataList1 = codeDataService.findByParentCode(codeData1);
                            List<WarehouseMoveData> warehouseMoveDataList1 = processCodeData(codeDataList1, warehouseMoveData);
                                warehouseMoveDataService.insertBatch(warehouseMoveDataList);
                            updateByParentCode(codeData1);
                        } else if (warehouseMoveData.getPackLevel() == 1) {

                        } else if (warehouseMoveData.getPackLevel() == 3) {
                        }
                    }
                    //批量插入apidata
                    if (warehouseMoveDataList.size() > 0) {
                            warehouseMoveDataService.insertBatch(warehouseMoveDataList);
                    }
                }

                warehouseMoveHeader.setBillStatus("0");
                warehouseMoveService.updateStatus(warehouseMoveHeader);
                map.put("code", "0");
                map.put("message", "上传成功");
            }catch(Exception e){
                e.printStackTrace();
                map.put("code", "-1");
                e.getLocalizedMessage();
                map.put("message", "上传失败:" + e.getMessage());
                list.add(map);
                return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list , HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
            }
        }else {
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(new Result(HttpStatus.OK.value(), list , HttpStatus.OK), HttpStatus.OK);
    }

    public List<WarehouseMoveData> processCodeData(List<CodeData> codeDataList, ApiRdcOutData apiRdcOutData) {
        List<WarehouseMoveData> warehouseMoveDataList = new ArrayList<WarehouseMoveData>(codeDataList.size());
        for (CodeData cd : codeDataList) {
            WarehouseMoveData warehouseMoveData1 = new WarehouseMoveData(cd);
            warehouseMoveData1.setScanCode(apiRdcOutData.getScanCode());
            warehouseMoveData1.setScanBy(apiRdcOutData.getScanBy());
            warehouseMoveData1.setDetailId(apiRdcOutData.getDetailId());
            warehouseMoveData1.setHeaderId(apiRdcOutData.getHeaderId());
            warehouseMoveData1.setQty(1);
            warehouseMoveData1.setScanTime(apiRdcOutData.getScanTime());
            warehouseMoveDataList.add(warehouseMoveData1);
        }
        return warehouseMoveDataList;
    }

    public void updateByParentCode(CodeData codeData) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("updateDate", codeData.getUpdateDate());
        map1.put("status", "1");
        map1.put("outHeaderId", codeData.getOutHeaderId());
        map1.put("parentCode", codeData.getCode());
    }

}
