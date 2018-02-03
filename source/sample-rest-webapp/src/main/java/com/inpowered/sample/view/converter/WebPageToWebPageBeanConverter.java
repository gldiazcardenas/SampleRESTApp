package com.inpowered.sample.view.converter;

import org.springframework.core.convert.converter.Converter;

import com.inpowered.sample.domain.model.WebPage;
import com.inpowered.sample.view.bean.WebPageBean;

public class WebPageToWebPageBeanConverter implements Converter<WebPage, WebPageBean> {

	@Override
	public WebPageBean convert(WebPage source) {
		// TODO Auto-generated method stub
		return null;
	}

}
