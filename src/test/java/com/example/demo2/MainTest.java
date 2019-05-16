package com.example.demo2;

import com.example.demo2.processor.CustomerMappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        CustomerMappingJackson2HttpMessageConverter converter = new CustomerMappingJackson2HttpMessageConverter();

        List<MediaType> list = converter.getSupportedMediaTypes();

        final Map<String,NameCode> map = new ConcurrentHashMap<>();
        NameCode nc = new NameCode();
        map.put("1",nc);
        map.put("2",new NameCode());
        map.put("3",new NameCode());

        nc = null;
        System.out.println(Integer.valueOf("1.6"));
        /*for(int i=200;i<800;i++){
            final int ti = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.remove(""+ti);
                    System.out.println("----remove--"+ti);
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();

                for(Map.Entry entry : map.entrySet()){
                    sb.append(entry.getKey()).append(":").append(entry.getValue()).append("\r\n");
                };
                File file = new File("C:\\myfiles\\usr\\temp\\context.txt");
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(sb.toString());
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
        //System.out.println(Integer.valueOf("1.6"));
    }

    static int f(int n){
        if(n==0 ||n==1){
            return 1;
        }
        return f(n-1)+f(n-2);
    }
}
