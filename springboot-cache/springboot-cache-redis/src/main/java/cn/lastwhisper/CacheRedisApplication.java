package cn.lastwhisper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * 一、JSR 107: JCACHE - Java Temporary Caching API
 *  Java Caching定义了5个核心接口，分别是CachingProvider, CacheManager, Cache, Entry 和 Expiry。
 *      application-》多个CachingProvider——》多个CacheManager-》多个Cache(Map)
 *  （1）CachingProvider定义了创建、配置、获取、管理和控制多个CacheManager。一个应用可以在运行期访问多个CachingProvider。
 *  （2）CacheManager定义了创建、配置、获取、管理和控制多个唯一命名的Cache，这些Cache存在于CacheManager的上下文中。一个CacheManager仅被一个CachingProvider所拥有。
 *  （3）Cache是一个类似Map的数据结构并临时存储以Key为索引的值。一个Cache仅被一个CacheManager所拥有。
 *  （4）Entry是一个存储在Cache中的key-value对。
 *  （5）Expiry 每一个存储在Cache中的条目有一个定义的有效期。一旦超过这个时间，条目为过期的状态。一旦过期，条目将不可访问、更新和删除。缓存有效期可以通过ExpiryPolicy设置。
 * 二、Spring Cache
 *  Spring从3.1开始定义了org.springframework.cache.Cache和org.springframework.cache.CacheManager接口来统一不同的缓存技术；
 *  Cache接口定义缓存的组件规范，包含缓存的各种操作集合，提供了各种xxxCache的实现；如RedisCache，EhCacheCache， ConcurrentMapCache等；
 *  Spring从4.1开始支持使用JCache（JSR-107）注解
 * 三、使用 Spring Cache
 *  1、开启基于注解的缓存 @EnableCaching
 *  2、标注缓存注解即可 @Cacheable、@CacheEvict、@CachePut
 *  3、CacheManager 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache；将数据保存在	ConcurrentMap<Object, Object>中
 *  4、配置RedisCacheManager，将 CacheManager 实现替换成 RedisCacheManager
 */
@MapperScan("cn.lastwhisper.mapper")
@EnableCaching
@SpringBootApplication
public class CacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheRedisApplication.class, args);
    }

}
