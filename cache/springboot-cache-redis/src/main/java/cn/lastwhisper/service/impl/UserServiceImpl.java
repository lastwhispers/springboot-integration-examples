package cn.lastwhisper.service.impl;

import cn.lastwhisper.mapper.UserMapper;
import cn.lastwhisper.model.User;
import cn.lastwhisper.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理员表 Service实现
 *
 * @author lastwhisper
 * @date 2020-06-01 19:35:07
 */
@CacheConfig(cacheNames = "user")
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private UserMapper userMapper;

    /*
     * Spring Cache 原理
     *  1、自动配置类 CacheAutoConfiguration，导入缓存的配置类 CacheConfigurationImportSelector
     *  2、默认缓存配置 org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *  3、RedisCacheConfiguration 为容器中注册 CacheManager（RedisCacheManager）
     *  4、通过 cacheNames 与 Cache（RedisCache）关联
     */

    /**
     * 一、@Cacheable 现象
     *  先检查 key 有没有对应的数据，如果有直接返回，没有则执行目标方法，并将结果放入缓存。
     * 二、运行流程
     *  1、目标方法执行前，从cacheManager中根据cacheNames获取对应的Cache（第一次使用时初始化）
     *      RedisCacheManager.getCache
     *  2、在Cache中使用key查询，key可以通过注解中的key属性指定，也可以根据KeyGenerator生成
     *      RedisCache.lookup
     *  3、在Cache中没有查到，就执行目标方法，并将结果放入缓存
     *      RedisCache.put
     *  4、对于null值，allowNullValues为true，使用NullValue存储
     * 三、@Cacheable 属性
     *      cacheNames/value：指定缓存组件的名字;将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存；
     *
     *      key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值  1:方法的返回值
     *              key可以使用编写SpEL； #id;参数id的值   #a0  #p0  #root.args[0]
     *
     *      keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     *              key/keyGenerator：二选一使用;
     *
     *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *
     *      condition：指定符合条件的情况下才缓存；
     *              ,condition = "#id>0"
     *          condition = "#a0>1"：第一个参数的值》1的时候才进行缓存
     *
     *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *              unless = "#result == null"
     *              unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
     *      sync：是否使用异步模式
     *
     */
    @Cacheable(/*cacheNames = {"user"},*/ key = "#user.userId", unless = "#result == null")
    @Override
    public User findUser(User user) {
        logger.info("执行 SQL 查询 userId：{} 对应的 User", user.getUserId());
        return this.baseMapper.selectById(user.getUserId());
    }

    /**
     * 一、@CachePut 现象
     *  先执行目标方法，再将目标方法返回值拿到，更新kv缓存
     * 二、运行流程
     *  1、目标方法执行前，从cacheManager中根据cacheNames获取对应的Cache（第一次获取时初始化）
     *      RedisCacheManager.getCache
     *  2、在Cache中使用key查询，key可以通过注解中的key属性指定，也可以根据KeyGenerator生成
     *      RedisCache.put
     *  3、在Cache中没有查到，就执行目标方法，并将结果放入缓存
     *
     */
    @CachePut(/*cacheNames = "user",*/ key = "#user.userId")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateUser(User user) {
        logger.info("执行 SQL 更新 userId：{} 对应的 User", user.getUserId());
        this.saveOrUpdate(user);
        return user;
    }

    /**
     * @CacheEvict 缓存清空策略
     *  key：指定要清除的数据
     *  allEntries = true：指定清除这个缓存中所有的数据
     *  beforeInvocation = false：缓存的清除是否在方法之前执行
     *      默认代表缓存清除操作是在方法执行之后执行;如果出现异常缓存就不会清除
     *  beforeInvocation = true：
     *      代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
     */
    @CacheEvict(/*cacheNames = "user",*/ beforeInvocation = true, key = "#user.userId")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(User user) {
        logger.info("执行 SQL 删除 userId：{} 对应的 User", user.getUserId());
        this.removeById(user.getUserId());
    }

    /**
     * @Caching 定义复杂的缓存规则
     *  Cache中会有三类k，分别是email、userId、phone，v是User
     *    查看RedisCache的lookup和put方法
     *  因为有@CachePut，所有就算加了@Cacheable，每次都会执行该方法
     *  通过@CacheConfig抽取，cacheNames="user"
     *
     */
    @Caching(
            cacheable = {
                    @Cacheable(/*cacheNames = "user",*/key = "#user.email", unless = "#result == null") //用 email 做缓存 k
            },
            put = {
                    @CachePut(/*cacheNames = "user",*/key = "#result.userId", unless = "#result == null"), //用 userId 做缓存 k
                    @CachePut(/*cacheNames = "user"",*/ key = "#result.phone", unless = "#result == null") //用 phone 做缓存 k
            }
    )
    @Override
    public User findUserByEmail(User user) {
        logger.info("执行 SQL 查询 email：{} 对应的 User", user.getEmail());
        user = userMapper.selectByEmail(user.getEmail());
        return user;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(User user) {
        this.save(user);
    }

}
