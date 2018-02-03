package com.inpowered.sample.view.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;

import com.inpowered.sample.business.service.WebPageService;
import com.inpowered.sample.domain.model.WebPage;
import com.inpowered.sample.view.bean.WebPageBean;

@RunWith(MockitoJUnitRunner.class)
public class WebPageControllerTest {
	
	@Mock
	private WebPageService service;
	
	@Mock
	private ConversionService converter;
	
	@InjectMocks
	private WebPageController controller;
	
	@Test
	public void testQueryOK () {
		String url = "http://fake.url";
		
		WebPage page = Mockito.mock(WebPage.class);
		WebPageBean bean = Mockito.mock(WebPageBean.class);
		
		Mockito.when(service.findByUrl(Mockito.anyString())).thenReturn(page);
		Mockito.when(converter.convert(Mockito.eq(page), Mockito.eq(WebPageBean.class))).thenReturn(bean);
		
		WebPageBean result = controller.query(url);
		
		Assert.assertEquals(bean, result);
		Mockito.verify(service).findByUrl(Mockito.anyString());
		Mockito.verify(converter).convert(Mockito.eq(page), Mockito.eq(WebPageBean.class));
	}
	
}
