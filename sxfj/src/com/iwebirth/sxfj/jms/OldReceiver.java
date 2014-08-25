package com.iwebirth.sxfj.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

public class OldReceiver {

	public OldReceiver() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection conn = null;
		Session session = null;
		try {
			conn = cf.createConnection();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination des = new ActiveMQTopic("sxfj.queue");
			MessageConsumer consumer = session.createConsumer(des);
			Message msg = consumer.receive();
			ActiveMQObjectMessage msg2= (ActiveMQObjectMessage)msg;
			System.out.println("OLD RECEIVER GOT A MSG:"+msg2.getObject().toString());
			conn.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(session != null)
						session.close();
					if(conn != null)
						conn.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
	}
}
