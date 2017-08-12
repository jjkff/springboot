package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.WarehouseMove;
import cn.sierac.entity.WarehouseMoveScanCheck;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 仓库调拨出库状态
 * Created by pinkMan on 2017/8/1.
 */
@RestController
@RequestMapping("api/warehouseMove/")
public class ApiWarehouseMoveCheckStatusController {

    @Autowired
    private WarehouseMoveService warehouseMoveService;

    /**
     * 仓库调拨出库状态查询
     * @param request
     * @param warehouseMoveScanCheck
     * @return
     */
    @PostMapping(value = "out/scanStatus")
    public Object list(HttpServletRequest request, @RequestBody WarehouseMoveScanCheck warehouseMoveScanCheck){
        List<WarehouseMove> warehouseList=new ArrayList<WarehouseMove>();
        if(ValidateToken.isToken(request)){
            WarehouseMove warehouseMove=warehouseMoveService.findByCode(warehouseMoveScanCheck.getCode());
            warehouseMove.setCode(warehouseMove.getBillStatus());
            warehouseList.add(warehouseMove);

            for (int i = 0; i < warehouseList.size(); i++) {
                if (  warehouseList.get(i).getUploadTime() != null && !"".equals( warehouseList.get(i).getUploadTime())) {
                    warehouseList.get(i).setUploadTime(DateUtils.cover( warehouseList.get(i).getUploadTime()));
                }
                if ( warehouseList.get(i).getScanBeginTime() != null && !"".equals( warehouseList.get(i).getUploadTime()) ) {
                    warehouseList.get(i).setScanBeginTime(DateUtils.cover( warehouseList.get(i).getScanBeginTime()));
                }
                if (warehouseList.get(i).getSubmitDate() != null && !"".equals( warehouseList.get(i).getUploadTime())) {
                    warehouseList.get(i).setSubmitDate(DateUtils.cover( warehouseList.get(i).getSubmitDate()));
                }
            }

            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), warehouseList, HttpStatus.OK), HttpStatus.OK);
        }
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);

    }
}
