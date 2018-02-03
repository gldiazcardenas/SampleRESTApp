package com.inpowered.sample.business.service.callable;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.inpowered.sample.view.bean.ParseWebPageResult;

public class ParseWebPageCallable implements Callable<ParseWebPageResult> {
	
	private static final Log LOG = LogFactory.getLog(ParseWebPageCallable.class);
	
	private String url;
	
	public ParseWebPageCallable(String url) {
		this.url = url;
	}

	@Override
	public ParseWebPageResult call() {
		ParseWebPageResult result = new ParseWebPageResult();
		
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			result.setTitle(doc.title());
			result.setDescription("Fixed Description");
			result.setAuthor("Fixed Author");
		}
		catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
		
		return result;
	}

}
