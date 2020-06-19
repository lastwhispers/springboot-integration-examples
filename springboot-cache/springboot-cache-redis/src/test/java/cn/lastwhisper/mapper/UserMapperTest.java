package cn.lastwhisper.mapper;

import cn.lastwhisper.model.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public void testMapperXml() {
        assertThat(userMapper.selectByEmail("1505754621@qq.com").getUserId()).isEqualTo(4L);
    }

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
        assertThat(userMapper.deleteById(1L)).isEqualTo(1);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(2L);
        user.setEmail("xxx@163.com");
        // 返回更新的行数
        assertThat(userMapper.updateById(user)).isEqualTo(1);
        assertThat(userMapper.selectById(2L).getEmail()).isEqualTo("xxx@163.com");
    }

    @Test
    public void testSelectList() {
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(1, userList.size());
    }

    @Test
    public void testSelectCondition() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(new User());
        // 查询email中包含"q.com"的用户
        queryWrapper.like("email", "qq.com");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> {
            System.out.println(user.getEmail());
        });
    }

    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 5);
        IPage<User> userIPage = this.userMapper.selectPage(page, null);
        Assert.assertEquals(6, userIPage.getTotal());
        Assert.assertEquals(1, userIPage.getCurrent());
        Assert.assertEquals(5, userIPage.getSize());
        userIPage.getRecords().forEach(System.out::println);
    }

}