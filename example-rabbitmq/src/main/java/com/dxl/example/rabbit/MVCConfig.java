package com.dxl.example.rabbit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;

/**
 * @Program MVCConfig
 * @Description
 * @Author duxl
 * @Create 2019/1/14 11:32
 */
@Configuration
public class MVCConfig {

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
		MappingJackson2HttpMessageConverter converter =  new MappingJackson2HttpMessageConverter();
		ArrayList<MediaType> list = new ArrayList<>();
		list.add(MediaType.APPLICATION_JSON_UTF8);
		converter.setSupportedMediaTypes(list);
		return converter;
	}


}
