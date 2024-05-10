package haos.demo.web.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class DemoService {

    private static List<String> works = Arrays.asList("码农", "学生", "社区人员", "被隔离者", "防护人员", "教师");

    public JSONObject handle1(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException("name is not allow empty");
        }
        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("work", works.get((int) (Math.random() * 5)));
        object.put("date", LocalDateTime.now());
        return object;
    }

}
