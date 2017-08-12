package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.dao.DealerDetailDao;
import cn.sierac.entity.DealerDetail;
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
 * 经销商调拨出库单据详细下载接口
 * Created by Jack on 2017/8/1.
 */
@RestController
@RequestMapping("/api/dealer/")
public class ApiDealerDetailController {


    @Autowired
    private DealerDetailDao dealerDetailDao;

    /**
     *经销商调拨出库单据详细下载接口
     * @param dealerDetail
     * @param request
     * @return
     */
    @PostMapping(value = "out/detail")
    public Object list(@RequestBody DealerDetail dealerDetail , HttpServletRequest request){

        if (ValidateToken.isToken(request)) {
            List<DealerDetail> dealerDetails =  dealerDetailDao.findDealerDetail(dealerDetail);
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), dealerDetails, HttpStatus.OK), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
    }

}
