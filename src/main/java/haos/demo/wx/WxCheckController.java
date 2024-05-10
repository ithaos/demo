package haos.demo.wx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/wx"})
public class WxCheckController {
 
    @RequestMapping({"/check"})
    @ResponseBody
    private Boolean returnConfigFile(@RequestParam(name = "signature",required = false) String signature,
                                    @RequestParam(name = "timestamp",required = false) String timestamp,
                                    @RequestParam(name = "nonce",required = false) String nonce,
                                    @RequestParam(name = "echostr",required = false) String echostr) {
        System.out.println("333333~~~~~~~~~`");
        return  WxCheckSignatureUtil.checkSignature(signature, timestamp, nonce);
    }
}