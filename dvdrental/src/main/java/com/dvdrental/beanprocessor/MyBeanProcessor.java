package com.dvdrental.beanprocessor;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {
	private Logger logger = Logger.getLogger(getClass());

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		logger.debug("postProcess  After Initialization (" + arg1 + " || " + arg0	+ ")");
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		logger.debug("postProcess Before Initialization (" + arg1 + " || " + arg0
				+ ")");
		return arg0;
	}
}
