package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerMoveScanCheck;
import cn.sierac.entity.DealerReceiveScanCheck;
import cn.sierac.service.DealerMoveScanCheckService;
import cn.sierac.service.DealerReceiveScanCheckService;
import cn.sierac.utils.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 经销商收货入库扫描代码
 * Created by pinkMan on 2017/8/4.
 */
@RestController
@RequestMapping("/api/dealerReceive/")
public class ApiDealerReceiveScanCheckController {

    @Autowired
    private DealerReceiveScanCheckService dealerReceiveScanCheckService;

    @PostMapping(value = "out/scanCheck")
    public Object scanCheck(HttpServletRequest request, @RequestBody DealerReceiveScanCheck dealerReceiveScanCheck){
        if(ValidateToken.isToken(request)){
                List<DealerReceiveScanCheck> receiveScanCheckList = dealerReceiveScanCheckService.findDealerReceiveDetail(dealerReceiveScanCheck);
                return new ResponseEntity<>(new Result(HttpStatus.OK.value(), receiveScanCheckList, HttpStatus.OK), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }
}
