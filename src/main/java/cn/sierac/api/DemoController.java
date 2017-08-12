package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhming on 2017/7/19.
 */
@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public Object demo() throws Exception {
        return new ResponseEntity<>(new Result(HttpStatus.OK.value(), demoService.demo(), HttpStatus.OK), HttpStatus.OK);
    }
//    @PostMapping
}
