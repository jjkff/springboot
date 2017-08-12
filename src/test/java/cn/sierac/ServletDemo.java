package cn.sierac;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Jack on 2017/8/3.
 */
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.getAsyncContext();
        servletResponse.setBufferSize(1);

    }

    @Override
    public String getServletInfo() {
        String str = new String();
        return str;
    }

    @Override
    public void destroy() {

    }
}
