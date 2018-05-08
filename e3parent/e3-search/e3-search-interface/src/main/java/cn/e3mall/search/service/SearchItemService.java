package cn.e3mall.search.service;

import cn.e3mall.common.utils.E3Result;

/**
 * @author Eason
 */
public interface SearchItemService {

    /**
     * 导入商品的索引
     *
     * @return {@link E3Result}
     */
    E3Result importAllItems();
}
