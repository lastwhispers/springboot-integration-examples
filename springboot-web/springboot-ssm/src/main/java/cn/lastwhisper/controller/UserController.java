package cn.lastwhisper.controller;

import cn.lastwhisper.model.User;
import cn.lastwhisper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户控制层
 * @author lastwhisper
 * @date 2020/5/31
 */
// @RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> getUsers() {
        List<User> users = userService.getAll();
        return users;
    }

    @RequestMapping("/detail")
    public User getUser(Long id) {
        User user = userService.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void add(User user) {
         userService.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
         userService.update(user);
    }

    @RequestMapping(value = "/delete")
    public void delete(Long id) {
         userService.delete(id);
    }

}
