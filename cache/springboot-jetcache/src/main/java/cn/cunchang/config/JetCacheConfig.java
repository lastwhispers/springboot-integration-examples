package cn.cunchang.config;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMethodCache(basePackages = "cn.cunchang")
@EnableCreateCacheAnnotation
public class JetCacheConfig {

}