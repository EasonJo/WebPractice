package cn.e3mall.content.service.impl;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 13:53 27/04/2018
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext_service.xml", "classpath:applicationContext_mybatis.xml",
    "classpath:spring/applicationContext_jedis.xml"})
public class ContentServiceTest {

    @Resource(name = "contentService")
    private ContentService contentService;

    @Test
    public void getContentByCidTest() {
        List<TbContent> tbContents = contentService.getContentListByCid(0l);
        System.out.println(tbContents);
    }
}
