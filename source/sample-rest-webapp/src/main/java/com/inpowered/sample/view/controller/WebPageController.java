package com.inpowered.sample.view.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inpowered.sample.business.service.WebPageService;
import com.inpowered.sample.business.service.callable.AylienWebPageCallable;
import com.inpowered.sample.business.service.callable.ParseWebPageCallable;
import com.inpowered.sample.domain.model.WebPage;
import com.inpowered.sample.view.bean.AylienWebPageResult;
import com.inpowered.sample.view.bean.ParseWebPageResult;
import com.inpowered.sample.view.bean.WebPageBean;
import com.inpowered.sample.view.bean.WebPageCollectBean;

@RestController
public class WebPageController {
	
	private static final Log LOG = LogFactory.getLog(WebPageController.class);
	
	@Autowired
	private WebPageService service;
	
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	
	@Autowired
	@Qualifier("myConverterService")
	private ConversionService converterService;
	
	@PostMapping(path = "/collect", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public WebPageBean collect (@RequestBody WebPageCollectBean collectBean) {
		WebPageBean result = null;
		
		if (collectBean != null && collectBean.getUrl() != null) {
			ParseWebPageCallable parserCallable = new ParseWebPageCallable(collectBean.getUrl());
			AylienWebPageCallable aylienCallable = new AylienWebPageCallable();
			
			Future<ParseWebPageResult> parseFuture = taskExecutor.submit(parserCallable);
			Future<AylienWebPageResult> aylieanFuture = taskExecutor.submit(aylienCallable);
			
			try {
				ParseWebPageResult parseResult = parseFuture.get();
				AylienWebPageResult aylienResult = aylieanFuture.get();
				
				WebPage webPage = service.findByUrl(collectBean.getUrl());
				if (webPage == null) {
					webPage = new WebPage();
				}
				
				webPage.setUrl(collectBean.getUrl());
				webPage.setTitle(parseResult.getTitle());
				webPage.setAuthor(parseResult.getAuthor());
				webPage.setDescription(parseResult.getDescription());
				webPage.setPolarity(aylienResult.getPolarity());
				webPage.setSubjectivity(aylienResult.getSubjectivity());
				webPage.setPolarityConfidence(aylienResult.getPolarityConfidence());
				webPage.setSubjectivityConfidence(aylienResult.getSubjectivityConfidence());
				
				service.save(webPage);
				
				result = converterService.convert(webPage, WebPageBean.class);
			}
			catch (InterruptedException | ExecutionException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		
		return result;
	}
	
	@GetMapping(path = "/query", produces = { MediaType.APPLICATION_JSON_VALUE })
	public WebPageBean query(@RequestParam(required = true, name = "url") final String url) {
		WebPage webPage = service.findByUrl(url);
		return converterService.convert(webPage, WebPageBean.class);
	}

}
