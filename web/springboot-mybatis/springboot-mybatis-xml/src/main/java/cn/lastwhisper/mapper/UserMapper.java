package cn.lastwhisper.mapper;

import cn.lastwhisper.model.User;

import java.util.List;

/**
 * 用户数据层
 *
 * @author lastwhisper
 * @date 2020/5/31
 */
public interface UserMapper {

    /**
     * 查询用户列表
     *
     * @return java.util.List<cn.lastwhisper.cache.model.User> 用户列表
     */
    List<User> selectList();

    /**
     * 根据用户 id 查询单个用户
     *
     * @param userId 用户 id
     * @return cn.lastwhisper.cache.model.User 用户
     */
    User selectById(Long userId);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return int 更新行数量
     */
    int insert(User user);

    /**
     * 更新用户
     *
     * @param user 用户
     * @return int 更新行数量
     */
    int updateById(User user);

    /**
     * 根据用户 id 删除用户
     *
     * @param userId 用户 id
     * @return int 更新行数量
     */
    int deleteById(Long userId);

}
