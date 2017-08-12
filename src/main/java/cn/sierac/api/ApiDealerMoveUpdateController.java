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
 * 经销商调拨单据上传
 * Created by pinkMan on 2017/8/2.
 */
@RestController
@RequestMapping("/api/dealerMove/")
public class ApiDealerMoveUpdateController {

    @Autowired
    private DealerMoveService dealerMoveService;

    @Autowired
    private DealerMoveDetailService dealerMoveDetailService;

    @Autowired
    private DealerMoveDataService dealerMoveDataService;

    @Autowired
    private CodeDataService codeDataService;

    @PostMapping(value = "out/update")
    public Object list(@RequestBody DealerMoveHeader dealerMoveHeader, HttpServletRequest request){
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        Map<String, String> map = new HashMap<String, String>();
        List<Map> list = new ArrayList<Map>();
        list.add(map);
        jsonMap.put("data", list);
        if (ValidateToken.isToken(request)) {
            CodeData codeData = new CodeData();
            try{
                dealerMoveHeader.setUploadTime(new Date());
                dealerMoveHeader.setSubmitDate(new Date());
                DealerMove move=dealerMoveService.findByCode(dealerMoveHeader.getCode());
                if ("0".equals(move.getBillStatus())) {
                    map.put("code", "-1");
                    map.put("message", "该数据已上传");
                    list.add(map);
                    return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list , HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
                }
                dealerMoveService.update(dealerMoveHeader);
                codeData.setOutHeaderId(dealerMoveHeader.getId());
                codeData.setProductId(dealerMoveHeader.getProductId());
                //保存数据存储
                Map<String, Object> codeMap = new HashMap<String, Object>();
                codeMap.put("moveHeaderId", dealerMoveHeader.getId());

                for (int j = 0; j < dealerMoveHeader.getDetailList().size(); j++) {
                    String moveHeaderId = (String) codeMap.get("moveHeaderId");
                    codeMap.clear();
                    codeMap.put("moveHeaderId", moveHeaderId);
                    DealerMoveDetail dealerMoveDetail = dealerMoveHeader.getDetailList().get(j);
                    dealerMoveDetailService.update(dealerMoveDetail);
                    List<DealerMoveData> dealerMoveDataList = dealerMoveDetail.getDataList();
                    for (DealerMoveData dealerMoveData: dealerMoveDataList) {
                       dealerMoveData.setCode(dealerMoveData.getScanCode());
                        Date date = new Date();
                        CodeData codeData1 = new CodeData();
                        codeData1.setCode(dealerMoveData.getScanCode());
                        codeData1.setUpdateDate(date);
                        codeData1.setOutHeaderId(dealerMoveData.getHeaderId());
                        codeData1.setStatus("1");
                        codeDataService.updateAll(codeData1);
                        if (dealerMoveData.getPackLevel() == 2) {
                            List<CodeData> codeDataList1 = codeDataService.findByParentCode(codeData1);
                            List<DealerMoveData> dealerMoveDataList1 = processCodeData(codeDataList1, dealerMoveData);
                                dealerMoveDataService.insertBatch(dealerMoveDataList);
                            updateByParentCode(codeData1);
                        } else if (dealerMoveData.getPackLevel() == 1) {

                        } else if (dealerMoveData.getPackLevel() == 3) {
                        }
                    }
                    //批量插入apidata
                    if (dealerMoveDataList.size() > 0) {
                            dealerMoveDataService.insertBatch(dealerMoveDataList);
                    }
                }

                dealerMoveHeader.setBillStatus("0");
                dealerMoveService.updateStatus(dealerMoveHeader);
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

    public List<DealerMoveData> processCodeData(List<CodeData> codeDataList, DealerMoveData dealerMoveData) {
        List<DealerMoveData> dealerMoveDataList = new ArrayList<DealerMoveData>(codeDataList.size());
        for (CodeData cd : codeDataList) {
            DealerMoveData dealerMoveData1 = new DealerMoveData(cd);
            dealerMoveData1.setScanCode(dealerMoveData.getScanCode());
            dealerMoveData1.setScanBy(dealerMoveData.getScanBy());
            dealerMoveData1.setDetailId(dealerMoveData.getDetailId());
            dealerMoveData1.setHeaderId(dealerMoveData.getHeaderId());
            dealerMoveData1.setQty(1);
            dealerMoveData1.setScanTime(dealerMoveData.getScanTime());
            dealerMoveDataList.add(dealerMoveData1);
        }
        return dealerMoveDataList;
    }

    public void updateByParentCode(CodeData codeData) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("updateDate", codeData.getUpdateDate());
        map1.put("status", "1");
        map1.put("outHeaderId", codeData.getOutHeaderId());
        map1.put("parentCode", codeData.getCode());
    }

}
