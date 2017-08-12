package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerMove;
import cn.sierac.entity.DealerMoveScanCheck;
import cn.sierac.entity.DealerReceive;
import cn.sierac.entity.DealerReceiveScanCheck;
import cn.sierac.service.DealerMoveService;
import cn.sierac.service.DealerReceiveService;
import cn.sierac.utils.DateUtils;
import cn.sierac.utils.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 经销商收货入库状态
 * Created by pinkMan on 2017/8/4.
 */
@RestController
@RequestMapping("api/dealerReceive/")
public class ApiDealerReceiveCheckStatusController {

    @Autowired
    private DealerReceiveService dealerReceiveService;

    /**
     * 经销商收货入库状态查询
     * @param request
     * @param dealerReceiveScanCheck
     * @return
     */
    @PostMapping(value = "out/scanStatus")
    public Object list(HttpServletRequest request, @RequestBody DealerReceiveScanCheck dealerReceiveScanCheck){
        List<DealerReceive> dealerList=new ArrayList<DealerReceive>();
        if(ValidateToken.isToken(request)){
                DealerReceive dealerReceive = dealerReceiveService.findByCode(dealerReceiveScanCheck.getCode());
                dealerReceive.setCode(dealerReceive.getBillStatus());
                dealerList.add(dealerReceive);
                    for (int i = 0; i < dealerList.size(); i++) {
                        if ( dealerList.get(i).getUploadTime() != null && !"".equals(dealerList.get(i).getUploadTime())) {
                            dealerList.get(i).setUploadTime(DateUtils.cover(dealerList.get(i).getUploadTime()));
                        }
                        if (dealerList.get(i).getScanBeginTime() != null && !"".equals(dealerList.get(i).getUploadTime()) ) {
                            dealerList.get(i).setScanBeginTime(DateUtils.cover(dealerList.get(i).getScanBeginTime()));
                        }
                        if (dealerList.get(i).getSubmitDate() != null && !"".equals(dealerList.get(i).getUploadTime())) {
                            dealerList.get(i).setSubmitDate(DateUtils.cover(dealerList.get(i).getSubmitDate()));
                        }
                    }
                return new ResponseEntity<>(new Result(HttpStatus.OK.value(), dealerList, HttpStatus.OK), HttpStatus.OK);
        }
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);

    }
}
