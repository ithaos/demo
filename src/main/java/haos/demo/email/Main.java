package haos.demo.email;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
        ctx.start();
        MailService mailService = ctx.getBean(MailService.class);

        mailService.sendSimpleMail("haoshuai0827@163.com","开发测试","此邮件为系统发送,请勿回复");
        System.out.println("主程序继续往下执行");
        ctx.stop();
    }
}
