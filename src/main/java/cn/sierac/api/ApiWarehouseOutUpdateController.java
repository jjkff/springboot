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
 * 出库单据上传接口
 * Created by Jack on 2017/7/31.
 */
@RestController
@RequestMapping(value = "/api/warehouse/")
public class ApiWarehouseOutUpdateController {

    @Autowired
    private ApiRdcOutHeaderService apiRdcOutHeaderService;

    @Autowired
    private ApiRdcOutDetailService apiRdcOutDetailService;

    @Autowired
    private ApiRdcOutDataService apiRdcOutDataService;

    @Autowired
    private RdcOutHeaderService rdcOutHeaderService;

    @Autowired
    private CodeDataService codeDataService;

    @PostMapping(value = "out/update" )
    @Transactional(rollbackFor = {Exception.class})
    public Object list(@RequestBody  ApiRdcOutHeader apiRdcOutHeader, HttpServletRequest request)
    {
        Map<String, String> map = new HashMap<String, String>();
        List<Map> list = new ArrayList<Map>();
        if (ValidateToken.isToken(request)) {
            CodeData codeData = new CodeData();
            try {
                apiRdcOutHeader.setUpdateDate(new Date());
                apiRdcOutHeader.setSubmitDate(new Date());
                RdcOutHeader header = rdcOutHeaderService.findByCode(apiRdcOutHeader.getCode());
                if ("0".equals(header.getBillStatus())) {
                    map.put("code", "-1");
                    map.put("message", "该数据已上传");
                    list.add(map);
                    return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list , HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
                }
                apiRdcOutHeaderService.save(apiRdcOutHeader);
                codeData.setOutHeaderId(apiRdcOutHeader.getId());
                codeData.setProductId(apiRdcOutHeader.getProductId());
                //保存数据存储
                Map<String, Object> codeMap = new HashMap<String, Object>();
                codeMap.put("outHeaderId", apiRdcOutHeader.getId());
                for (int j = 0; j < apiRdcOutHeader.getDetailList().size(); j++) {
                    String outHeaderId = (String) codeMap.get("outHeaderId");
                    codeMap.clear();
                    codeMap.put("outHeaderId", outHeaderId);
                    ApiRdcOutDetail apiRdcOutDetail = apiRdcOutHeader.getDetailList().get(j);
                    apiRdcOutDetailService.save(apiRdcOutDetail);
                    List<ApiRdcOutData> apiRdcOutDataList = apiRdcOutDetail.getDataList();
                    for (ApiRdcOutData apiRdcOutData: apiRdcOutDataList) {
                        apiRdcOutData.setCode(apiRdcOutData.getScanCode());
                        Date date = new Date();
                        CodeData codeData1 = new CodeData();
                        codeData1.setCode(apiRdcOutData.getScanCode());
                        codeData1.setUpdateDate(date);
                        codeData1.setOutHeaderId(apiRdcOutData.getHeaderId());
                        codeData1.setStatus("1");
                        codeDataService.updateAll(codeData1);
                        if (apiRdcOutData.getPackLevel() == 2) {
                            List<CodeData> codeDataList1 = codeDataService.findByParentCode(codeData1);
                            List<ApiRdcOutData> apiRdcOutDataList1 = processCodeData(codeDataList1, apiRdcOutData);
                            apiRdcOutDataService.saveBatch(apiRdcOutDataList1);
                            updateByParentCode(codeData1);
                        } else if (apiRdcOutData.getPackLevel() == 1) {
//                            codes.add(apiRdcOutData.getCode());
                        } else if (apiRdcOutData.getPackLevel() == 3) {
                          /*  //扫描托码的处理
                            CodeData cd = new CodeData();
                            cd.setCode(apiRdcOutData.getCode());
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
                    if (apiRdcOutDataList.size() > 0) {
                        apiRdcOutDataService.saveBatch(apiRdcOutDataList);


                    }
                }
                map.put("code", "0");
                apiRdcOutHeader.setBillStatus("0");
                apiRdcOutHeaderService.save(apiRdcOutHeader);
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
                return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list , HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
            }

        } else {
             return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), list, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(new Result(HttpStatus.OK.value(), list , HttpStatus.OK), HttpStatus.OK);
    }


        public List<ApiRdcOutData> processCodeData(List<CodeData> codeDataList, ApiRdcOutData apiRdcOutData) {
        List<ApiRdcOutData> apiRdcOutDataList = new ArrayList<ApiRdcOutData>(codeDataList.size());
        for (CodeData cd : codeDataList) {
            ApiRdcOutData apiRdcOutData1 = new ApiRdcOutData(cd);
            apiRdcOutData1.setScanCode(apiRdcOutData.getScanCode());
            apiRdcOutData1.setScanBy(apiRdcOutData.getScanBy());
            apiRdcOutData1.setDetailId(apiRdcOutData.getDetailId());
            apiRdcOutData1.setHeaderId(apiRdcOutData.getHeaderId());
            apiRdcOutData1.setQty(1);
            apiRdcOutData1.setScanTime(apiRdcOutData.getScanTime());
            apiRdcOutDataList.add(apiRdcOutData1);
        }
        return apiRdcOutDataList;
    }

        public void updateByParentCode(CodeData codeData) {
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("updateDate", codeData.getUpdateDate());
            map1.put("status", "1");
            map1.put("outHeaderId", codeData.getOutHeaderId());
            map1.put("parentCode", codeData.getCode());
        }

}
