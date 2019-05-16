package com.example.demo2.processor;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

public class CustomerMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    public CustomerMappingJackson2HttpMessageConverter(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.TEXT_HTML);
        mediaTypes.addAll(getSupportedMediaTypes());
        setSupportedMediaTypes(mediaTypes);
    }
}
