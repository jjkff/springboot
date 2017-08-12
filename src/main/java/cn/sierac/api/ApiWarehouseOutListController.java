
package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.RdcOutHeader;
import cn.sierac.service.RdcOutHeaderService;
import cn.sierac.utils.DateUtils;
import cn.sierac.utils.JsonMapper;
import cn.sierac.utils.ValidateToken;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 出库api
 * Created by Jack on 2017/7/28.
 */
@RestController
@RequestMapping(value = "/api/warehouse/")
public class ApiWarehouseOutListController  {

    @Autowired
    private RdcOutHeaderService rdcOutHeaderService;


    /**
     * 出库
     * @param request
     * @param rdcOutHeader
     * @return
     */
    @PostMapping(value = "/out/list" )
    public Object list( HttpServletRequest request,@RequestBody RdcOutHeader rdcOutHeader)
   {
        if (ValidateToken.isToken(request)) {
            rdcOutHeader.setBillStatus("1");
            List<RdcOutHeader> rdcOutHeaderList = rdcOutHeaderService.findAll(rdcOutHeader);
            for(RdcOutHeader r : rdcOutHeaderList){ //时间处理
                if(!("").equals(r.getUploadTime()) || r.getUploadTime() != null){
                    String d = r.getUploadTime();
                    String dd = DateUtils.cover(d);
                    r.setUploadTime(dd);
                }
                else{
                    return  new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), "上传时间为空", HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
                }
            }
            return new ResponseEntity<>(new Result(HttpStatus.OK.value(), rdcOutHeaderList, HttpStatus.OK), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }

    }

}