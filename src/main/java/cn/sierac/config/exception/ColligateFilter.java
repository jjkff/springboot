package cn.sierac.config.exception;


import cn.sierac.api.ApiDealerListController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jack on 2017/8/10.
 */
@WebFilter( urlPatterns ="/*")
public class ColligateFilter implements Filter {

    //登录api的url
    private static String USER_LOGIN_URL = "/api/login/user";

    //日志
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ColligateFilter.class);

    //响应报文
//    @Autowired //须注解：将它注入本类 否则报空指针异常
//    private FundaErrorController fundaErrorController;
    @Autowired
    private ErrorHandler errorHandler;


    /**
     * 封装，不需要过滤的list列表
     */
//    protected static List<Pattern> patterns = new ArrayList<Pattern>();

    //过滤器初始化：在创建的时候，就会执行这个方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("过滤器初始化！");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;

        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;

        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        //转换
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        //如果是登录APi url
        if(url.equals(USER_LOGIN_URL)){

            //调用登录Api进行登录
            try{
                filterChain.doFilter(httpRequest, httpResponse);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        /**
         * 获取登录后的session , 来判断是否登录
         */

        //已登录
        if(request.getSession().getAttribute("userSession")!=null){

            logger.info("成功登录了！");

            filterChain.doFilter(httpRequest, httpResponse); //直接调接口返回数据

        }

        //未登录
        else{
                //响应报文
//                fundaErrorController.doHandleError();
            errorHandler.handleControllerException(request,new Exception());

            }



        //已登录
//        if (ValidateToken.isToken(request)) {
//            //除了微信之外的其他api,需要登录 ,       调接口
//            if(!url.contains("queryFake")){
//                filterChain.doFilter(httpRequest, httpResponse); //直接调接口
//
//            }
//
//        }
        //未登录
//        else{
//
//            //返回未登录:提示未登录
//
//
//        }




//        if(url.contains("")){
//
//        }
//
//        if (url.startsWith("/") && url.length() > 1) {
//            url = url.substring(1);
//        }
//
//        if (isInclude(url)){
//            filterChain.doFilter(httpRequest, httpResponse);
//            return;
//        } else {
//            HttpSession session = httpRequest.getSession();
//            if (session.getAttribute("") != null){
//                // session存在
//                filterChain.doFilter(httpRequest, httpResponse);
//                return;
//            } else {
//                // session不存在 准备跳转失败
//                /* RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//                    dispatcher.forward(request, response);*/
////                filterChain.doFilter(httpRequest, httpResponse);
//                return;
//            }
//        }
    }

    //过滤器销毁
    @Override
    public void destroy() {

        logger.info("过滤器销毁！");

    }

    /**
     * 是否需要过滤
     * @param url
     * @return
     */
//    private boolean isInclude(String url) {
//        for (Pattern pattern : patterns) {
//            Matcher matcher = pattern.matcher(url);
//            if (matcher.matches()) {
//                return true;
//            }
//        }
//        return false;
//    }


}
