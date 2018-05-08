package cn.e3mall.activemq;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Eason
 * @date Create in 11:33 28/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-service.xml", "classpath:applicationContext_mybatis.xml"})
public class MessageConsumer {

    public void msgConsume() {

    }
}
