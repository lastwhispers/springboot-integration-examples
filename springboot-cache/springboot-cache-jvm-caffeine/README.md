Spring Boot 整合 Cache Jvm Caffeine
                       
# 简介

Caffeine Cache支持缓存过期时间、淘汰策略

一、引入SpringBoot Cache、Caffeine Cache
二、配置CaffeineCacheManager

# 测试

一、先find查询，走数据库，存入缓存   
二、再update，更新缓存，find查询到update的数据  
三、再delete，find查询null，不存缓存，每次走数据库。  

一、二、三流程完整测试了缓存，最后有个缓存穿透问题  

## @Cacheable

find方法
- 缓存中存在，直接返回
- 缓存中不存在，查询数据库
    - 查询数据库不存在的id，不加入缓存
    - 查询数据库存在的id，加入缓存

## @CachePut

update方法
- 先更新数据库，再更新缓存

## @CacheEvict

delete方法
- 先清空缓存，再执行目标方法

## @Caching

findUserByEmail方法
复杂缓存

## @CacheConfig

类级别通用缓存配置

# 参考

https://blog.csdn.net/f641385712/article/details/94982916
https://mp.weixin.qq.com/s/xWS_P52ivnLhXHiqVmJITA
https://www.jianshu.com/p/c72fb0c787fc



