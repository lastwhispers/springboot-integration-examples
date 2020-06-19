package cn.lastwhisper.controller;

import cn.lastwhisper.model.User;
import cn.lastwhisper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制层
 *
 *  GET（SELECT）：从服务器取出资源（一项或多项）。幂等
 *  POST（CREATE）：在服务器新建一个资源。 非幂等
 *  PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。幂等
 *  PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。幂等
 *  DELETE（DELETE）：从服务器删除资源。非幂等
 *
 * @author lastwhisper
 * @date 2020/5/31
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * SELECT 查询操作，返回一个JSON数组
     * 具有幂等性
     *
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        List<User> users = userService.getAll();
        return users;
    }

    /**
     * SELECT 查询操作，返回一个新建的JSON对象
     * 具有幂等性
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("id") Long id) {
        User user = userService.getOne(id);
        return user;
    }

    /**
     * 新增一个用户对象
     * 非幂等
     *
     */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody User user) {
         userService.insert(user);
    }

    /**
     * 编辑一个用户对象
     * 幂等性
     */
    @PutMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody User user) {
         userService.update(user);
    }

    /**
     * 删除一个用户对象
     * 幂等性
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
         userService.delete(id);
    }

}
