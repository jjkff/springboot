package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.*;
import cn.sierac.service.*;
import cn.sierac.utils.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * apiRdcOutHeader
 *ApiRdcOutDetail
 * ApiRdcOutData
 * RdcOutHeader
 * Created by Jack on 2017/8/1.
 */
@RestController
@RequestMapping(value ="api/dealer/")
public class ApiDealerUpdateController {

    @Autowired
    private ApiDealerService apiDealerService;

    @Autowired
    private ApiDealerDataService apiDealerDataService;

    @Autowired
    private ApiDealerDetailService apiDealerDetailService ;

    @Autowired
    private DealerService dealerService;

    @Autowired
    private CodeDataService codeDataService;

    @PostMapping(value = "out/update")
    @Transactional(rollbackFor = {Exception.class}) //事物回滚：当B方法报错，B上面的A方法会进行回滚
    public Object list(@RequestBody ApiDealer apiDealer  , HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        List<Map> list = new ArrayList<Map>();
        if (ValidateToken.isToken(request)) {
            CodeData codeData = new CodeData();

            try {
                apiDealer.setUpdateDate(new Date());
                apiDealer.setSubmitDate(new Date());
                Dealer header = dealerService.findByCode(apiDealer.getCode());
                if ("0".equals(header.getBillStatus())) {
                    map.put("code", "-1");
                    map.put("message", "该数据已上传");
                    list.add(map);
                    return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
                }
                apiDealer.setBillStatus("1");
                apiDealerService.save(apiDealer);
                codeData.setOutHeaderId(apiDealer.getId());
                codeData.setProductId(apiDealer.getProductId());
                //保存数据存储
                Map<String, Object> codeMap = new HashMap<String, Object>();
                codeMap.put("outHeaderId", apiDealer.getId());
                for (int j = 0; j < apiDealer.getDetailList().size(); j++) {
                    String outHeaderId = (String) codeMap.get("outHeaderId");
                    codeMap.clear();
                    codeMap.put("outHeaderId", outHeaderId);
                    ApiDealerDetail apiDealerDetail = apiDealer.getDetailList().get(j);
                    apiDealerDetailService.save(apiDealerDetail);
                    List<ApiDealerData> apiDealerDatas = apiDealerDetail.getDataList();
                    for (ApiDealerData apiDealerData : apiDealerDatas) {
                        apiDealerData.setCode(apiDealerData.getScanCode());
                        Date date = new Date();
                        CodeData codeData1 = new CodeData();
                        codeData1.setCode(apiDealerData.getScanCode());
                        codeData1.setUpdateDate(date);
                        codeData1.setOutHeaderId(apiDealerData.getHeaderId());
                        codeData1.setStatus("1");
                        codeDataService.updateAll(codeData1);
                        if (apiDealerData.getPackLevel() == 2) {
                            List<CodeData> codeDataList1 = codeDataService.findByParentCode(codeData1);
                            List<ApiDealerData> data = processCodeData(codeDataList1, apiDealerData);
                            apiDealerDataService.saveBatch(data);
                            updateByParentCode(codeData1);
                        } else if (apiDealerData.getPackLevel() == 1) {
                        } else if (apiDealerData.getPackLevel() == 3) {
                          /*  //扫描托码的处理
                            CodeData cd = new CodeData();
                            List<CodeData> ctnList = codeDataService.findByParentCode(cd);
                            Map<String, Object> map1 = new HashMap<String, Object>();
                            map1.put("updateDate", codeData.getUpdateDate());
                            map1.put("outHeaderId", codeData.getOutHeaderId());
                            map1.put("status", "1");
                            List<String> parentCodeList = new ArrayList<String>();
                            for (CodeData data : ctnList) {
                                parentCodeList.add(data.getCode());
                            }
                            map1.put("parentCodeList", parentCodeList);
                            codeDataService.updateBatchByParentCode(map1);*/

                        }


                    }
                    //批量插入apidata
                    if (apiDealerDatas.size() > 0) {
                        apiDealerDataService.saveBatch(apiDealerDatas);


                    }
                }
                map.put("code", "0");
                apiDealer.setBillStatus("0");
                apiDealerService.save(apiDealer);
                map.put("message", "上传成功");
                list.add(map);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("code", "-1");
                e.getLocalizedMessage();
                map.put("message", "上传失败:" + e.getMessage());
                list.add(map);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                e.printStackTrace();
                return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
            }

        } else {
            map.put("code","-1");
            map.put("message", "上传失败");
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(new Result(HttpStatus.OK.value(), list, HttpStatus.OK), HttpStatus.OK);
    }

    public List<ApiDealerData> processCodeData(List<CodeData> codeDataList, ApiDealerData apiDealerData) {
        List<ApiDealerData> apiDealerDatas = new ArrayList<ApiDealerData>(codeDataList.size());
        for (CodeData cd : codeDataList) {
            ApiDealerData apiDealerData1 = new ApiDealerData(cd);
            apiDealerData1.setScanCode(apiDealerData.getScanCode());
            apiDealerData1.setScanBy(apiDealerData.getScanBy());
            apiDealerData1.setDetailId(apiDealerData.getDetailId());
            apiDealerData1.setHeaderId(apiDealerData.getHeaderId());
            apiDealerData1.setQty(1);
            apiDealerData1.setScanTime(apiDealerData.getScanTime());
            apiDealerDatas.add(apiDealerData1);
        }
        return apiDealerDatas;
    }

        public void updateByParentCode(CodeData codeData) {
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("updateDate", codeData.getUpdateDate());
            map1.put("status", "1");
            map1.put("outHeaderId", codeData.getOutHeaderId());
            map1.put("parentCode", codeData.getCode());
        }
}
