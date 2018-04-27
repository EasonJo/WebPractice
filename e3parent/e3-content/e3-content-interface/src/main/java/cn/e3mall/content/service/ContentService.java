package cn.e3mall.content.service;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbContent;

import java.util.List;

/**
 * @author Eason
 * @date Create in 14:44 26/04/2018
 */
public interface ContentService {

    /**
     * 添加商品信息
     * @param content {@link TbContent} 商品信息
     * @return {@link E3Result} 结果封装集
     */
    E3Result addContent(TbContent content);

    List<TbContent> getContentListByCid(long cid);
}
