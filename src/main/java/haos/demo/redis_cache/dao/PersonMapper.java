package haos.demo.redis_cache.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import haos.demo.redis_cache.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}
