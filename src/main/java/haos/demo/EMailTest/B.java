package haos.demo.EMailTest;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class B {
    @Resource
    private B b;

    public void print(){
        System.out.println("sayB");
    }
}
