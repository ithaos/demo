package haos.demo.redis_cache;

import haos.demo.redis_cache.model.Person;
import haos.demo.redis_cache.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@Slf4j
public class QueryDataController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private PersonService service;

    @GetMapping("/query/{name}")
    public List<Person> getData(@PathVariable("name") String name) {
        return service.queryList(name);
    }

}
