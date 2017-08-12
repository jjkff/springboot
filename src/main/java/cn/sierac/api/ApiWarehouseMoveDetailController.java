package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.WarehouseMoveDetail;
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
 * Created by pinkman on 2017/7/31.
 */
@RestController
@RequestMapping("/api/warehouseMove/")
public class ApiWarehouseMoveDetailController {

    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    /**
     * 仓库调拨出库详情查询
     * @param request
     * @param warehouseMoveDetail1
     * @return
     */
    @PostMapping(value = "out/detail")
    public Object detail(HttpServletRequest request, @RequestBody WarehouseMoveDetail warehouseMoveDetail1){

        if(ValidateToken.isToken(request)){
            List<WarehouseMoveDetail> moveDetailList=warehouseMoveDetailService.findWarehouseMoveDetail(warehouseMoveDetail1);
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), moveDetailList, HttpStatus.OK), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }
}
