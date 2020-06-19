package cn.lastwhisper.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Cache
 * @author lastwhisper
 * @date 2020/6/1
 */
@Configuration
public class CacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            /**
             * @param method 目标方法
             * @param params 目标方法参数
             */
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return UUID.randomUUID().toString();
            }
        };
    }

}
