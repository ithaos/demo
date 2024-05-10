package haos.demo.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("haos.demo.email")
public class EmailConfig {

    private final String PASSWORD = "nwuvgnproolbcaca";

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setUsername("504339507@qq.com");
        javaMailSender.setPassword(PASSWORD);
        javaMailSender.setDefaultEncoding("UTF-8");
        return javaMailSender;
    }
}
