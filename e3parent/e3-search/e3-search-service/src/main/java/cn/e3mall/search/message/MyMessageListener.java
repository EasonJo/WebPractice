package cn.e3mall.search.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Eason
 * @date Create in 11:28 28/04/2018
 */
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
        TextMessage textMessage = (TextMessage) message;

        try {
            String text = textMessage.getText();
            System.out.println(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
