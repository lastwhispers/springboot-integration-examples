package cn.lastwhisper.service;

import cn.lastwhisper.mapper.UserMapper;
import cn.lastwhisper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层
 * @author lastwhisper
 * @date 2020/5/31
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 查询用户列表
     *
     * @return java.util.List<cn.lastwhisper.cache.model.User> 用户列表
     */
    public List<User> getAll() {

        return userMapper.selectList();
    }

    /**
     * 根据用户 id 查询单个用户
     *
     * @param userId 用户 id
     * @return cn.lastwhisper.cache.model.User 用户
     */
    public User getOne(Long userId) {
        return userMapper.selectById(userId);
    }

    /**
     * 保存用户
     *
     * @param user 用户
     */
    public void insert(User user) {
        userMapper.insert(user);
    }

    /**
     * 更新用户
     *
     * @param user 用户
     */
    public void update(User user) {
        userMapper.updateById(user);
    }


    /**
     * 根据用户 id 删除用户
     *
     * @param userId 用户 id
     */
    public void delete(Long userId) {
        userMapper.deleteById(userId);
    }
}
