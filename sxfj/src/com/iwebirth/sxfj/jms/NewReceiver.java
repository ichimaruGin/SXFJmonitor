package com.iwebirth.sxfj.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class NewReceiver {

	public NewReceiver() {
		// TODO Auto-generated constructor stub
	}
	//@Autowired
	//private static JmsTemplate jsmTemplate;
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc-jms.xml");
		JmsTemplate jsmTemplate = (JmsTemplate)ctx.getBean("jmsTemplate");		
		Destination des = (Destination)ctx.getBean("queue");
		jsmTemplate.setDefaultDestination(des);
		TextMessage textMsg = (TextMessage)jsmTemplate.receive();
		try {
			System.out.println("GOA A MSG:"+textMsg.getText()+"\n");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
