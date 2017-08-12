package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerScanCheck;
import cn.sierac.service.DealerScanCheckServcie;
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
 * 扫描代码接口
 * Created by Jack on 2017/8/1.
 */
@RestController
@RequestMapping(value ="api/dealer")
public class ApiDealerScanCheckController {

  @Autowired
  private DealerScanCheckServcie dealerScanCheckServcie;

    /**
     * 扫描代码接口
     * @param dealerScanCheck
     * @param request
     * @return
     */
  @PostMapping(value = "out/scanCheck")
  public Object list(@RequestBody DealerScanCheck dealerScanCheck , HttpServletRequest request){
      if (ValidateToken.isToken(request)) {
          List<DealerScanCheck> dealerScanChecks = dealerScanCheckServcie.findAll(dealerScanCheck.getCode());
          for (DealerScanCheck data:dealerScanChecks){
              if(data.getPackLevel()==1){
                  data.setQty(1);
              }else if(data.getPackLevel()==2){
                  data.setQty(data.getPcsPerCtn());
              }else if(data.getPackLevel()==3){
                  data.setQty(data.getPcsPerCtn()*data.getCtnPerPlt());
              }
          }
          return new ResponseEntity<>(new Result(HttpStatus.OK.value(), dealerScanChecks, HttpStatus.OK), HttpStatus.OK);
      }
      else{
          return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
      }
  }

}
