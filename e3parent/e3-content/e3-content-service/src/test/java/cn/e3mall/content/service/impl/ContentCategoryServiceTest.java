package cn.e3mall.content.service.impl;

import cn.e3mall.common.pojo.EasyUITreeNote;
import cn.e3mall.content.service.ContentCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 17:07 25/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext_service.xml","classpath:applicationContext_mybatis.xml"})
public class ContentCategoryServiceTest {

    @Resource(name = "contentCategoryService")
    private ContentCategoryService contentCategoryService;

    @Test
    public void getContentCatListTest() {
        List<EasyUITreeNote> easyUITreeNoteList =  contentCategoryService.getContentCatList(0l);
        System.out.println(easyUITreeNoteList);
    }
}
