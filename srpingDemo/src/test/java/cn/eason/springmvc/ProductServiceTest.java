package cn.eason.springmvc;

import cn.eason.domain.Items;
import cn.eason.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 16:15 20/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:spring_mybatis.xml"})
public class ProductServiceTest {

    @Resource(name = "productService")
    public ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<Items> items = productService.getAllProducts();
        System.out.println(items);
    }
}
