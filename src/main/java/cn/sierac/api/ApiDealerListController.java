package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.Dealer;
import cn.sierac.entity.RdcOutHeader;
import cn.sierac.service.DealerService;
import cn.sierac.utils.CollectionType;
import cn.sierac.utils.DateUtils;
import cn.sierac.utils.ValidateToken;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 经销商出库
 * Created by Jack on 2017/7/27.
 */
@RestController
@RequestMapping(value = "/api/dealer/")
public class ApiDealerListController {

    @Autowired
    private DealerService dealerService;

    /**
     * 经销商出库
     * @param request
     * @param dealer
     * @return
     */
    @PostMapping(value = "out/list" )
    public Object list(HttpServletRequest request , @RequestBody Dealer dealer) {
            dealer.setBillStatus("1");
            List<Dealer> dealerList = dealerService.findAll(dealer);
            for (Dealer d : dealerList) {
                if (!("").equals(d.getUploadTime()) && d.getUploadTime() != null) {
                    String da = d.getUploadTime();
                    da = DateUtils.cover(da);
                    d.setUploadTime(da);
                } else {
                    return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), "上传时间为空", HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);

                }
            }
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), dealerList, HttpStatus.OK), HttpStatus.OK);
        }
}
