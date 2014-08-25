package com.iwebirth.sxfj.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.activemq.command.ActiveMQTextMessage;

public class MessageReceiver implements MessageListener {
/**
 * @see javax.jms.MessageListener
 * */
	public MessageReceiver() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		 System.out.println("[receive message]");
		// ObjectMessage om = (ObjectMessage)message;
		 ActiveMQTextMessage msg = (ActiveMQTextMessage)message;
		 System.out.println(msg.getDestination());
		 try {
			System.out.println(msg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
