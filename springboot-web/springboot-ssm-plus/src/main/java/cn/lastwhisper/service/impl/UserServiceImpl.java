package cn.lastwhisper.service.impl;

import cn.lastwhisper.mapper.UserMapper;
import cn.lastwhisper.model.QueryRequest;
import cn.lastwhisper.model.User;
import cn.lastwhisper.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 管理员表 Service实现
 *
 * @author lastwhisper
 * @date 2020-06-01 19:35:07
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> findUsers(QueryRequest request, User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<User> page = new Page<>(request.getCurrent(), request.getSize());
        return this.page(page, wrapper);
    }

    @Override
    public List<User> findUsers(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        wrapper.eq(User::getUserId, user.getUserId());
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        this.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        wrapper.eq(User::getUserId, user.getUserId());
        this.remove(wrapper);
    }
}
