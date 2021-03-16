package cn.cunchang.config;


import cn.cunchang.util.FileUploadUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author cunchang
 * @date 2021/3/12
 *  springboot内置tomcat配置虚拟路径
 * linux： /usr/upload  /pictures
 * window:  d:/upload  /pictures
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pictures/**")
                .addResourceLocations(FileUploadUtil.realPath);
    }

}