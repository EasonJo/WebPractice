package cn.eason.service;

import cn.eason.domain.Items;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 16:42 20/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring_mybatis.xml"})
public class ProductServiceTest {

    @Resource(name = "productService")
    private ProductService productService;

    @Test
    public void getAllProducts() {
        List<Items> items = productService.getAllProducts();
        System.out.println(items);
    }

    @Test
    public void findItemsById() {
        Items items = productService.findItemsById(1);
        System.out.println(items);
    }

    @Test
    public void updateItems() {
    }
}