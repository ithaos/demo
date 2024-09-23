package haos.demo.web.service;

import haos.demo.web.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haos1
 * @since 2023-03-17
 */
public interface UserService extends IService<User> {

    User methodA();

    User methodB();

}
