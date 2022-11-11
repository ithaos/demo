package haos.demo.controller;

import com.alibaba.fastjson.JSONObject;
import haos.demo.controller.service.DemoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @RequestMapping("/012")
    public JSONObject demo01(@Param("name") String name) {
        return demoService.handle1(name);
    }
}
