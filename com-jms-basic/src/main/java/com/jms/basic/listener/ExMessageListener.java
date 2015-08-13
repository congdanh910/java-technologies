package com.jms.basic.listener;

/**
 * Created by CongDanh on 8/13/15.
 */

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ExMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.print("MessageListener Received the following message: ");
            System.out.println(textMessage.getText());
            System.out.println();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

