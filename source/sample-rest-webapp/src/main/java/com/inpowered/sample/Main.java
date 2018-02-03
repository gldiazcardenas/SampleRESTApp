package com.inpowered.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import com.inpowered.sample.view.converter.WebPageToWebPageBeanConverter;

@SpringBootApplication(scanBasePackages = {"com.inpowered.sample"})
public class Main {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	public ConversionService myConverterService() {
		DefaultConversionService service = new DefaultConversionService();
		service.addConverter(new WebPageToWebPageBeanConverter());
		return service;
	}
	
}
