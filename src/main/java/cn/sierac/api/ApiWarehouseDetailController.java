package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.dao.WarehouseDetailDao;
import cn.sierac.entity.RdcOutHeader;
import cn.sierac.entity.WarehouseDetail;
import cn.sierac.service.WarehouseDetailService;
import cn.sierac.utils.JsonMapper;
import cn.sierac.utils.ValidateToken;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

/**
 * 出库单据详细下载接口
 * Created by Jack on 2017/7/29.
 */
@RestController
@RequestMapping(value = "/api/warehouse/")
public class ApiWarehouseDetailController {

    @Autowired
    private WarehouseDetailService warehouseDetailService;

    /**
     * 单据下载
     * @param request
     * @param warehouseDetail
     * @return
     * @throws IOException
     */
    @PostMapping(value = "out/detail" )
    public Object list( HttpServletRequest request  , @RequestBody WarehouseDetail warehouseDetail){

        if (ValidateToken.isToken(request)) {
            List<WarehouseDetail> rdcOutHeaderList = warehouseDetailService.findWarehouseDetail(warehouseDetail.getCode());
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), rdcOutHeaderList, HttpStatus.OK), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }



}
