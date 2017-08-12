package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerMove;
import cn.sierac.entity.DealerReceive;
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
import java.util.List;

/**
 * 经销商收货出库
 * Created by pinkMan on 2017/8/4.
 */
@RestController
@RequestMapping("/api/dealerReceive/")
public class ApiDealerReceiveController {

    @Autowired
    private DealerReceiveService dealerReceiveService;

    /**
     *
     * @param request
     * @param dealerReceive
     * @return
     */
    @PostMapping(value = "out/list")
    public Object list(HttpServletRequest request, @RequestBody DealerReceive dealerReceive) {
        if (ValidateToken.isToken(request)) {
                List<DealerReceive> dealerReceiveList = dealerReceiveService.findAll(dealerReceive);
            for(int i= 0;i<dealerReceiveList.size();i++){
                if (dealerReceiveList.get(i).getUploadTime() != null && !"".equals(dealerReceiveList.get(i).getUploadTime()) ) {
                    dealerReceiveList.get(i).setUploadTime(DateUtils.cover(dealerReceiveList.get(i).getUploadTime()));
                }
                if (dealerReceiveList.get(i).getScanBeginTime() != null && !"".equals(dealerReceiveList.get(i).getUploadTime()) ) {
                    dealerReceiveList.get(i).setScanBeginTime(DateUtils.cover(dealerReceiveList.get(i).getScanBeginTime()));
                }
                if (dealerReceiveList.get(i).getSubmitDate() != null && !"".equals(dealerReceiveList.get(i).getUploadTime()) ) {
                    dealerReceiveList.get(i).setSubmitDate(DateUtils.cover(dealerReceiveList.get(i).getSubmitDate()));
                }

            }

            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), dealerReceiveList, HttpStatus.OK), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }


}
