package com.iwebirth.sxfj.jms;

import java.io.Serializable;

import javax.jms.Message;

public class MessageListener {
	//普通的POJO
	//作为org.springframework.jms.listener.adapter.MessageListenerAdapter的属性
	
	public MessageListener() {
		// TODO Auto-generated constructor stub
	}
	//如果不为MessageListenerAdapter设置defaultListenerMethod属性，则默认处理的方法为handleMessage
	public void handleMessage(String message){
		System.out.println("采用默认的handlerMessage处理");
		System.out.println("GOT A MSG@receiveMessage:"+message);
	}
	
	public void receiveMessage(int message){
		System.out.println("采用receive处理Integer");
		System.out.println("GOT A MSG@receiveMessage:"+message);
	}
	//MessageListenerAdapter配置好后，当有监听到消息，会自动把消息类型转为相应的String  Map   或  Serializable（Object）
	public void receiveMessage(String message){
		System.out.println("采用receive处理String");
		System.out.println("GOT A MSG@receiveMessage:"+message);
	}
	public void receiveMessage(Serializable message){
		System.out.println("采用receive处理Object");
		Animal a = (Animal)message;
		System.out.println("GOT A MSG@receiveMessage:"+a.toString());
	}
}
