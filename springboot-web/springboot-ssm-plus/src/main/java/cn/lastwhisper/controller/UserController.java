package cn.lastwhisper.controller;

import cn.lastwhisper.model.QueryRequest;
import cn.lastwhisper.model.User;
import cn.lastwhisper.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 管理员表 Controller
 *
 * @author lastwhisper
 * @date 2020-06-01 19:35:07
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("list")
    @ResponseBody
    public List<User> listUsers(User user) {
        return this.userService.findUsers(user);
    }

    @GetMapping("/page")
    @ResponseBody
    public IPage<User> pageUsers(QueryRequest request, User user) {
        return this.userService.findUsers(request, user);
    }

    @PostMapping("/add")
    @ResponseBody
    public void addUser(User user) {
        this.userService.createUser(user);
    }

    @GetMapping("/delete")
    @ResponseBody
    public void deleteUser(User user) {
        this.userService.deleteUser(user);
    }

    @PostMapping("/update")
    @ResponseBody
    public void updateUser(User user) {
        this.userService.updateUser(user);
    }

}
