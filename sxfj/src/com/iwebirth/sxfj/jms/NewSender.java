package com.iwebirth.sxfj.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class NewSender {

	public NewSender() {
		// TODO Auto-generated constructor stub
	}
	//@Autowired
	//private static JmsTemplate jsmTemplate;
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc-jms.xml");
		JmsTemplate jmsTemplate = (JmsTemplate)ctx.getBean("jmsTemplate");
		Destination des = (Destination)ctx.getBean("queue");
		jmsTemplate.setDefaultDestination(des);
//		jsmTemplate.send(new MessageCreator() {		
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				// TODO Auto-generated method stub
//				return session.createTextMessage("hello,jms");
//			}
//		});
		Animal ani = new Animal(10, 20);
		jmsTemplate.convertAndSend(ani);
	}
}
