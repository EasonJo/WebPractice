package cn.eason.dao;

import cn.eason.domain.Items;

import java.util.List;

/**
 * @author Eason
 * @date Create in 16:10 20/04/2018
 */
public interface ProductDao {

    List<Items> getAllItems();

    Items findItemsById(Integer id);

    void updateItems(Items items);
}
