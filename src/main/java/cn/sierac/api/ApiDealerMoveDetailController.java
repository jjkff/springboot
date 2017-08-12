package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerMoveDetail;
import cn.sierac.entity.WarehouseMoveDetail;
import cn.sierac.service.DealerMoveDetailService;
import cn.sierac.service.WarehouseMoveDetailService;
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
 * Created by pinkMan on 2017/8/2.
 */
@RestController
@RequestMapping("/api/dealerMove/")
public class ApiDealerMoveDetailController {

    @Autowired
    private DealerMoveDetailService dealerMoveDetailService;

    /**
     * 经销商调拨出库详情查询
     * @param request
     * @param dealerMoveDetail
     * @return
     */
    @PostMapping(value = "out/detail")
    public Object detail(HttpServletRequest request, @RequestBody DealerMoveDetail dealerMoveDetail){

        if(ValidateToken.isToken(request)){
                List<DealerMoveDetail> moveDetailList = dealerMoveDetailService.findDealerMoveDetail(dealerMoveDetail);
                return new ResponseEntity<>(new Result(HttpStatus.OK.value(), moveDetailList, HttpStatus.OK), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }
}
