package com.jms.basic.object;

import javax.jms.*;
import javax.naming.InitialContext;
import java.util.Date;

/**
 * Created by CongDanh on 8/14/15.
 */
public class ObjectSender {

    private ConnectionFactory connectionFactory;
    private Queue queue;

    public void sendObjectMessage() {
        Connection connection;
        Session session;
        MessageProducer messageProducer;
        ObjectMessage objectMessage;
        try {
            InitialContext ic = new InitialContext();
            connectionFactory = (ConnectionFactory) ic.lookup("jms/GlassFishBookConnectionFactory");
            queue = (Queue) ic.lookup("jms/GlassFishBookQueue");

            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(queue);
            objectMessage = session.createObjectMessage();

            Student student = new Student("001", "Danh Ho", "Tien Giang", new Date());
            objectMessage.setObject(student);
            messageProducer.send(objectMessage);

            messageProducer.close();
            session.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] agrs) {
        new ObjectSender().sendObjectMessage();
    }
}
