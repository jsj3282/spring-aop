package com.care.aop_ex02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//공통 기능
@Aspect
public class CommonClass {
	@Around("within(com.care.aop_ex02.*)")  //이 패키지 하위에 있는 모든 메소드
	public void commonAop(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("=== 공통 기능 시작 ===");
			joinpoint.proceed();	//잠시 멈추고 coreclass에 있는 기능 실행
			System.out.println("=== 공통 기능 종료 ===");
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Before("execution(* com.care.aop_ex02.CoreClass.test())") //CoreClass의 test() 메소드가 실행되기 전에 실행시켜주세요
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("beforeAdvice() 핵심 기능 전에 실행");
	}
}