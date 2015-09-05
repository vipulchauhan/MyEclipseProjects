package com.dvdrental.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class ActorAroundAspect {
	private static Logger logger = Logger.getLogger(ActorAroundAspect.class);

	@Around("execution(* com.dvdrental.services.ActorServiceImpl.listActor())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		logger.trace("Before invoking listActor() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.trace("After invoking listActor() method. Return value="
				+ value);
		return value;
	}

}
