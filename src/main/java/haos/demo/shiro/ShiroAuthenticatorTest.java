package haos.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class ShiroAuthenticatorTest {
    public static void main(String[] args){
        // 1、创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 2、给安全管理器设置realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        // 3、给全局安全工具类SecurityUtils设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 4、拿到当前的subject
        Subject subject = SecurityUtils.getSubject();
        // 5、创建令牌
        AuthenticationToken token = new UsernamePasswordToken("jacko","123456");
 
        try {
            // 6、用户认证
            //subject.isAuthenticated()判断是否认证成功，成功返回ture否则返回false
            System.out.println("认证状态："+subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证状态："+subject.isAuthenticated());
        } catch (UnknownAccountException e){
            //判断用户名是否错误
            e.printStackTrace();
            System.out.println("认证失败：用户不存在！");
        } catch (IncorrectCredentialsException e){
            //判断密码是否错误
            e.printStackTrace();
            System.out.println("认证失败：密码不正确！");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}