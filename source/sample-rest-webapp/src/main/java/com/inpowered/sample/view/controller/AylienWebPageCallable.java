package com.inpowered.sample.view.controller;

import java.util.concurrent.Callable;

import com.inpowered.sample.view.bean.AylienWebPageResult;

public class AylienWebPageCallable implements Callable<AylienWebPageResult> {
	
	//@Autowired
	//protected RestTemplate restTemplate;
	
	//private String aylienWSURL;

	@Override
	public AylienWebPageResult call() throws Exception {
		//ResponseObj response = restTemplate.getForObject(aylienWSURL, ResponseObj.class);
		AylienWebPageResult result = new AylienWebPageResult();
		result.setPolarity("Polarity 123");
		result.setSubjectivity("Subjectivity Text");
		result.setPolarityConfidence(0.555555);
		result.setSubjectivityConfidence(0.9999);
		return result;
	}

}
