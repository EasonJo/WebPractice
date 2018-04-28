package cn.e3mall.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * @author Eason
 * @date Create in 11:09 28/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext_service.xml","classpath:applicationContext_mybatis.xml"})
public class ActiveMqSpring {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "queueDestination")
    private Queue queueDestination;

    @Resource(name = "topicDestination")
    private Topic topicDestination;


    @Test
    public void sendMessage(){
        jmsTemplate.send(queueDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("send activeMq Message");
            }
        });
    }



}
