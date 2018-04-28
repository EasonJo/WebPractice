package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;

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

    /**
     * 插入商品信息
     * @param item {@link TbItem}
     * @param desc 商品描述
     * @return 插入的商品
     */
    E3Result addItem(TbItem item,String desc);

    TbItemDesc getItemDescById(long itemId);
}
