package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.RdcOutHeader;
import cn.sierac.entity.WarehouseOutScanCheck;
import cn.sierac.service.WarehouseOutScanCheckService;
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
 *扫描代码接口
 * Created by Jack on 2017/7/29.
 */
@RestController
@RequestMapping(value = "/api/warehouse/")
public class ApiWarehouseOutScanCheckController {

    @Autowired
    private WarehouseOutScanCheckService warehouseOutScanCheckService;

    /**
     * 扫描代码
     * @param warehouseOutScanCheck
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping(value = "out/scanCheck" )
    public Object list(@RequestBody WarehouseOutScanCheck warehouseOutScanCheck , HttpServletRequest request ) {

        if (ValidateToken.isToken(request)) {
            List<WarehouseOutScanCheck> warehouseOutScanChecks = warehouseOutScanCheckService.findAll(warehouseOutScanCheck.getCode());
            for (WarehouseOutScanCheck data:warehouseOutScanChecks){
                if(data.getPackLevel()==1){
                    data.setQty(1);
                }else if(data.getPackLevel()==2){
                    data.setQty(data.getPcsPerCtn());
                }else if(data.getPackLevel()==3){
                    data.setQty(data.getPcsPerCtn()*data.getCtnPerPlt());
                }
            }
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), warehouseOutScanChecks, HttpStatus.OK), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }
}
