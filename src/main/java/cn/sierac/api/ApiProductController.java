package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.dao.ProductDao;
import cn.sierac.entity.Product;
import cn.sierac.utils.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 产品下载：
 * Created by Jack on 2017/8/8.
 */
@RestController
@RequestMapping("api/product/")
public class ApiProductController {

    @Autowired
    private ProductDao productDao;

    /**
     * 产品下载
     * @param request
     * @return
     */
    @PostMapping(value = "list")
    public Object list(HttpServletRequest request,@RequestBody Product product){

        if(ValidateToken.isToken(request)){
             List<Product> products =  productDao.findAll(product);
             return new ResponseEntity<>(new Result(HttpStatus.OK.value(),products,HttpStatus.OK),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(),null,HttpStatus.FORBIDDEN),HttpStatus.FAILED_DEPENDENCY);
    }

}
