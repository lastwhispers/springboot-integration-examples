package cn.cunchang.service;

import cn.cunchang.mapper.UserMapper;
import cn.cunchang.model.User;
import com.alicp.jetcache.anno.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 用户业务层
 *
 * @author cunchang
 * @date 2020/5/31
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 一、@Cached
     * （1）原生支持了TTL（超时时间）
     * （2）cacheType有LOCAL/REMOTE/BOTH三种选择，分别代表本地内存/远程Cache Server（例如Redis）/两级缓存
     * 合理使用LOCAL或BOTH，可以降低Cache Server的压力以及提升服务的响应时间
     * 二、@CacheRefresh
     * （1）key在首次访问后初始化，在stopRefreshAfterLastAccess时间内未被访问，会被刷新任务自动移除
     * （2）刷新行为是全局唯一的，集群环境下多个机器只会有一个会执行刷新任务
     */
    @Cached(name = "userCache-", key = "#userId", cacheType = CacheType.REMOTE, localLimit = 2, expire = 3600, timeUnit = TimeUnit.SECONDS)
    @CacheRefresh(refresh = 1800, stopRefreshAfterLastAccess = 3600, timeUnit = TimeUnit.SECONDS)
    public User getByUserId(Long userId) {
        return userMapper.selectById(userId);
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    @CacheInvalidate(name = "userCache-", key = "#userId")
//    @CacheUpdate(name = "userCache-", key = "#user.userId", value = "#user")
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @CacheInvalidate(name = "userCache-", key = "#userId")
    public void deleteById(Long userId) {
        userMapper.deleteById(userId);
    }
}
