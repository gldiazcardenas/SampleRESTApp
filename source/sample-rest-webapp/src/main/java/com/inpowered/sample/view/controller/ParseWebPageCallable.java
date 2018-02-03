package com.inpowered.sample.view.controller;

import java.util.concurrent.Callable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.inpowered.sample.view.bean.ParseWebPageResult;

public class ParseWebPageCallable implements Callable<ParseWebPageResult> {
	
	private String url;
	
	public ParseWebPageCallable(String url) {
		this.url = url;
	}

	@Override
	public ParseWebPageResult call() throws Exception {
		Document doc = Jsoup.connect(url).get();
		
		ParseWebPageResult result = new ParseWebPageResult();
		result.setTitle(doc.title());
		result.setDescription("Fixed Description");
		result.setAuthor("Fixed Author");
		
		return result;
	}

}
