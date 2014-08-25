package com.iwebirth.sxfj.jms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class JmsTest {
	ApplicationContext ctx1;
	ApplicationContext ctx2;
	@Before
	public void setUp() throws Exception {
		ctx1 = new ClassPathXmlApplicationContext("classpath:springmvc-jms.xml");
		ctx2 = new ClassPathXmlApplicationContext("classpath:springmvc-jms2.xml");
	}

	@Test
	public void test1() {
		System.out.println("----JUnit test1 start----");
		JmsTemplate jmsTemplate = (JmsTemplate)ctx1.getBean("jmsTemplate");
		Animal ani = new Animal(10,10);
		jmsTemplate.convertAndSend(ani);
		System.out.println("----JUnit test1 end----");
	}
}
