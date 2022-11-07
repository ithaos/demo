package haos.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/012")
    public String demo01(){
        return "张凯宇是个泡" ;
    }
}
