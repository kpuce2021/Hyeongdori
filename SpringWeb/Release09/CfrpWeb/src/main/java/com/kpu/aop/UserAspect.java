package com.kpu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kpu.domain.UserVO;

@Aspect
@Component
public class UserAspect {
	
	@Before("execution(* login(..))")
	public void beforeMethod(JoinPoint jp) {
		Signature sig = jp.getSignature();

		Logger logger = LoggerFactory.getLogger(jp.getTarget().getClass());
		logger.info("실행 메서드 명 : "+sig.getName());
		
		Object[] obj = jp.getArgs();
		System.out.println("인수 값 : "+obj[0]);
		logger.info(sig.getName()+"메서드의 인수 값 : "+obj[0]);
	}
	
	
	@AfterReturning(value="execution(* add(..))", returning="vo")
	public void afterReturningMethod(JoinPoint jp, UserVO vo) {
		Signature sig = jp.getSignature();

		Logger logger = LoggerFactory.getLogger(jp.getTarget().getClass());
		logger.info("실행 메서드 명 : "+sig.getName());
		Object[] obj = jp.getArgs();
		logger.info(sig.getName()+"의 인수 값 : "+obj[0]);
		logger.info("가입자 명 : "+vo.getId());
		// vo.toString() 로그찍기, 회원가입시
	}
	
	@Around("execution(* login(..))")
	public UserVO aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		UserVO vo = (UserVO)pjp.proceed();
		Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
		logger.info("로그인 사용자 명 : "+vo.getId());
		return vo;
	}
	
	@AfterThrowing(value="execution(* add(..))", throwing="ex1")
	public void afterThrowingMethod1(JoinPoint jp, Throwable ex1) {
		Logger logger = LoggerFactory.getLogger(jp.getTarget().getClass());
		logger.info("add Method Exception : "+ex1.toString());
	}
	
	@AfterThrowing(value="execution(* login(..))", throwing="ex2")
	public void afterThrowingMethod2(JoinPoint jp, Throwable ex2) {
		Logger logger = LoggerFactory.getLogger(jp.getTarget().getClass());
		logger.info("login Method Exception : "+ex2.toString());
	}
	
}
