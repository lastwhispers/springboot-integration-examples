package cn.lastwhisper.service;

import cn.lastwhisper.model.QueryRequest;
import cn.lastwhisper.model.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 管理员表 Service接口
 *
 * @author lastwhisper
 * @date 2020-06-01 19:35:07
 */
public interface IUserService extends IService<User> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param user user
     * @return IPage<User>
     */
    IPage<User> findUsers(QueryRequest request, User user);

    /**
     * 查询（所有）
     *
     * @param user user
     * @return List<User>
     */
    List<User> findUsers(User user);

    /**
     * 新增
     *
     * @param user user
     */
    void createUser(User user);

    /**
     * 修改
     *
     * @param user user
     */
    void updateUser(User user);

    /**
     * 删除
     *
     * @param user user
     */
    void deleteUser(User user);
}
