package cn.lastwhisper.service;

import cn.lastwhisper.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 管理员表 Service接口
 *
 * @author lastwhisper
 * @date 2020-06-01 19:35:07
 */
public interface IUserService extends IService<User> {

    /**
     * 查询
     *
     * @param user user
     * @return User
     */
    User findUser(User user);

    /**
     * 修改
     *
     * @param user user
     * @return User 更新后的用户
     */
    User updateUser(User user);

    /**
     * 删除
     *
     * @param user user
     */
    void deleteUser(User user);


    /**
     * 查询
     *
     * @param user user
     * @return User
     */
    User findUserByEmail(User user);


    /**
     * 新增
     *
     * @param user user
     */
    void createUser(User user);
}
