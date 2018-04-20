package cn.eason.service.impl;

import cn.eason.dao.ProductDao;
import cn.eason.domain.Items;
import cn.eason.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 16:14 20/04/2018
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation =
    Propagation.REQUIRED, rollbackFor = Exception.class)
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource(name = "productDao")
    private ProductDao productDao;

    @Override
    public List<Items> getAllProducts() {
        return productDao.getAllItems();
    }

    @Override
    public Items findItemsById(Integer id) {
        return productDao.findItemsById(id);
    }

    @Override
    public void updateItems(Items items) {
        productDao.updateItems(items);
    }
}
