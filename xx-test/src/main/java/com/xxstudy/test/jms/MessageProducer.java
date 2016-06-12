package com.xxstudy.test.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 *  消息生产者
 * Created by admin on 16/05/30.
 */
public class MessageProducer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    private javax.jms.MessageProducer producer;//消息生产者
    private Session session;

    private void init() throws JMSException {

        //1.获取ConnectionFactory连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory(
            USERNAME, PASSWORD, BROKER_URL
        );

        Connection connection = factory.createConnection();

        //2. 启动连接
        connection.start();

        //3. 获取session
        session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

        //4. 获取destination
        Destination destination = session.createQueue("message");

        //5. 生产消息，并且设置为不持久化
        producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
    }

    private void send(HashMap<Serializable,Serializable> requestPara) throws JMSException {
        ObjectMessage message = session.createObjectMessage(requestPara);
        producer.send(message);
        session.commit();
    }

    public static void main(String[] args) throws JMSException {
        MessageProducer messageProducer = new MessageProducer();
        messageProducer.init();
        HashMap<Serializable,Serializable> requestParam = new HashMap<>();
        requestParam.put("朱小厮", "zzh");
        messageProducer.send(requestParam);
    }
}
