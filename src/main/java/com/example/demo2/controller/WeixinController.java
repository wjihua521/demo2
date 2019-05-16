package com.example.demo2.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/weixin")
public class WeixinController {
    private final String TOKEN = "mytest";

    @RequestMapping("/token")
    public void token(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");

        String[] str = { TOKEN, timestamp, nonce };
        Arrays.sort(str); // 字典序排序
        String bigStr = str[0] + str[1] + str[2];
        // SHA1加密，我这里用的是common-codec的jar包，你们也可以用java自带的消息消息摘要来写，只不过要多写几行代码，但结果都一样的
        DigestUtils.sha1Hex(bigStr);
        String digest = DigestUtils.sha1Hex(bigStr);

        // 确认请求来至微信
        if (digest.equals(signature)) {
            response.getWriter().print(echostr);
        }
    }
}
