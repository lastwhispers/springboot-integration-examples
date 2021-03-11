package cn.lastwhisper.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author lastwhisper
 * @date 2020/6/2
 */
@Configuration
public class CaffeineConfig extends CachingConfigurerSupport {


    @Bean(name = "fixedCacheManager")
    public CacheManager fixedCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        // 方案一(常用)：定制化缓存Cache
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .initialCapacity(100)
                .maximumSize(10_000));
        return cacheManager;
    }

    /**
     * initialCapacity=[integer]: 初始的缓存空间大小
     * maximumSize=[long]: 缓存的最大条数
     * maximumWeight=[long]: 缓存的最大权重
     * expireAfterAccess=[duration]: 最后一次写入或访问后经过固定时间过期
     * expireAfterWrite=[duration]: 最后一次写入后经过固定时间过期
     * refreshAfterWrite=[duration]: 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存
     */
    @Override
    @Bean(name = "cacheManager")
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        // 方案二：传入一个CaffeineSpec定制缓存，它的好处是可以把配置方便写在配置文件里
        cacheManager.setCaffeineSpec(CaffeineSpec.parse("initialCapacity=1,maximumSize=2,expireAfterWrite=10s,refreshAfterWrite=5s"));
        return cacheManager;
    }

}
