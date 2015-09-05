package com.dvdrental.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ActorAspectPointcut {
	private static Logger logger = Logger.getLogger(ActorAspectPointcut.class);

	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice() {
		logger.trace("Before executing service method");
		
	}

	// Pointcut to execute on all the methods of classes in a package
	@Pointcut("within(com.dvdrental.controller.*)")
	public void allMethodsPointcut() {
	}

}
