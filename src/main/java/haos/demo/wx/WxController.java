package haos.demo.wx;

import cn.hutool.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@RestController
@RequestMapping("/wx")
public class WxController {
 
    /**
     * 回调域名地址 就是用户点击授权同意后 需要回调后台另一个接口 带给你code参数
     */
    private static String SYM ="https://haos.888.com";
 
    /**
     * 注册的APPID
     */
    private static String APPID ="wxf566cff8f110c3b6";

    /**
     * 注册的secret
     */
    private static String SECRET="581f23124c8cf1c83b349ee8e1a450a9";
 
 
    /**
     * 微信授权登陆
     * ==============这一步其实应该在前端实现也可以。由前端用js调启微信授权，同意后 直接走回调地址了。
     * @param response
     * @throws Exception
     */
    @RequestMapping("/login")
    public void login(HttpServletResponse response) throws Exception {
        //回调地址的url
        String redirect_uri = URLEncoder.encode(SYM + "/wx/callback");
 
        //用户同意授权获取code
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + APPID +
                "&redirect_uri=" + redirect_uri +
                "&response_type=code" +
                "&scope=snsapi_userinfo&state=123#wechat_redirect";
        System.out.println(url);
        response.sendRedirect(url);
    }
 
    /**
     * 回调地址
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/callback")
    public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
        //通过code获取网页授权access_token和openid
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + "APPID" + "&secret="
                + SECRET + "&code=" + code + "&grant_type=authorization_code";
        System.out.println("回调成功~"+request.toString());
//        JSONObject jsonObject = AuthUtil.doGetJson(url);
//        System.out.println(jsonObject);
//        String openid = jsonObject.getString("openid");
//        String access_token = jsonObject.getString("access_token");
//        //获取微信用户信息
//        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid
//                + "&lang=zh_CN";
//        JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
//        System.out.println(userInfo.toString());
 
    }
}