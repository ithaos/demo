package haos.demo.web.controller;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import haos.demo.web.dao.UserMapper;
import haos.demo.web.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author haos1
 * @since 2023-03-17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/add")
    public User add(){
        long id = IdWorker.getId();
        User user = new User();
        user.setEmail("eeee@emial");
        user.setAge(11);
        user.setName("wuwuuw");
        userMapper.insert(user);
        return user;
    }
}
