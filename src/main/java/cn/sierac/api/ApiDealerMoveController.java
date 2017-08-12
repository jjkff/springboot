package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerMove;
import cn.sierac.entity.WarehouseMove;
import cn.sierac.service.DealerMoveService;
import cn.sierac.service.WarehouseMoveService;
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
import java.util.List;

/**
 * 经销商调拨出库
 * Created by pinkman on 2017/8/2.
 */
@RestController
@RequestMapping("/api/dealerMove/")
public class ApiDealerMoveController {

    @Autowired
    private DealerMoveService dealerMoveService;

    /**
     *
     * @param request
     * @param dealerMove
     * @return
     */
    @PostMapping(value = "out/list")
    public Object list(HttpServletRequest request, @RequestBody DealerMove dealerMove) {
        if (ValidateToken.isToken(request)) {
                List<DealerMove> dealerMoveList = dealerMoveService.findAll(dealerMove);
            for(int i= 0;i<dealerMoveList.size();i++){
                if (dealerMoveList.get(i).getUploadTime() != null && !"".equals(dealerMoveList.get(i).getUploadTime()) ) {
                    dealerMoveList.get(i).setUploadTime(DateUtils.cover(dealerMoveList.get(i).getUploadTime()));
                }
                if (dealerMoveList.get(i).getScanBeginTime() != null && !"".equals(dealerMoveList.get(i).getUploadTime()) ) {
                    dealerMoveList.get(i).setScanBeginTime(DateUtils.cover(dealerMoveList.get(i).getScanBeginTime()));
                }
                if (dealerMoveList.get(i).getSubmitDate() != null && !"".equals(dealerMoveList.get(i).getUploadTime()) ) {
                    dealerMoveList.get(i).setSubmitDate(DateUtils.cover(dealerMoveList.get(i).getSubmitDate()));
                }

            }

            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), dealerMoveList, HttpStatus.OK), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }


}
