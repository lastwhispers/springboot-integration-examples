package cn.cunchang.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @备注 springboot内置tomcat配置虚拟路径
 * linux： /usr/upload  /pictures
 * window:  d:/upload  /pictures
 **/

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name").toLowerCase();
        String pathPatterns = "/pictures/**";
        String pathAbsolute;
        switch (os) {
            case "windows":
                pathAbsolute = "file:D:/upload/";
                break;
            default:
                pathAbsolute = "file:/Users/cunchang/upload/";
        }
        registry.addResourceHandler(pathPatterns).addResourceLocations(pathAbsolute);

    }

}