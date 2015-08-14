package com.jms.basic.realtime;

import com.jms.basic.listener.ExMessageListener;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by danh.ho on 14/08/2015.
 */
public class TestRealTime {
    private ConnectionFactory connectionFactory;
    private Queue queue;


    public void realTimeReading() {
        Connection connection;
        MessageConsumer messageConsumer;
        Session session;
        try {
            InitialContext ic = new InitialContext();
            connectionFactory = (ConnectionFactory) ic.lookup("jms/GlassFishBookConnectionFactory");
            queue = (Queue) ic.lookup("jms/GlassFishBookQueue");

            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageConsumer = session.createConsumer(queue);
            messageConsumer.setMessageListener(new ExMessageListener());
            connection.start();
            int i = 0;
            while (i < 100) {
                System.out.println("-----------------" + i + "---------------------------");
                Thread.sleep(2000);
                i++;
            }
            System.out.println("-----The end Thread------");
            messageConsumer.close();
            session.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TestRealTime().realTimeReading();
    }
}
