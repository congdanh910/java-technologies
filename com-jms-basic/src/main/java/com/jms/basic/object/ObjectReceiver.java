package com.jms.basic.object;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by CongDanh on 8/14/15.
 */
public class ObjectReceiver {
    private ConnectionFactory connectionFactory;
    private Queue queue;

    public void getObjectMessage() {
        Connection connection;
        MessageConsumer messageConsumer;
        Message message;
        try {
            InitialContext ic = new InitialContext();
            connectionFactory = (ConnectionFactory) ic.lookup("jms/GlassFishBookConnectionFactory");
            queue = (Queue) ic.lookup("jms/GlassFishBookQueue");

            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageConsumer = session.createConsumer(queue);
            connection.start();

            System.out.println("Waiting for object messages...");

            message = messageConsumer.receive();
            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;

                Object object = objectMessage.getObject();
                System.out.println("Read Object Message Result : " + (Student) object);
            }

            messageConsumer.close();
            session.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ObjectReceiver().getObjectMessage();
    }
}
