package com.care.controller;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.care.aop_ex02.CoreClass;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationAOP_01.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		CoreClass tc = ctx.getBean("core", CoreClass.class);
		
		System.out.println("main start!!!!!");
		tc.corePrint();		//CoreClass에 있는 기능이 실행되기 때문에 CommonClass도 같이 실행된다
		//applicationAOP_01.xml이 없으면 특정 기능을 실행하기 위한 코드를 넣어줘야 한다.
		System.out.println("main end!!!!!");
		ctx.close();
	}
}
