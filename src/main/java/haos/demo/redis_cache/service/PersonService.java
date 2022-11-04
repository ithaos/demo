package haos.demo.redis_cache.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import haos.demo.redis_cache.dao.PersonMapper;
import haos.demo.redis_cache.model.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends ServiceImpl<PersonMapper, Person> {

    @Cacheable(cacheNames = "queryPerson")
    public List<Person> queryList(String name) {
//        if(true){
//            throw new RuntimeException("出错了");
//        }
        List<Person> ret = baseMapper.selectList(
                new QueryWrapper<Person>().eq(StringUtils.isNotBlank(name), "name", name));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
