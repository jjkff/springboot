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
 * 经销商收货单据上传
 * Created by pinkMan on 2017/8/5.
 */
@RestController
@RequestMapping("/api/dealerReceive/")
public class ApiDealerReceiveUpdateController {

    @Autowired
    private DealerReceiveService dealerReceiveService;

    @Autowired
    private DealerReceiveDetailService dealerReceiveDetailService;

    @Autowired
    private DealerReceiveDataService dealerReceiveDataService;

    @Autowired
    private CodeDataService codeDataService;

    @PostMapping(value = "out/update")
    public Object list(@RequestBody DealerReceiveHeader dealerReceiveHeader, HttpServletRequest request){
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        Map<String, String> map = new HashMap<String, String>();
        List<Map> list = new ArrayList<Map>();
        list.add(map);
        jsonMap.put("data", list);
        if (ValidateToken.isToken(request)) {
            CodeData codeData = new CodeData();
            try{
                dealerReceiveHeader.setUploadTime(new Date());
                dealerReceiveHeader.setSubmitDate(new Date());
                DealerReceive receive=dealerReceiveService.findByCode(dealerReceiveHeader.getCode());
                if ("0".equals(receive.getBillStatus())) {
                    map.put("code", "-1");
                    map.put("message", "该数据已上传");
                    list.add(map);
                    return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list , HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
                }
                dealerReceiveService.update(dealerReceiveHeader);
                codeData.setOutHeaderId(dealerReceiveHeader.getId());
                codeData.setProductId(dealerReceiveHeader.getProductId());
                //保存数据存储
                Map<String, Object> codeMap = new HashMap<String, Object>();
                codeMap.put("receiveHeaderId", dealerReceiveHeader.getId());

                for (int j = 0; j < dealerReceiveHeader.getDetailList().size(); j++) {
                    String receiveHeaderId = (String) codeMap.get("receiveHeaderId");
                    codeMap.clear();
                    codeMap.put("receiveHeaderId", receiveHeaderId);
                    DealerReceiveDetail dealerReceiveDetail = dealerReceiveHeader.getDetailList().get(j);
                    dealerReceiveDetailService.update(dealerReceiveDetail);
                    List<DealerReceiveData> dealerReceiveDataList = dealerReceiveDetail.getDataList();
                    for (DealerReceiveData dealerReceiveData: dealerReceiveDataList) {
                       dealerReceiveData.setCode(dealerReceiveData.getScanCode());
                        Date date = new Date();
                        CodeData codeData1 = new CodeData();
                        codeData1.setCode(dealerReceiveData.getScanCode());
                        codeData1.setUpdateDate(date);
                        codeData1.setOutHeaderId(dealerReceiveData.getHeaderId());
                        codeData1.setStatus("1");
                        codeDataService.updateAll(codeData1);
                        if (dealerReceiveData.getPackLevel() == 2) {
                            List<CodeData> codeDataList1 = codeDataService.findByParentCode(codeData1);
                            List<DealerReceiveData> dealerReceiveDataList1 = processCodeData(codeDataList1, dealerReceiveData);
                                dealerReceiveDataService.insertBatch(dealerReceiveDataList);
                            updateByParentCode(codeData1);
                        } else if (dealerReceiveData.getPackLevel() == 1) {

                        } else if (dealerReceiveData.getPackLevel() == 3) {
                        }
                    }
                    //批量插入apidata
                    if (dealerReceiveDataList.size() > 0) {
                            dealerReceiveDataService.insertBatch(dealerReceiveDataList);
                    }
                }

                dealerReceiveHeader.setBillStatus("0");
                dealerReceiveService.updateStatus(dealerReceiveHeader);
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

    public List<DealerReceiveData> processCodeData(List<CodeData> codeDataList, DealerReceiveData dealerReceiveData) {
        List<DealerReceiveData> dealerReceiveDataList = new ArrayList<DealerReceiveData>(codeDataList.size());
        for (CodeData cd : codeDataList) {
            DealerReceiveData dealerReceiveData1 = new DealerReceiveData(cd);
            dealerReceiveData1.setScanCode(dealerReceiveData.getScanCode());
            dealerReceiveData1.setScanBy(dealerReceiveData.getScanBy());
            dealerReceiveData1.setDetailId(dealerReceiveData.getDetailId());
            dealerReceiveData1.setHeaderId(dealerReceiveData.getHeaderId());
            dealerReceiveData1.setQty(1);
            dealerReceiveData1.setScanTime(dealerReceiveData.getScanTime());
            dealerReceiveDataList.add(dealerReceiveData1);
        }
        return dealerReceiveDataList;
    }

    public void updateByParentCode(CodeData codeData) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("updateDate", codeData.getUpdateDate());
        map1.put("status", "1");
        map1.put("outHeaderId", codeData.getOutHeaderId());
        map1.put("parentCode", codeData.getCode());
    }

}
