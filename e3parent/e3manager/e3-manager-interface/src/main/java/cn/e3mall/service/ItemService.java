package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataResult;
import cn.e3mall.pojo.TbItem;

/**
 * @author Eason
 */
public interface ItemService {

    /**
     * 根据 Item id 查询商品
     *
     * @param itemId 商品 id
     * @return {@link TbItem}
     */
    TbItem getItemById(long itemId);

    /**
     * 分页查询
     *
     * @param page 页数
     * @param size 条数
     * @return {@link EasyUIDataResult}
     */
    EasyUIDataResult<TbItem> getItemList(int page, int size);
}
