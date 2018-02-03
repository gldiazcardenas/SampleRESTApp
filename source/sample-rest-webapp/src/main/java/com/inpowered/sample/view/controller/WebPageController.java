package com.inpowered.sample.view.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inpowered.sample.business.service.WebPageService;
import com.inpowered.sample.domain.model.WebPage;
import com.inpowered.sample.view.bean.AylienWebPageResult;
import com.inpowered.sample.view.bean.ParseWebPageResult;
import com.inpowered.sample.view.bean.WebPageCollectBean;
import com.inpowered.sample.view.bean.WebPageBean;

@RestController
public class WebPageController {
	
	@Autowired
	private WebPageService service;
	
	@Autowired
	private ExecutorService executor;
	
	@Autowired
	@Qualifier("myConverterService")
	private ConversionService converterService;
	
	@PostMapping(path = "/collect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public WebPageBean collect (@RequestBody WebPageCollectBean collectBean) {
		ParseWebPageCallable parserCallable = new ParseWebPageCallable(collectBean.getUrl());
		AylienWebPageCallable aylienCallable = new AylienWebPageCallable();
		
		Future<ParseWebPageResult> parseFuture = executor.submit(parserCallable);
		Future<AylienWebPageResult> aylieanFuture = executor.submit(aylienCallable);
		
		WebPageBean result = null;
		
		try {
			ParseWebPageResult parseResult = parseFuture.get();
			AylienWebPageResult aylienResult = aylieanFuture.get();
			
			WebPage webPage = new WebPage();
			webPage.setUrl(collectBean.getUrl());
			webPage.setTitle(parseResult.getTitle());
			webPage.setPolarity(aylienResult.getPolarity());
			
			service.save(webPage);
			
			result = converterService.convert(webPage, WebPageBean.class);
		}
		catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@GetMapping(path = "/query", produces = { MediaType.APPLICATION_JSON_VALUE })
	public WebPageBean query(@RequestParam(required = true, name = "url") final String url) {
		WebPage webPage = service.findByUrl(url);
		return converterService.convert(webPage, WebPageBean.class);
	}

}
