package com.jms.basic.asynch;

import com.jms.basic.listener.ExMessageListener;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by CongDanh on 8/13/15.
 */
public class AsynchMessReceiver {
    private static ConnectionFactory connectionFactory;
    private static Queue queue;

    public void getMessages() {
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

            System.out.println("The above line wil l allow the "
                    + "MessageListener implementation to "
                    + "receiving and processing messages from the queue.");

            Thread.sleep(1000);

            System.out.println("Our code does not have to block "
                    + "while messages are received.");

            Thread.sleep(1000);

            System.out.println("It can do other stuff "
                    + "(hopefully something more useful than sending "
                    + "silly output to the console. :)");

            Thread.sleep(1000);

            messageConsumer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AsynchMessReceiver().getMessages();
    }
}
