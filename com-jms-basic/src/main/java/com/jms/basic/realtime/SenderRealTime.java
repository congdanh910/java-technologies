package com.jms.basic.realtime;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by CongDanh on 8/8/15.
 */
public class SenderRealTime {

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

            int i = 0;
            while (i < 100) {
                textMessage.setText("Testing ...   " + i);
                System.out.println("Sending the following message: " + textMessage.getText());
                messageProducer.send(textMessage);
                Thread.sleep(3000);
                i++;
            }
            messageProducer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SenderRealTime().produceMessages();
    }
}
