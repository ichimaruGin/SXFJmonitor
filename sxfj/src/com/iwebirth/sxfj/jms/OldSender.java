package com.iwebirth.sxfj.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OldSender {

	public OldSender() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc-jms.xml");
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection conn = null;
		Session session = null;
		try {
			conn = cf.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination des = new ActiveMQQueue("sxfj.queue");
			//Destination des = new ActiveMQTopic("sxfj.topic");
			MessageProducer producer = session.createProducer(des);
			TextMessage msg = session.createTextMessage();
			msg.setText("Hello,JMS");
			producer.send(msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{		
			try {
				if(session!=null)
					session.close();
				if(conn!=null)
					conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
