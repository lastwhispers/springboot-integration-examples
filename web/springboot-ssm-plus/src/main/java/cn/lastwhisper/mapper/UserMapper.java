package cn.lastwhisper.mapper;

import cn.lastwhisper.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 用户数据层
 *
 * @author lastwhisper
 * @date 2020/5/31
 */
public interface UserMapper extends BaseMapper<User> {


    User selectByEmail(String email);

}
