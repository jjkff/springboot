package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.dao.DealerMapperDao;
import cn.sierac.entity.Dealer;
import cn.sierac.entity.RdcOutHeader;
import cn.sierac.service.DealerService;
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
 * 出库单据状态接口
 * Created by Jack on 2017/8/1.
 */
@RestController
@RequestMapping(value = "api/dealer")
public class ApiDealerScanStatusController {

    @Autowired
    private DealerService dealerService;

    /**
     * 出库单据
     * @param dealer
     * @param request
     * @return
     */
    @PostMapping(value = "out/scanStatus")
    public Object list(@RequestBody Dealer dealer , HttpServletRequest request){
        List<Dealer> dealers = new ArrayList<>();
        if (ValidateToken.isToken(request)) {
            Dealer d =  dealerService.findByCode(dealer.getCode());
            d.setCode(d.getBillStatus());
            dealers.add(d);
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), dealers, HttpStatus.OK), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
    }
}
