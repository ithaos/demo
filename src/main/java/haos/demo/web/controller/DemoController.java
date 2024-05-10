package haos.demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import haos.demo.web.service.DemoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @RequestMapping("/012")
    public JSONObject demo01(@Param("name") String name) {
        return demoService.handle1(name);
    }

    @RequestMapping("/011")
    public String demo02() throws Exception {

        File file = new File("/Users/haos/Desktop/mine/《Java开发手册》v1.5.0 华山版.pdf");
        byte[] bytesArray = new byte[(int) file.length()];

        FileInputStream fis = new FileInputStream(file);
        fis.read(bytesArray); //read file into bytes[]
        fis.close();
        return JSON.toJSONString(bytesArray);
    }
}
