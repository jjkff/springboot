package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerMoveDetail;
import cn.sierac.entity.DealerReceiveDetail;
import cn.sierac.service.DealerMoveDetailService;
import cn.sierac.service.DealerReceiveDetailService;
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
 * Created by pinkMan on 2017/8/4.
 */
@RestController
@RequestMapping("/api/dealerReceive/")
public class ApiDealerReceiveDetailController {

    @Autowired
    private DealerReceiveDetailService dealerReceiveDetailService;

    /**
     * 经销商收货出库详情查询
     * @param request
     * @param dealerReceiveDetail
     * @return
     */
    @PostMapping(value = "out/detail")
    public Object detail(HttpServletRequest request, @RequestBody DealerReceiveDetail dealerReceiveDetail){
        if(ValidateToken.isToken(request)){
                List<DealerReceiveDetail> ReceiveDetailList = dealerReceiveDetailService.findDealerReceiveDetail(dealerReceiveDetail);
                return new ResponseEntity<>(new Result(HttpStatus.OK.value(), ReceiveDetailList, HttpStatus.OK), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }
}
