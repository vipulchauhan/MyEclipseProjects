package com.dvdrental.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ActorAspectJoinPoint {

	private static Logger logger = Logger.getLogger(ActorAspectJoinPoint.class);

	@Before("within(com.dvdrental.controller.*)")
	public void loggingAdvice(JoinPoint joinPoint) {
		logger.trace("Before running loggingAdvice on method="
				+ joinPoint.toString());

		logger.trace("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

	}


}
