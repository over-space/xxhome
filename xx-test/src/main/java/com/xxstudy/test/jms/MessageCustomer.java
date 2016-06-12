package com.xxstudy.test.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 16/05/30.
 */
public class MessageCustomer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;


    private void init(MessageCustomer customer) throws Exception {
        //1.获取ConnectionFactory连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(
                USERNAME, PASSWORD, BROKER_URL
        );

        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("message");

        //消息消费（接收）者
        MessageConsumer consumer = session.createConsumer(destination);



        while(true) {
            ObjectMessage message = (ObjectMessage) consumer.receive(1000);
            if(null != message) {
                HashMap<Serializable,Serializable> requestParam = (HashMap<Serializable,Serializable>) message.getObject();
                customer.requestHandler(requestParam);
            } else {
                break;
            }
        }
    }

    private void requestHandler(HashMap<Serializable,Serializable> requestParam) throws Exception
    {
        System.out.println("requestHandler....."+requestParam.toString());
        for(Map.Entry<Serializable, Serializable> entry : requestParam.entrySet())
        {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        com.xxstudy.test.jms.MessageCustomer consumer = new com.xxstudy.test.jms.MessageCustomer();
        consumer.init(consumer);
    }

}
