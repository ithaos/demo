package haos.demo.dao;

import haos.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author haos1
 * @since 2023-03-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
