package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.WarehouseMove;
import cn.sierac.service.WarehouseMoveService;
import cn.sierac.utils.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import cn.sierac.utils.DateUtils;

/**
 * 仓库调拨出库
 * Created by pinkman on 2017/7/29.
 */
@RestController
@RequestMapping("/api/warehouseMove/")
public class ApiWarehouseMoveController {

    @Autowired
    private WarehouseMoveService warehouseMoveService;

    /**
     * @param request
     * @param warehouseMove
     * @return
     */
    @PostMapping(value = "out/list")
    public Object list(HttpServletRequest request, @RequestBody WarehouseMove warehouseMove) {
        if (ValidateToken.isToken(request)) {
            List<WarehouseMove> warehouseMoveList = warehouseMoveService.findAll(warehouseMove);
            for (int i = 0; i < warehouseMoveList.size(); i++) {
                if (  warehouseMoveList.get(i).getUploadTime() != null && !"".equals( warehouseMoveList.get(i).getUploadTime())) {
                    warehouseMoveList.get(i).setUploadTime(DateUtils.cover( warehouseMoveList.get(i).getUploadTime()));
                }
                if ( warehouseMoveList.get(i).getScanBeginTime() != null && !"".equals( warehouseMoveList.get(i).getUploadTime()) ) {
                    warehouseMoveList.get(i).setScanBeginTime(DateUtils.cover( warehouseMoveList.get(i).getScanBeginTime()));
                }
                if ( warehouseMoveList.get(i).getSubmitDate() != null && !"".equals( warehouseMoveList.get(i).getUploadTime())) {
                    warehouseMoveList.get(i).setSubmitDate(DateUtils.cover( warehouseMoveList.get(i).getSubmitDate()));
                }
            }
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), warehouseMoveList, HttpStatus.OK), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }


}
