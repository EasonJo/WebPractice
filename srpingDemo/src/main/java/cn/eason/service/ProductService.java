package cn.eason.service;

import cn.eason.domain.Items;

import java.util.List;

/**
 * @author Eason
 * @date Create in 16:09 20/04/2018
 */
public interface ProductService {

    List<Items> getAllProducts();

    Items findItemsById(Integer id);

    void updateItems(Items items);
}
