package cn.sierac.api;

import cn.sierac.common.result.Result;
import cn.sierac.entity.DealerLogin;
import cn.sierac.entity.User;
import cn.sierac.entity.WareHouseLogin;
import cn.sierac.service.DealerLoginService;
import cn.sierac.service.UserService;
import cn.sierac.service.WarehouseLoginService;
import cn.sierac.utils.*;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 登录api: 返回登录成功/失败状态 ，并返回各个模块的id
 * Created by Jack on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/api/login")
public class  ApiLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private WarehouseLoginService warehouseLoginService;

    @Autowired
    private DealerLoginService dealerLoginService;

    /**
     * 登录
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value="user" )
    public Object login(HttpServletRequest request , HttpServletResponse response , @RequestBody User user){
        WareHouseLogin wareHouseLogin =  warehouseLoginService.findWareHouseId(user.getLoginName()); //仓库、仓库调度
        String wId = wareHouseLogin.getWarehouseId();

        DealerLogin dealerLogin  =  dealerLoginService.findDealerId(user.getLoginName()); //经销商
        String dId = dealerLogin.getDealerId();

        JsonIds jsonIds = new JsonIds();
        jsonIds.setDealerId(dId);
        jsonIds.setWarehouseId(wId);
        jsonIds.setCode("1");

        User user1 =  userService.getUserByName(user.getLoginName());
        if(user1==null){
            String jsonStr = JsonUtils.objectToJsonStr(jsonIds);
            JSONArray j = JsonUtils.findKeytoValueFromJson(jsonStr);
            return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), j, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
        }
        boolean ss = UserUtils.validatePassword(user.getPassword(), user1.getPassword());// 解密算法，明文密码与加密密码进行比较
        if (ss) {
            String cookieToken = new TokenProcessor().generateToken("Vicky", true);// 加入时间戳的令牌
            CookieUtils.setCookie(response, "cookieToken", cookieToken,43200000);
            HttpSession session = request.getSession();

            session.setAttribute("sessionToken", cookieToken);
            response.setHeader("cookieHeader", cookieToken);

            //登录用户的session
            session.setAttribute("userSession",user.getLoginName());
//            //十五分钟后session失效
//            session.setMaxInactiveInterval(900);

            String jsonStr = JsonUtils.objectToJsonStr(jsonIds);
            JSONArray j = JsonUtils.findKeytoValueFromJson(jsonStr);

            return  new ResponseEntity<>(new Result(HttpStatus.OK.value(), j , HttpStatus.OK), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Result(HttpStatus.FORBIDDEN.value(), null, HttpStatus.FORBIDDEN), HttpStatus.FORBIDDEN);
    }



}
