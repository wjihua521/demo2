package com.example.demo2.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo2.dto.AccessTokenDto;
import com.example.demo2.dto.UserInfoDto;
import com.example.demo2.processor.CustomerMappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        System.out.println("----success:code:"+request.getParameter("code"));
        System.out.println("----success:state:"+request.getParameter("state"));
        RestTemplate restTemplate = new RestTemplate();
        CustomerMappingJackson2HttpMessageConverter converter = new CustomerMappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(converter);

        String uri = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxf85f19207dc6dff3&secret=8e19ceb66e59731892c9c8ac676ea1f5&code="+request.getParameter("code")+"&grant_type=authorization_code";
        AccessTokenDto accessTokenDto = restTemplate.getForObject(uri,AccessTokenDto.class);
        System.out.println("----1 通过code换取网页授权access_token:"+ JSON.toJSONString(accessTokenDto));

        uri = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessTokenDto.getAccess_token()+"&openid="+accessTokenDto.getOpenid()+"&lang=zh_CN";
        UserInfoDto userInfoDto = restTemplate.getForObject(uri, UserInfoDto.class);
        System.out.println("----2 拉取用户信息:"+ JSON.toJSONString(userInfoDto));
        return  "SUCCESS";
    }
}
