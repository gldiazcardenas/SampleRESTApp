package com.inpowered.sample.view.controller;

import java.util.concurrent.Callable;

import com.inpowered.sample.view.bean.AylienWebPageResult;

public class AylienWebPageCallable implements Callable<AylienWebPageResult> {

	@Override
	public AylienWebPageResult call() throws Exception {
		AylienWebPageResult result = new AylienWebPageResult();
		return result;
	}

}
