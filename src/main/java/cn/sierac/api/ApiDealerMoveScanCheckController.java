package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerMoveScanCheck;
import cn.sierac.service.DealerMoveScanCheckService;
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
 * 经销商调拨出库扫描代码
 * Created by pinkMan on 2017/7/31.
 */
@RestController
@RequestMapping("/api/dealerMove/")
public class ApiDealerMoveScanCheckController {

    @Autowired
    private DealerMoveScanCheckService dealerMoveScanCheckService;

    @PostMapping(value = "out/scanCheck")
    public Object scanCheck(HttpServletRequest request, @RequestBody DealerMoveScanCheck dealerMoveScanCheck){
        if(ValidateToken.isToken(request)){
            List<DealerMoveScanCheck> moveScanCheckList=dealerMoveScanCheckService.findDealerMoveDetail(dealerMoveScanCheck);
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), moveScanCheckList, HttpStatus.OK), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }
}
