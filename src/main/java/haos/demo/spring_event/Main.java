package haos.demo.spring_event;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
//        ctx.start();
//        EventTest eventTest=ctx.getBean(EventTest.class);
//        eventTest.thing();
//        System.out.println("主程序继续往下执行");
//        ctx.stop();
        AtomicLong num = new AtomicLong(1l);
        new Main().test(num);
        System.out.println(num);
    }
    public void test(AtomicLong num){
        while (num.get()<=5L){
            num.addAndGet(1l);
            System.out.println(num);
        }
    }
}
