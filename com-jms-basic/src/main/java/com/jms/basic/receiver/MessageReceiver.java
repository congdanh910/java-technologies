package com.jms.basic.receiver;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by CongDanh on 8/13/15.
 */
public class MessageReceiver {

    private static ConnectionFactory connectionFactory;
    private static Queue queue;

    public void getMessages() {
        Connection connection;
        MessageConsumer messageConsumer;
        TextMessage textMessage;
        boolean goodByeReceived = false;
        try {
            InitialContext ic = new InitialContext();
            connectionFactory = (ConnectionFactory) ic.lookup("jms/GlassFishBookConnectionFactory");
            queue = (Queue) ic.lookup("jms/GlassFishBookQueue");

            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageConsumer = session.createConsumer(queue);
            connection.start();

            while (!goodByeReceived) {
                System.out.println("Waiting for messages...");
                textMessage = (TextMessage) messageConsumer.receive();
                if (textMessage != null) {
                    System.out.print("Received the following message: ");
                    System.out.println(textMessage.getText());
                    System.out.println();
                }
                if (textMessage.getText() != null && textMessage.getText().equals("Good bye!")) {
                    goodByeReceived = true;
                }
            }
            messageConsumer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageReceiver().getMessages();
    }
}
