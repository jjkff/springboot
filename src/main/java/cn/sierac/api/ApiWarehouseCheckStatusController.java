package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.RdcOutHeader;
import cn.sierac.entity.WarehouseOutScanCheck;
import cn.sierac.service.RdcOutHeaderService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 出库单据状态接口
 * Created by Jack on 2017/7/29.
 */
@RestController
@RequestMapping("api/warehouse")
public class ApiWarehouseCheckStatusController {


    @Autowired
    private RdcOutHeaderService rdcOutHeaderService;

    /**
     * 出库单据
     * @param request
     * @param warehouseOutScanCheck
     * @return
     * @throws IOException
     */
    @PostMapping(value = "out/scanStatus")
    public Object list(HttpServletRequest request , @RequestBody WarehouseOutScanCheck warehouseOutScanCheck) {
        List<RdcOutHeader> warehouseOutScanChecks = new ArrayList<>();
        if (ValidateToken.isToken(request)) {
            RdcOutHeader rdcOutHeader =  rdcOutHeaderService.findByCode(warehouseOutScanCheck.getCode());
            rdcOutHeader.setCode(rdcOutHeader.getBillStatus());
            warehouseOutScanChecks.add(rdcOutHeader);
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), warehouseOutScanChecks, HttpStatus.OK), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
    }
}
