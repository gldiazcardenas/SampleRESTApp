package com.inpowered.sample.view.converter;

import org.springframework.core.convert.converter.Converter;

import com.inpowered.sample.domain.model.WebPage;
import com.inpowered.sample.view.bean.WebPageBean;

public class WebPageToWebPageBeanConverter implements Converter<WebPage, WebPageBean> {

	@Override
	public WebPageBean convert(WebPage source) {
		WebPageBean bean = new WebPageBean();
		bean.setTitle(source.getTitle());
		bean.setDescription(source.getDescription());
		bean.setAuthor(source.getAuthor());
		bean.setPolarity(source.getPolarity());
		bean.setPolarityConfidence(source.getPolarityConfidence());
		bean.setSubjectivity(source.getSubjectivity());
		bean.setSubjectivityConfidence(source.getSubjectivityConfidence());
		return bean;
	}

}
