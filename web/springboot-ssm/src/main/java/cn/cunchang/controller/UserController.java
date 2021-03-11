package cn.cunchang.controller;

import cn.cunchang.model.User;
import cn.cunchang.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制层
 *
 * @author cunchang
 * @date 2020/5/31
 */
@Api(value = "用户页面接口", description = "")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getById")
    public User getUser(Long id) {
        User user = userService.getByUserId(id);
        return user;
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.insert(user);
    }

    @PostMapping(value = "update")
    public void update(@RequestBody User user) {
        userService.updateById(user);
    }

    @GetMapping(value = "/delete")
    public void delete(Long id) {
        userService.deleteById(id);
    }

}
