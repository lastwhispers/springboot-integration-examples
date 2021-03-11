package cn.cunchang.service;

import cn.cunchang.mapper.UserMapper;
import cn.cunchang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 根据用户 id 查询单个用户
     *
     * @param userId 用户 id
     * @return 用户
     */
    public User getByUserId(Long userId) {
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
    public void updateById(User user) {
        userMapper.updateById(user);
    }


    /**
     * 根据用户 id 删除用户
     *
     * @param userId 用户 id
     */
    public void deleteById(Long userId) {
        userMapper.deleteById(userId);
    }
}
