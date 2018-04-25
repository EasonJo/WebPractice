package cn.e3mall.mapper;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Eason
 * @date Create in 09:43 24/04/2018
 */
public class MappterTest {

    public ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("applicationContext_mybatis.xml");
    }

    @Test
    public void fun1() {
        TbItemMapper tbItemMapper = context.getBean(TbItemMapper.class);
        TbItemExample example = new TbItemExample();

        TbItemExample.Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andIdEqualTo(605616L);
        //执行查询
        List<TbItem> list = tbItemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            TbItem tbItem = list.get(0);
            System.out.println(tbItem);
        }
    }

    @Test
    public void testPage() {
        TbItemMapper tbItemMapper = context.getBean(TbItemMapper.class);
        TbItemExample example = new TbItemExample();

        PageHelper.startPage(1, 10);
        List<TbItem> items = tbItemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(items.size());
    }
}
