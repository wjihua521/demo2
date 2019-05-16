package com.example.demo2.controller;

import com.example.demo2.dto.TestDto;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.util.HashMap;

@RestController
@RequestMapping("/qrcode")
public class QRcodeController {

    @RequestMapping("/qrcode")
    public void qrCode(HttpServletResponse response,HttpServletRequest request){
        final int width = 300;
        final int height = 300;
        final String format = "png";
        String redirectUri = request.getScheme()+"://"+request.getServerName()+"/login";
        System.out.println("-----redirectUri:"+redirectUri);
        try {
            redirectUri = URLEncoder.encode(redirectUri,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final String content = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxf85f19207dc6dff3&redirect_uri="+redirectUri+"&response_type=code&scope=snsapi_userinfo&state="+System.currentTimeMillis()+"#wechat_redirect" ;
                //request.getScheme()+"//"+request.getServerName()+":"+request.getServerPort()+"/test/login";

        //定义二维码的参数
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);

        //生成二维码
        try{
            //OutputStream stream = new OutputStreamWriter();
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            //Path file = new File("C:\\myfiles\\usr\\temp\\img.png").toPath();
            //MatrixToImageWriter.writeToPath(bitMatrix, format, file);
            //MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
            MatrixToImageWriter.writeToStream(bitMatrix, format,response.getOutputStream());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
