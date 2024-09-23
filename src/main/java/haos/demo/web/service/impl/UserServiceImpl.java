package haos.demo.web.service.impl;

import haos.demo.web.entity.User;
import haos.demo.web.dao.UserMapper;
import haos.demo.web.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haos1
 * @since 2023-03-17
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    @Transactional
    public User methodA() {
        User user = new User();
        user.setAge(11);
        user.setName("A");
        user.setEmail("A");
        baseMapper.insert(user);
        this.methodC();
        if (true) {
            throw new RuntimeException("");
        }
        return user;
    }

    @Override
    public User methodB() {
        return null;
    }

    private User methodC() {
        User user = new User();
        user.setAge(12);
        user.setName("C");
        user.setEmail("C");
        baseMapper.insert(user);
        return user;
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.methodAA();
    }

    private void methodAA() {
        try {
            methodBB();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException("A异常");
        }
    }

    private void methodBB() {
        try {
            methodCC();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException("B异常");
        }
    }

    private void methodCC() {
        if (true) {
            throw new RuntimeException("C异常");
        }
    }
}
