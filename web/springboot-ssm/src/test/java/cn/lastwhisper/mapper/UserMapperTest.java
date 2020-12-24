package cn.lastwhisper.mapper;

import cn.lastwhisper.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setAccount("admin");
        user.setPassword("123456");
        user.setEmail("lastwhisper@yeah.net");
        user.setPhone("15037584938");
        // 返回更新的行数
        assertThat(userMapper.insert(user)).isEqualTo(1);
        // 成功直接拿会写的 ID
        assertThat(user.getUserId()).isNotNull();
    }

    @Test
    public void deleteById() {
        assertThat(userMapper.deleteById(8L)).isEqualTo(1);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(7L);
        user.setEmail("xxx@163.com");
        // 返回更新的行数
        assertThat(userMapper.updateById(user)).isEqualTo(1);
        assertThat(userMapper.selectById(7L).getEmail()).isEqualTo("xxx@163.com");
    }

    @Test
    public void testSelectList() {
        List<User> userList = userMapper.selectList();
        Assert.assertEquals(7, userList.size());
    }


}