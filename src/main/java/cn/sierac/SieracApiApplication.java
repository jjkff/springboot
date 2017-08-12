package cn.sierac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
public class SieracApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SieracApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SieracApiApplication.class);
    }


    /**
     * 在此注册过滤器
     * @return
     */
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new ColligateFilter());
//        List<String> urlPatterns = new ArrayList<String>();

//        urlPatterns.add("/api/dealer/out/list");
//        urlPatterns.add("/api/dealer/out/scanCheck");
//        urlPatterns.add("/api/dealer/out/detail");
//        urlPatterns.add("/api/dealer/out/scanStatus");
//        urlPatterns.add("/api/warehouse/out/list");
//        urlPatterns.add("/api/warehouse/out/scanCheck");
//        urlPatterns.add("/api/warehouse/out/detail");
//        urlPatterns.add("/api/warehouse/out/scanStatus");

//        registrationBean.addUrlPatterns("/api/dealer/out/list");
//        registrationBean.addUrlPatterns("/api/dealer/out/scanCheck");
//        registrationBean.addUrlPatterns("/api/dealer/out/detail");
//        registrationBean.addUrlPatterns("/api/dealer/out/scanStatus");

//        registrationBean.setUrlPatterns(urlPatterns);
//        return registrationBean;
//
//    }
}
