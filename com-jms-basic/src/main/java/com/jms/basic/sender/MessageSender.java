package com.jms.basic.sender;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by CongDanh on 8/8/15.
 */
public class MessageSender {

    private ConnectionFactory connectionFactory;
    private Queue queue;

    public void produceMessages() {
        MessageProducer messageProducer;
        TextMessage textMessage;
        try {
            InitialContext ic = new InitialContext();
            connectionFactory = (ConnectionFactory) ic.lookup("jms/GlassFishBookConnectionFactory");
            queue = (Queue) ic.lookup("jms/GlassFishBookQueue");

            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(queue);
            textMessage = session.createTextMessage();

            textMessage.setText("Testing, 1, 2, 3. Can you hear me?");
            System.out.println("Sending the following message: " + textMessage.getText());
            messageProducer.send(textMessage);

            textMessage.setText("Do you copy?");
            System.out.println("Sending the following message: " + textMessage.getText());
            messageProducer.send(textMessage);

            textMessage.setText("Good bye!");
            System.out.println("Sending the following message: " + textMessage.getText());
            messageProducer.send(textMessage);

            messageProducer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSender().produceMessages();
    }
}
