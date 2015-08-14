package com.jms.basic.realtime;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by danh.ho on 14/08/2015.
 */
public class Test {
    private ConnectionFactory connectionFactory;
    private Queue queue;


    public void realTimeReading() {
        Connection connection;
        MessageConsumer messageConsumer;
        Session session;
        try {
            InitialContext context = new InitialContext();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }
}
