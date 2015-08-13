package com.jms.basic.browser;

/**
 * Created by CongDanh on 8/13/15.
 */

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class MessageQueueBrowser {
    private static ConnectionFactory connectionFactory;
    private static Queue queue;

    public void browseMessages() {
        try {

            InitialContext ic = new InitialContext();
            connectionFactory = (ConnectionFactory) ic.lookup("jms/GlassFishBookConnectionFactory");
            queue = (Queue) ic.lookup("jms/GlassFishBookQueue");

            Enumeration messageEnumeration;
            TextMessage textMessage;
            Connection connection = connectionFactory.createConnection();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueBrowser browser = session.createBrowser(queue);

            messageEnumeration = browser.getEnumeration();
            if (messageEnumeration != null) {
                if (!messageEnumeration.hasMoreElements()) {
                    System.out.println("There are no messages " + "in the queue.");
                } else {
                    System.out.println("The following messages are in the queue:");
                    while (messageEnumeration.hasMoreElements()) {
                        textMessage = (TextMessage) messageEnumeration.nextElement();
                        System.out.println(textMessage.getText());
                    }
                }
            }
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageQueueBrowser().browseMessages();
    }
}
