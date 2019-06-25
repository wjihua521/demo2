package com.example.demo2;

import com.example.demo2.processor.CustomerMappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainTest {
    public static void main(String[] args) {
        String str = "上帝就发打算离开附件设计开发四道口附近上空时间分厘卡时间是解放螺丝钉解放可是大家少了几分联赛开局方式司法解释的快捷方式是解放拉萨解放是解放螺丝钉解放数据的疯狂的事的健康k";
        System.out.println("----字符串size：" + str.getBytes().length);
        List list = new ArrayList();
        try{
            for(int i=0;i<4200;i++){
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(255);
                byteBuffer.put(str.getBytes());
                list.add(byteBuffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("----finish");
    }

    static int f(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }
}
