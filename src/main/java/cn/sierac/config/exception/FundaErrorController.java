package cn.sierac.config.exception;

import cn.sierac.common.result.Result;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 未登录响应报文：
 * Created by Jack on 2017/8/12.
 */
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class FundaErrorController  implements ErrorController{
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping
    @ResponseBody
    public Result doHandleError() {
        return new Result(HttpStatus.FORBIDDEN.value(), "未登录", HttpStatus.FORBIDDEN);
    }

}
